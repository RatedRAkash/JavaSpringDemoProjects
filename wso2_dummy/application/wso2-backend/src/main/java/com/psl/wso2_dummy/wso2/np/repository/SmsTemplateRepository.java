package com.psl.wso2_dummy.wso2.np.repository;

import com.psl.wso2_dummy.wso2.np.entity.SmsTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SmsTemplateRepository extends JpaRepository<SmsTemplate, Long> {
    @Query(value = "SELECT p FROM SmsTemplate p WHERE p.errorCode IS NULL AND p.type = :type")
    List<SmsTemplate> smsTemplateQuery(@Param("type") String type);

    @Query(value = "SELECT p FROM SmsTemplate p WHERE p.errorCode = :errorCode")
    List<SmsTemplate> smsTemplateByCodeQuery(@Param("errorCode") Integer errorCode);
}