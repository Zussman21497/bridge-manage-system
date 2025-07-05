package org.example.bridgemanagesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//日常巡检表
public class DailyInspectionDataDto {
    private String bridgeId;                              //桥梁id
    private String bridgeName;                            // 桥梁名称
    private String inspectionUnit;                        // 巡检单位
    private String bridgeNameplate;                       // 桥梁铭牌情况
    private String heightLimitSign;                       // 限高标志情况
    private String weightLimitSign;                       // 限重标志情况
    private String vehicleLane;                           // 车行道情况
    private String sidewalk;                              // 人行道情况
    private String expansionJoint;                        // 伸缩缝情况
    private String railing;                               // 护栏情况
    private String drainageFacilities;                    // 排水设施情况
    private String bridgeRoadConnectionPoint;             // 桥梁与道路连接点情况
    private String superstructure;                        // 上部结构情况
    private String bearing;                               // 支座情况
    private String substructure;                          // 下部结构情况
    private Boolean intact;                               // 桥梁是否完好（true = 完好，false = 有问题）
    private String damageType;                            // 损坏类型（如裂缝、变形等）
    private String damageDegree;                          // 损坏程度（轻微、中等、严重）
    private String damageLocation;                        // 损坏位置描述
    private String remarks;                               // 备注信息
    private String constructionWithinBridgeProtectionArea; // 桥梁保护区内施工情况
    private String otherHazards;                          // 其他安全隐患
    private String inspector;                             // 巡检人
    private String inspectionTime;                        // 巡检时间（建议格式 yyyy-MM-dd）
    private String weather;                               // 当时天气情况
}
