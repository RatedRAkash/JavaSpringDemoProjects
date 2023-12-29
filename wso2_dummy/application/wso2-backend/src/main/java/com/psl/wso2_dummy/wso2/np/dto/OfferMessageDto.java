package com.psl.wso2_dummy.wso2.np.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferMessageDto implements Serializable {
    private OfferMsgDto offerMsg;

    public OfferMsgDto getOfferMsg() {
        return offerMsg;
    }

    public void setOfferMsg(OfferMsgDto offerMsg) {
        this.offerMsg = offerMsg;
    }

    @Override
    public String toString() {
        return "OfferMessageDto {" +
                "offerMsg=" + offerMsg +
                '}';
    }
}