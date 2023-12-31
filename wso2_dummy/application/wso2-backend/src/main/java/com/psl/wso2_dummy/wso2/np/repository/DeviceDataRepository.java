package com.psl.wso2_dummy.wso2.np.repository;

import com.psl.wso2_dummy.wso2.np.entity.DeviceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeviceDataRepository extends JpaRepository<DeviceData, Long> {
    @Query(value = "SELECT p FROM DeviceData p WHERE p.userId = :type")
    List<DeviceData> fcmSearchQuery(@Param("user_id") String user_id);


    @Modifying
    @Query(value = "INSERT INTO device_data (uuid, device_type, fcm_token, user_id) " +
            "VALUES (:uuid, :deviceType, :fcmToken, :userId)", nativeQuery = true)
    void fcmSaveQuery(
            @Param("uuid") String uuid,
            @Param("deviceType") String deviceType,
            @Param("fcmToken") String fcmToken,
            @Param("userId") String userId
    );

}