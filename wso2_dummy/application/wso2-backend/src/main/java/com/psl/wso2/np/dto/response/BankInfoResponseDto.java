package com.psl.wso2.np.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankInfoResponseDto implements Serializable {
    private String bankCode;
    private String swiftCode;
    private String bankName;
    private String bankNameBn;
    private Boolean active;

    //for Deserializing we need Empty Constructor
    public BankInfoResponseDto() {

    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getBankNameBn() {
        return bankNameBn;
    }

    public void setBankNameBn(String bankNameBn) {
        this.bankNameBn = bankNameBn;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("swiftCode", swiftCode)
                .add("bankName", bankName)
                .add("active", active)
                .toString();
    }
}
