package com.psl.wso2.np.dto.formatted_dto.producer_obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.psl.wso2.np.constant.EnumConstant;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsRequestQueueFormattedDto implements Serializable {

    //in ESB it is reffered as txnType(though we are passing the `EVENT` from HandlerTxnSmsService)
    private EnumConstant.EventType txnType;
    private String mobileNo;
    private String msgBody;

    public SmsRequestQueueFormattedDto() {

    }

    public SmsRequestQueueFormattedDto(EnumConstant.EventType txnType, String mobileNo, String msgBody) {
        this.txnType = txnType;
        this.mobileNo = mobileNo;
        this.msgBody = msgBody;
    }

    public EnumConstant.EventType getTxnType() {
        return txnType;
    }

    public void setTxnType(EnumConstant.EventType event) {
        this.txnType = event;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    @Override
    public String toString() {
        return "SmsRequestFormattedDto {" +
                "event=" + txnType +
                ", mobileNo='" + mobileNo + '\'' +
                ", msgBody='" + msgBody + '\'' +
                '}';
    }
}