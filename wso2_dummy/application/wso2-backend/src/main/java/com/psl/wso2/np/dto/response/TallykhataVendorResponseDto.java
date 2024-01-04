package com.psl.wso2.np.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TallykhataVendorResponseDto implements Serializable {
    private Integer SMSCount;
    private String StatusText;

    //for Deserializing we need Empty Constructor
    public TallykhataVendorResponseDto() {

    }

    public TallykhataVendorResponseDto(Integer SMSCount, String statusText) {
        this.SMSCount = SMSCount;
        this.StatusText = statusText;
    }

    public Integer getSMSCount() {
        return SMSCount;
    }

    public void setSMSCount(Integer SMSCount) {
        this.SMSCount = SMSCount;
    }

    public String getStatusText() {
        return StatusText;
    }

    public void setStatusText(String statusText) {
        StatusText = statusText;
    }

    @Override
    public String toString() {
        return "TallykhataVendorResponseDto {" +
                "SMSCount=" + SMSCount +
                ", StatusText='" + StatusText +
                '}';
    }
}
