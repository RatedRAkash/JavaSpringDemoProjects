package com.psl.wso2.np.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.psl.wso2.np.constant.ConfigConstant;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TallykhataVendorRequestDto implements Serializable {
    private String mobileNo;
    private String bankName;
    private String messageBody;
    private String txnType;
    private String channel;
    private String txnId;

    public TallykhataVendorRequestDto(String mobileNo, String messageBody, String txnType, String channel) {
        //bankName & txnId is Hardcoded in ESB
        this.mobileNo = mobileNo;
        this.bankName = ConfigConstant.BANK_NAME;
        this.messageBody = messageBody;
        this.txnType = txnType;
        this.channel = channel;
        this.txnId = "";
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    @Override
    public String toString() {
        return "TallykhataVendorRequestDto{" +
                "mobileNo='" + mobileNo + '\'' +
                ", bankName='" + bankName + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", txnType='" + txnType + '\'' +
                ", channel='" + channel + '\'' +
                ", txnId='" + txnId + '\'' +
                '}';
    }
}
