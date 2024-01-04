package com.psl.wso2.np.repository;

import com.psl.wso2.np.dto.entity_projection.SmsTemplateProjection;
import com.psl.wso2.np.entity.SmsTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SmsTemplateRepository extends JpaRepository<SmsTemplate, Long> {

    @Query("SELECT NEW com.psl.wso2.np.dto.entity_projection.SmsTemplateProjection(p.fromBody, p.toBody, p.fromSms, p.toSms) " +
            "FROM SmsTemplate p WHERE p.errorCode IS NULL AND p.type = :type")
    List<SmsTemplateProjection> smsTemplateQuery(@Param("type") String type);

    @Query("SELECT NEW com.psl.wso2.np.dto.entity_projection.SmsTemplateProjection(p.fromBody, p.toBody, p.fromSms, p.toSms) " +
            "FROM SmsTemplate p WHERE p.errorCode = :errorCode")
    List<SmsTemplateProjection> smsTemplateByCodeQuery(@Param("errorCode") Integer errorCode);
}