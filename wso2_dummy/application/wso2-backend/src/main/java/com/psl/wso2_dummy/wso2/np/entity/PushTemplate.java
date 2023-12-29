package com.psl.wso2_dummy.wso2.np.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "push_template")
public class PushTemplate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String title;

    @Column(length = 200)
    private String body;

    private boolean active;

    @Column(length = 100)
    private String type;

    @Column(name = "error_code")
    private Integer errorCode;

    public PushTemplate() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                .add("title", title)
                .add("body", body)
                .add("active", active)
                .add("type", type)
                .add("errorCode", errorCode)
                .toString();
    }
}
