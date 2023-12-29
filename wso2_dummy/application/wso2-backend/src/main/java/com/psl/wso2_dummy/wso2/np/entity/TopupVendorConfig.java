package com.psl.wso2_dummy.wso2.np.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "topup_vendor_config")
public class TopupVendorConfig implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean active;

    @Column(name = "auth_params", length = 255)
    private String authParams;

    @Column(name = "base_url", length = 100)
    private String baseUrl;

    @Column(name = "create_date")
    private Date createDate;

    @Column(length = 30)
    private String identifier;

    @Column(length = 255)
    private String password;

    private Integer priority;

    @Column(name = "refresh_token", columnDefinition = "text")
    private String refreshToken;

    @Column(columnDefinition = "text")
    private String token;

    @Column(name = "token_type", length = 255)
    private String tokenType;


    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "user_name", length = 255)
    private String userName;

    @Column(length = 20)
    private String wallet;

    @Column(name = "failure_limit")
    private Integer failureLimit;

    public TopupVendorConfig() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAuthParams() {
        return authParams;
    }

    public void setAuthParams(String authParams) {
        this.authParams = authParams;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public Integer getFailureLimit() {
        return failureLimit;
    }

    public void setFailureLimit(Integer failureLimit) {
        this.failureLimit = failureLimit;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("active", active)
                .add("authParams", authParams)
                .add("baseUrl", baseUrl)
                .add("createDate", createDate)
                .add("identifier", identifier)
                .add("password", password)
                .add("priority", priority)
                .add("refreshToken", refreshToken)
                .add("token", token)
                .add("tokenType", tokenType)
                .add("updateDate", updateDate)
                .add("userName", userName)
                .add("wallet", wallet)
                .add("failureLimit", failureLimit)
                .toString();
    }
}
