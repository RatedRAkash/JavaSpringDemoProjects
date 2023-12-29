package com.psl.wso2_dummy.wso2.np.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.psl.wso2_dummy.wso2.np.constant.EnumConstant.TransactionType;

import java.io.Serializable;
import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
public class EventOriginDto implements Serializable {
    private String txnId;

    private String fromAccount;
    private String toAccount;

    private TransactionType txnType;

    private BigDecimal amount;

    private String accountNo;
    private String mobileNo;
    private String referenceId;

    private String status;

    private String message;

    private String bank;

    private OfferMessageDto offerMessage;


    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public TransactionType getTxnType() {
        return txnType;
    }

    public void setTxnType(TransactionType txnType) {
        this.txnType = txnType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public OfferMessageDto getOfferMessage() {
        return offerMessage;
    }

    public void setOfferMessage(OfferMessageDto offerMessage) {
        this.offerMessage = offerMessage;
    }

    @Override
    public String toString() {
        return "EventOriginDto {" +
                "txnId='" + txnId + '\'' +
                ", fromAccount='" + fromAccount + '\'' +
                ", toAccount='" + toAccount + '\'' +
                ", txnType=" + txnType +
                ", amount=" + amount +
                ", accountNo='" + accountNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", referenceId='" + referenceId + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", bank='" + bank + '\'' +
                ", offerMessage=" + offerMessage +
                '}';
    }
}
