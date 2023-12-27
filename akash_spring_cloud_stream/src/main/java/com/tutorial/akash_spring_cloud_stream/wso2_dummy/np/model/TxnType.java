package com.tutorial.akash_spring_cloud_stream.wso2_dummy.np.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TxnType {
    private String txnType;
}
