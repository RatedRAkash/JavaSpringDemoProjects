package com.psl.wso2_dummy.wso2.np.repository;

import com.psl.wso2_dummy.wso2.np.entity.PushTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PushTemplateRepository extends JpaRepository<PushTemplate, Long> {
    @Query(value = "SELECT p FROM PushTemplate p WHERE p.active = true AND p.errorCode IS NULL AND p.type = :type")
    List<PushTemplate> wso2messageInfoQuery(@Param("type") String type);


    @Query(value = "SELECT p FROM PushTemplate p WHERE p.active = true AND p.errorCode = :error_code")
    List<PushTemplate> wso2messageInfoByCodeQuery(@Param("error_code") Integer error_code);

    //TODO GetSmsTemplate er ($.data.senderSms), ($.data.recieverSms) ========================

}