package com.psl.wso2_dummy.wso2.np.dto.entity_projection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceDataProjection {
    private String fcmToken;
}