package com.psl.wso2.np.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sms_response_log")
public class SmsResponseLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String activity;


    //TODO hala madrid: existing DB te default valie "now()"
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(length = 30, nullable = false)
    private String identifier;

    @Column(name = "message_body")
    private String messageBody;

    @Column(name = "mobile_no", length = 13, nullable = false)
    private String mobileNo;

    @Column(name = "response_text", length = 500)
    private String responseText;

    @Column(name = "sms_count", nullable = false)
    private Integer smsCount;

    @Column()
    private String status;

    @Column(name = "response_code", nullable = false)
    private Integer responseCode;

    public SmsResponseLog() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public Integer getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(Integer smsCount) {
        this.smsCount = smsCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("activity", activity)
                .add("createDate", createDate)
                .add("identifier", identifier)
                .add("messageBody", messageBody)
                .add("mobileNo", mobileNo)
                .add("responseText", responseText)
                .add("smsCount", smsCount)
                .add("status", status)
                .add("responseCode", responseCode)
                .toString();
    }
}
