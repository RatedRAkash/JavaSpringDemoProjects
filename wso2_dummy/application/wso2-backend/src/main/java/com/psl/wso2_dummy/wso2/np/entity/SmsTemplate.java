package com.psl.wso2_dummy.wso2.np.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sms_template")
public class SmsTemplate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String type;

    @Column(name = "from_body", length = 200)
    private String fromBody;

    @Column(name = "to_body", length = 200)
    private String toBody;

    @Column(name = "from_sms", nullable = false)
    private boolean fromSms;

    @Column(name = "to_sms", nullable = false)
    private boolean toSms;

    @Column(name = "error_code")
    private Integer errorCode;


    public SmsTemplate() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFromBody() {
        return fromBody;
    }

    public void setFromBody(String fromBody) {
        this.fromBody = fromBody;
    }

    public String getToBody() {
        return toBody;
    }

    public void setToBody(String toBody) {
        this.toBody = toBody;
    }

    public boolean isFromSms() {
        return fromSms;
    }

    public void setFromSms(boolean fromSms) {
        this.fromSms = fromSms;
    }

    public boolean isToSms() {
        return toSms;
    }

    public void setToSms(boolean toSms) {
        this.toSms = toSms;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("type", type)
                .add("fromBody", fromBody)
                .add("toBody", toBody)
                .add("fromSms", fromSms)
                .add("toSms", toSms)
                .add("errorCode", errorCode)
                .toString();
    }
}
