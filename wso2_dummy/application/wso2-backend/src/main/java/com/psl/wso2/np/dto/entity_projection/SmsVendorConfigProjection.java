package com.psl.wso2.np.dto.entity_projection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsVendorConfigProjection {

    private Long id;

    private String baseUrl;

    private String userName;

    private String password;

    private String mask;
}