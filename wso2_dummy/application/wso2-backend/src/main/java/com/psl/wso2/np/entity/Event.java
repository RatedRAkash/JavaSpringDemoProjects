package com.psl.wso2.np.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "event_time")
    private Date eventTime;

    @Column(name = "event_type", length = 20, nullable = false)
    private String eventType;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "root_event", columnDefinition = "text")
    private String rootEvent;

    @Column(length = 20, nullable = false)
    private String status;

    @Column(length = 50)
    private String title;


    public Event() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getRootEvent() {
        return rootEvent;
    }

    public void setRootEvent(String rootEvent) {
        this.rootEvent = rootEvent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("body", body)
                .add("eventTime", eventTime)
                .add("eventType", eventType)
                .add("mobileNo", mobileNo)
                .add("rootEvent", rootEvent)
                .add("status", status)
                .add("title", title)
                .toString();
    }
}
