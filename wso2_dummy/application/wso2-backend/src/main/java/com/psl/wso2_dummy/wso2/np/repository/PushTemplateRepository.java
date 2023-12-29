package com.psl.wso2_dummy.wso2.np.repository;

import com.psl.wso2_dummy.wso2.np.entity.PushTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface PushTemplateRepository extends JpaRepository<PushTemplate, Long> {
    @Query(value = "SELECT new map(p.title as title, p.body as body) FROM PushTemplate p WHERE p.active = true AND p.errorCode IS NULL AND p.type = :type")
    PushTemplate wso2messageInfoQuery(@Param("type") String type);


    @Query(value = "SELECT new map(p.title as title, p.body as body) FROM PushTemplate p WHERE p.active = true AND p.errorCode = :error_code")
    PushTemplate wso2messageInfoByCodeQuery(@Param("err_code") Integer error_code);
}