package com.psl.wso2.np.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MobireachResponseDto implements Serializable {
    private Integer Status;
    private Integer SMSCount;
    private String ErrorText;
    private String StatusText;
    private Double CurrentCredit;
    private Integer ErrorCode;
    private Long MessageId;

    //for Deserializing we need Empty Constructor
    public MobireachResponseDto() {

    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public Integer getSMSCount() {
        return SMSCount;
    }

    public void setSMSCount(Integer SMSCount) {
        this.SMSCount = SMSCount;
    }

    public String getErrorText() {
        return ErrorText;
    }

    public void setErrorText(String errorText) {
        ErrorText = errorText;
    }

    public String getStatusText() {
        return StatusText;
    }

    public void setStatusText(String statusText) {
        StatusText = statusText;
    }

    public Double getCurrentCredit() {
        return CurrentCredit;
    }

    public void setCurrentCredit(Double currentCredit) {
        CurrentCredit = currentCredit;
    }

    public Integer getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(Integer errorCode) {
        ErrorCode = errorCode;
    }

    public Long getMessageId() {
        return MessageId;
    }

    public void setMessageId(Long messageId) {
        MessageId = messageId;
    }
    @Override
    public String toString() {
        return "MobireachResponseDto {" +
                "Status=" + Status +
                ", SMSCount=" + SMSCount +
                ", ErrorText='" + ErrorText + '\'' +
                ", StatusText='" + StatusText + '\'' +
                ", CurrentCredit=" + CurrentCredit +
                ", ErrorCode=" + ErrorCode +
                ", MessageId=" + MessageId +
                '}';
    }
}
