package com.psl.wso2.np.repository;

import com.psl.wso2.np.dto.entity_projection.SmsVendorConfigProjection;
import com.psl.wso2.np.entity.SmsResponseLog;
import com.psl.wso2.np.entity.SmsVendorConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SmsResponseLogRepository extends JpaRepository<SmsResponseLog, Long> {

    //save() ---> this Method is Automatically handled by Spring Data JPA
}
