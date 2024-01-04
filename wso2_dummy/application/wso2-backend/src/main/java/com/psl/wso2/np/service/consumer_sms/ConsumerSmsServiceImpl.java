package com.psl.wso2.np.service.consumer_sms;

import com.psl.wso2.np.client.MOBIREACHApiClient;
import com.psl.wso2.np.client.TallykhataApiClient;
import com.psl.wso2.np.constant.ConfigConstant;
import com.psl.wso2.np.constant.EnumConstant.*;
import com.psl.wso2.np.dto.entity_projection.SmsVendorConfigProjection;
import com.psl.wso2.np.dto.formatted_dto.producer_obj.SmsRequestQueueFormattedDto;
import com.psl.wso2.np.dto.request.TallykhataVendorRequestDto;
import com.psl.wso2.np.dto.response.TallykhataVendorResponseDto;
import com.psl.wso2.np.dto.response.MobireachResponseDto;
import com.psl.wso2.np.entity.SmsResponseLog;
import com.psl.wso2.np.service.api_service.sms_config.SmsConfigApiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psl.np.common.error.NpException;
import psl.np.common.restClient.BasicAuthInterceptor;
import retrofit2.Response;

import java.util.Date;

import static psl.np.common.utils.NpUtils.extractBaseUrl;
import static psl.np.common.utils.NpUtils.extractPath;

@Service
public class ConsumerSmsServiceImpl implements ConsumerSmsService {
    private static final Logger logger = LogManager.getLogger(ConsumerSmsService.class);
    private final SmsConfigApiService smsConfigApiService;
    private final MOBIREACHApiClient mobireachApiClient;
    private final TallykhataApiClient tallykhataApiClient;

    @Autowired
    public ConsumerSmsServiceImpl(SmsConfigApiService smsConfigApiService, MOBIREACHApiClient mobireachApiClient, TallykhataApiClient tallykhataApiClient) {
        this.smsConfigApiService = smsConfigApiService;
        this.mobireachApiClient = mobireachApiClient;
        this.tallykhataApiClient = tallykhataApiClient;
    }


    @Override
    public void processConsumedSms(SmsRequestQueueFormattedDto smsRequestQueueFormattedDto) {
        logger.info("ConsumerSms processing request: " + smsRequestQueueFormattedDto.toString());
        //TODO: hala madrid
        String SMS_VENDOR = this.smsConfigApiService.getVendorIdentifierFromOperator(smsRequestQueueFormattedDto.getMobileNo());
        if (SMS_VENDOR == null) {
            logger.info("ERROR IN SMS VENDOR SELECTION");
            return;
        }
        logger.info("VENDOR: " + SMS_VENDOR);

        SmsVendorConfigProjection smsVendorConfigProjection = this.smsConfigApiService.getSmsVendorConfig(SMS_VENDOR);
        if (smsVendorConfigProjection == null) {
            logger.info("ERROR IN SMS VENDOR SELECTION");
            return;
        }
        logger.info("SmsVendorConfigProjection: " + smsVendorConfigProjection.toString());

        SmsResponseLog smsResponseLog = new SmsResponseLog();
        smsResponseLog.setActivity(smsRequestQueueFormattedDto.getTxnType().toString());
        smsResponseLog.setMessageBody(smsRequestQueueFormattedDto.getMsgBody());
        smsResponseLog.setMobileNo(smsRequestQueueFormattedDto.getMobileNo());
        smsResponseLog.setIdentifier(SMS_VENDOR);


        //TODO hala madrid: Check Api Call Later
        if (SMS_VENDOR.equals(SmsVendor.MOBIREACH.toString())) {
            try {
                Response<MobireachResponseDto> responseObjMobireach =
                        mobireachApiClient.createClient(extractBaseUrl(smsVendorConfigProjection.getBaseUrl()))
                                .sendSms(extractPath(smsVendorConfigProjection.getBaseUrl()),
                                        smsVendorConfigProjection.getUserName(),
                                        smsVendorConfigProjection.getPassword(),
                                        smsVendorConfigProjection.getMask(),
                                        smsRequestQueueFormattedDto.getMobileNo(),
                                        smsRequestQueueFormattedDto.getMsgBody());

                smsResponseLog.setStatus(responseObjMobireach.body().getStatusText());
                smsResponseLog.setResponseCode(responseObjMobireach.code());
                smsResponseLog.setResponseText(responseObjMobireach.body().toString());
                smsResponseLog.setSmsCount(responseObjMobireach.body().getSMSCount());

            } catch (NpException e) {
                e.printStackTrace();
                logger.info("Couldn't connect to SMS_VENDOR: " + smsVendorConfigProjection.toString());
                MobireachResponseDto erroMobireachResponseDto = new MobireachResponseDto();
                erroMobireachResponseDto.setStatus(500);
                erroMobireachResponseDto.setStatusText("FAILED");

                //TODO hala madrid: Check Api Call Later
                smsResponseLog.setStatus(erroMobireachResponseDto.getStatusText());
                smsResponseLog.setResponseCode(erroMobireachResponseDto.getStatus());
                smsResponseLog.setResponseText(new MobireachResponseDto().toString());
                smsResponseLog.setSmsCount(0);
            }
        }

        //TODO hala madrid: Check Api Call Later
        else if(SMS_VENDOR.equals(SmsVendor.TALLYKHATA.toString())) {
            String CHANNEL = "";
            if(smsRequestQueueFormattedDto.getTxnType() == EventType.LOGIN){
                CHANNEL = ConfigConstant.TK_OTP_CHANNEL;
            }else{
                CHANNEL = ConfigConstant.TK_TXN_CHANNEL;
            }

            Response<TallykhataVendorResponseDto> responseObjTallykhataVendor;
            try {
                responseObjTallykhataVendor = tallykhataApiClient
                        .createClient(extractBaseUrl(smsVendorConfigProjection.getBaseUrl()),
                                                    new BasicAuthInterceptor(smsVendorConfigProjection.getUserName(), smsVendorConfigProjection.getPassword()))
                        .sendSms(extractPath(smsVendorConfigProjection.getBaseUrl()), new TallykhataVendorRequestDto(smsRequestQueueFormattedDto.getMobileNo(),
                                smsRequestQueueFormattedDto.getMsgBody(), smsRequestQueueFormattedDto.getTxnType().toString(),
                                CHANNEL));
                smsResponseLog.setStatus(responseObjTallykhataVendor.body().getStatusText());
                smsResponseLog.setResponseCode(responseObjTallykhataVendor.code());
                smsResponseLog.setResponseText(responseObjTallykhataVendor.body().toString());
                smsResponseLog.setSmsCount(responseObjTallykhataVendor.body().getSMSCount());


            } catch (NpException e) {
                e.printStackTrace();
                logger.info("Couldn't connect to SMS_VENDOR: " + smsVendorConfigProjection.toString());
                TallykhataVendorResponseDto errotallykhataVendorResponseDto = new TallykhataVendorResponseDto(0, "FAILED");

                //TODO hala madrid: Check Api Call Later
                smsResponseLog.setStatus(errotallykhataVendorResponseDto.getStatusText());
                smsResponseLog.setResponseCode(500);
                smsResponseLog.setResponseText(errotallykhataVendorResponseDto.toString());
                smsResponseLog.setSmsCount(errotallykhataVendorResponseDto.getSMSCount());

                logger.info("Tallykhata Vendor Response: " + errotallykhataVendorResponseDto.toString());
            }

//            smsResponseLog.setStatus(tallykhataVendorResponseDto.getStatusText());
        }

        //TODO hala madrid: ****** Handle ERROR_CODE = 101504 *******


        //Current Date
        smsResponseLog.setCreateDate(new Date());
        SmsResponseLog newSmsResponseLog = smsConfigApiService.saveSmsResponseLog(smsResponseLog);
        logger.info("Saved : " + newSmsResponseLog.toString());
    }
}
