package org.example.bridgemanagesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//桥型检测表Dto
public class BridgeMonitoringDto {

    private String monitoringID;         // 检测ID
    private String bridgeID;             // 桥梁ID
    private String bridgeType;           // 桥梁类型
    private String monitoringItem;       // 监测项目
    private String monitoringFrequency;  // 监测频率
    private String monitoringMethod;     // 监测方法
    private String limitValue;           // 限值
    private String remark;               // 备注
}
