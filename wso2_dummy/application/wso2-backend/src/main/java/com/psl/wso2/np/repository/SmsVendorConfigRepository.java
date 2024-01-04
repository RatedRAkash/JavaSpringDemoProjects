package com.psl.wso2.np.repository;

import com.psl.wso2.np.dto.entity_projection.SmsVendorConfigProjection;
import com.psl.wso2.np.entity.SmsResponseLog;
import com.psl.wso2.np.entity.SmsVendorConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SmsVendorConfigRepository extends JpaRepository<SmsVendorConfig, Long> {

    @Query(value = "SELECT tvc.identifier FROM sms_vendor_config tvc " +
            "INNER JOIN telco_wise_sms_vendor tt ON tt.vendor_config_id = tvc.id " +
            "WHERE tt.active = true AND tt.operator = :operator", nativeQuery = true)
    List<String> getVendorIdentifier(@Param("operator") String operator);

    @Query("SELECT NEW com.psl.wso2.np.dto.entity_projection.SmsVendorConfigProjection(s.id, s.baseUrl, s.userName, s.password, s.mask) " +
            "FROM SmsVendorConfig s WHERE s.active = TRUE AND s.identifier = :identifier")
    SmsVendorConfigProjection getSmsConfig(@Param("identifier") String identifier);
}
