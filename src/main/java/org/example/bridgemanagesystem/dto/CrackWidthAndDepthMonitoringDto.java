package org.example.bridgemanagesystem.dto;

import jdk.jfr.Frequency;
import jdk.jfr.Threshold;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
//裂缝宽度及深度监测
public class CrackWidthAndDepthMonitoringDto {

    private String monitoringFrequency;     //监测频率
    private Double widthThreshold;          //宽度阈值
    private Double depthThreshold;          //深度阈值

}
