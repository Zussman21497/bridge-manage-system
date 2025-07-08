package org.example.bridgemanagesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//应力应变监测
public class StressAndStrainMonitoringDto {

    private String monitoringFrequency;    //监测频率
    private Double thresholdRange;         //阈值范围
}
