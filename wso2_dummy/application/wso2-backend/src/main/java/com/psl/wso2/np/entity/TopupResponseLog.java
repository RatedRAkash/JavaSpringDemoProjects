package com.psl.wso2.np.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "topup_response_log")
public class TopupResponseLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "customer_wallet", length = 11, nullable = false)
    private String customerWallet;

    @Column(length = 30)
    private String identifier;

    @Column(length = 30, nullable = false)
    private String operator;

    @Column(name = "reference_id")
    private String referenceId;

    @Column(name = "request_text")
    private String requestText;

    //TODO hala madrid: existing DB te default valie "now()"
    @Column(name = "request_time")
    private Date requestTime;

    @Column(name = "response_code")
    private Integer responseCode;

    @Column(name = "response_text")
    private String responseText;

    @Column(length = 50, nullable = false)
    private String status;

    @Column(name = "trxn_id")
    private String trxnId;

    @Column(name = "update_date")
    private Date updateDate;

    public TopupResponseLog() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCustomerWallet() {
        return customerWallet;
    }

    public void setCustomerWallet(String customerWallet) {
        this.customerWallet = customerWallet;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrxnId() {
        return trxnId;
    }

    public void setTrxnId(String trxnId) {
        this.trxnId = trxnId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("createDate", createDate)
                .add("customerWallet", customerWallet)
                .add("identifier", identifier)
                .add("operator", operator)
                .add("referenceId", referenceId)
                .add("requestText", requestText)
                .add("requestTime", requestTime)
                .add("responseCode", responseCode)
                .add("responseText", responseText)
                .add("status", status)
                .add("trxnId", trxnId)
                .add("updateDate", updateDate)
                .toString();
    }
}
