package org.example.bridgemanagesystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

//桥型检测内容表
public class BridgeTypeInspection {

    private Integer itemId;               // 检测项目ID，自增主键
    private String bridgeId;              // 桥梁ID
    private String inspectionType;        // 检测类型
    private String inspectionItem;        // 检测项目
    private String standardValue;         // 标准值（可空）

}
