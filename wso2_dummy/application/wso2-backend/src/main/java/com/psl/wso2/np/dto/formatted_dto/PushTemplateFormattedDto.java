package com.psl.wso2.np.dto.formatted_dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.psl.wso2.np.dto.EventOriginDto;
import com.psl.wso2.np.constant.EnumConstant;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PushTemplateFormattedDto implements Serializable {
    private EnumConstant.EventType eventType;
    private String mobileNo;
    private String title;
    private String body;
    private EventOriginDto eventOrigin;

    // Can be NULL, these two are used for "CASH_OUT_TO_BANK" case
    private String eventPublisher;//"SCHEDULER", "API"

    // Can be NULL
    private String eventTime;

    public PushTemplateFormattedDto() {

    }

    public PushTemplateFormattedDto(EnumConstant.EventType eventType, String mobileNo, String title, String body, EventOriginDto eventOrigin) {
        this.eventType = eventType;
        this.mobileNo = mobileNo;
        this.title = title;
        this.body = body;
        this.eventOrigin = eventOrigin;
    }

    // Constructor with eventPublisher & eventTime
    public PushTemplateFormattedDto(EnumConstant.EventType eventType, String mobileNo, String title, String body, EventOriginDto eventOrigin, String eventPublisher, String eventTime) {
        this.eventType = eventType;
        this.mobileNo = mobileNo;
        this.title = title;
        this.body = body;
        this.eventOrigin = eventOrigin;
        this.eventPublisher = eventPublisher;
        this.eventTime = eventTime;
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

    public String getEventPublisher() {
        return eventPublisher;
    }

    public void setEventPublisher(String eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return "PushTemplateFormattedDto {" +
                "eventType=" + eventType +
                ", mobileNo='" + mobileNo + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", eventOrigin=" + eventOrigin +
                ", eventPublisher='" + eventPublisher + '\'' +
                ", eventTime='" + eventTime + '\'' +
                '}';
    }
}
