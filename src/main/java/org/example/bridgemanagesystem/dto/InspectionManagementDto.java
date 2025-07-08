package org.example.bridgemanagesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//监测管理dto
public class InspectionManagementDto {

    private String environment;//所在环境
    private CrackWidthAndDepthMonitoringDto crackWidthAndDepthMonitoringDto;//裂缝宽度及深度监测
    private StressAndStrainMonitoringDto stressAndStrainMonitoringDto;//应力应变监测
    private StructuralDisplacementMonitoringDto structuralDisplacementMonitoringDto;//结构位移监测

}
