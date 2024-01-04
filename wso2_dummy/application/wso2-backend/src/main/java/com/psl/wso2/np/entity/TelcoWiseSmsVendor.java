package com.psl.wso2.np.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "telco_wise_sms_vendor")
public class TelcoWiseSmsVendor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "operator", length = 30, nullable = false)
    private String operator;

    @Column(name = "update_date")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "vendor_config_id", referencedColumnName = "id", nullable = false)
    private SmsVendorConfig vendorConfig;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public SmsVendorConfig getVendorConfig() {
        return vendorConfig;
    }

    public void setVendorConfig(SmsVendorConfig vendorConfig) {
        this.vendorConfig = vendorConfig;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("active", active)
                .add("createDate", createDate)
                .add("operator", operator)
                .add("updateDate", updateDate)
                .add("vendorConfig", vendorConfig)
                .toString();
    }
}
