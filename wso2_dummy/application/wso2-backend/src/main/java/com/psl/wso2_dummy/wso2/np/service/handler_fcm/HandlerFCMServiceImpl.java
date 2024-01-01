package com.psl.wso2_dummy.wso2.np.service.handler_fcm;

import com.psl.wso2_dummy.wso2.np.dto.entity_projection.DeviceDataProjection;
import com.psl.wso2_dummy.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;
import com.psl.wso2_dummy.wso2.np.dto.response.FCMResponseDto;
import com.psl.wso2_dummy.wso2.np.entity.DeviceData;
import com.psl.wso2_dummy.wso2.np.repository.DeviceDataRepository;
import com.psl.wso2_dummy.wso2.np.service.fcm.FCMService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psl.np.common.error.NpException;

import java.util.List;

@Service
public class HandlerFCMServiceImpl implements HandlerFCMService {
    private static final Logger logger = LogManager.getLogger(HandlerFCMServiceImpl.class);

    private DeviceDataRepository deviceDataRepository;
    private FCMService fcmService;

    @Autowired
    public HandlerFCMServiceImpl(DeviceDataRepository deviceDataRepository, FCMService fcmService) {
        this.deviceDataRepository = deviceDataRepository;
        this.fcmService = fcmService;
    }


    @Override
    public void processMessageForSendingToFCMService(PushTemplateFormattedDto pushTemplateFormattedDto) {
        logger.info("Processing Message for FCMService: " + pushTemplateFormattedDto.toString());

        String uri_var_mobileNo = pushTemplateFormattedDto.getMobileNo();
        PushTemplateFormattedDto inputJson = pushTemplateFormattedDto;

        List<DeviceDataProjection> deviceDataList = deviceDataRepository.fcmSearchQuery(uri_var_mobileNo);

        if (deviceDataList.size() > 0) {
            logger.info("Received FCM Token for Mobile: " + uri_var_mobileNo);
            String fcmToken = deviceDataList.get(0).getFcmToken();
            try {
                logger.info("Sending Message to Goolge FCM Server");
                FCMResponseDto fcmResponseDto = fcmService.send(inputJson, fcmToken);
                logger.info("FCM Token ---> Success: " + fcmResponseDto.getSuccess() + ", Failure:" + fcmResponseDto.getFailure());
            }
            catch (NpException e) {
                logger.info("Error Calling Google FCM Server");
                e.printStackTrace();
            }

        }else{
            logger.info("No FCM Token found for Mobile: " + uri_var_mobileNo);
        }
    }
}
