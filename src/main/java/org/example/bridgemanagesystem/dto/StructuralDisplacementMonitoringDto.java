package org.example.bridgemanagesystem.dto;

import jdk.jfr.Frequency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

//结构位移监测
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StructuralDisplacementMonitoringDto {

    private String monitoringFrequency;    //监测频率
    private Double thresholdRange;         //阈值范围
}
