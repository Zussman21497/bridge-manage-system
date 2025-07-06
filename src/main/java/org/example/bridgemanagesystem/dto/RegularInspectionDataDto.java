package org.example.bridgemanagesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//定期检查表Dto
public class RegularInspectionDataDto {

    private String recordID;               // 记录ID
    private String bridgeName;             // 桥梁名称
    private String testingUnit;            // 检测单位
    private String date;                   // 检测日期
    private String component;              // 构件编号或标识
    private String componentName;          // 构件名称
    private String componentNumber;        // 构件数量
    private String status;                 // 状态
    private String damageType;             // 损伤类型
    private String damageDegree;           // 损伤程度
    private String damageLocation;         // 损伤位置
    private String corrosionClassification;// 腐蚀等级
    private String photoNumber;            // 照片编号
    private String remarks;                // 备注
    private String inspectionPersonnel;    // 检查人员

}
