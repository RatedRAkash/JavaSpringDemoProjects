package com.psl.wso2_dummy.wso2.np.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferMsgDto implements Serializable {
    private String pushTitle;

    private String pushBody;

    public String getPushTitle() {
        return pushTitle;
    }

    public void setPushTitle(String pushTitle) {
        this.pushTitle = pushTitle;
    }

    public String getPushBody() {
        return pushBody;
    }

    public void setPushBody(String pushBody) {
        this.pushBody = pushBody;
    }

    @Override
    public String toString() {
        return "OfferMsgDto {" +
                "pushTitle='" + pushTitle + '\'' +
                ", pushBody='" + pushBody + '\'' +
                '}';
    }
}