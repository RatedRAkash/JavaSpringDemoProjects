package com.psl.wso2_dummy.wso2.np.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.psl.wso2_dummy.wso2.np.constant.EnumConstant;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PushTemplateFormattedDto implements Serializable {
    private EnumConstant.EventType eventType;
    private String mobileNo;
    private String title;
    private String body;
    private EventOriginDto eventOrigin;

    public PushTemplateFormattedDto() {

    }

    public PushTemplateFormattedDto(EnumConstant.EventType eventType, String mobileNo, String title, String body, EventOriginDto eventOrigin) {
        this.eventType = eventType;
        this.mobileNo = mobileNo;
        this.title = title;
        this.body = body;
        this.eventOrigin = eventOrigin;
    }

    public EnumConstant.EventType getEventType() {
        return eventType;
    }

    public void setEventType(EnumConstant.EventType eventType) {
        this.eventType = eventType;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public EventOriginDto getEventOrigin() {
        return eventOrigin;
    }

    public void setEventOrigin(EventOriginDto eventOrigin) {
        this.eventOrigin = eventOrigin;
    }

    @Override
    public String toString() {
        return "PushTemplateTitleBodyDto {" +
                "eventType=" + eventType +
                ", mobileNo='" + mobileNo + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", eventOrigin=" + eventOrigin +
                '}';
    }
}
