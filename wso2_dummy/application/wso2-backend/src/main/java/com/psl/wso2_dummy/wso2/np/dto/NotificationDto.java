package com.psl.wso2_dummy.wso2.np.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.psl.wso2_dummy.wso2.np.constant.EnumConstant.*;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationDto implements Serializable {

    private EventType eventType;
    private TransactionType eventSubType;

    private EventOriginDto eventOrigin;

    private Boolean shouldSendNotification;

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

    public Boolean getShouldSendNotification() {
        return shouldSendNotification;
    }

    public void setShouldSendNotification(Boolean shouldSendNotification) {
        this.shouldSendNotification = shouldSendNotification;
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
        return "NotificationDto{" +
                "eventType=" + eventType +
                ", eventSubType=" + eventSubType +
                ", eventOrigin=" + eventOrigin +
                ", shouldSendNotification=" + shouldSendNotification +
                ", checkOfferOnly=" + checkOfferOnly +
                ", location=" + location +
                '}';
    }
}
