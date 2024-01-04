package com.psl.wso2.np.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.psl.wso2.np.constant.EnumConstant.*;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationDto implements Serializable {

    private EventType eventType;
    private TransactionType eventSubType;
    private EventOriginDto eventOrigin;
    private String eventPublisher;//"SCHEDULER", "API"
    private String eventTime;
    private Boolean sendNotification;
    private Boolean checkOfferOnly;
    private LocationDto location;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public TransactionType getEventSubType() {
        return eventSubType;
    }

    public void setEventSubType(TransactionType eventSubType) {
        this.eventSubType = eventSubType;
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

    public Boolean getSendNotification() {
        return sendNotification;
    }

    public void setSendNotification(Boolean sendNotification) {
        this.sendNotification = sendNotification;
    }

    public Boolean getCheckOfferOnly() {
        return checkOfferOnly;
    }

    public void setCheckOfferOnly(Boolean checkOfferOnly) {
        this.checkOfferOnly = checkOfferOnly;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "NotificationDto {" +
                "eventType=" + eventType +
                ", eventSubType=" + eventSubType +
                ", eventOrigin=" + eventOrigin +
                ", eventPublisher='" + eventPublisher + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", sendNotification=" + sendNotification +
                ", checkOfferOnly=" + checkOfferOnly +
                ", location=" + location +
                '}';
    }
}
