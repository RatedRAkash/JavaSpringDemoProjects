package psl.np.dataModel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import psl.np.dataModel.constant.EnumConstant.TransactionType;

import java.io.Serializable;
import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
public class EventOriginDto implements Serializable {
    private String txnId;

    private String fromAccount;

    private TransactionType txnType;

    private BigDecimal amount;

    private String accountNo;

    private String referenceId;

    private String status;

    private String message;

    private String bank;

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

    @Override
    public String toString() {
        return "EventOrigin{" +
                "txnId='" + txnId + '\'' +
                ", fromAccount='" + fromAccount + '\'' +
                ", txnType=" + txnType +
                ", amount=" + amount +
                ", accountNo='" + accountNo + '\'' +
                ", referenceId='" + referenceId + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }
}
