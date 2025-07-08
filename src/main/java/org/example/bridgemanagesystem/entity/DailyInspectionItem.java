package org.example.bridgemanagesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName("inspection_item")
public class DailyInspectionItem {
    private String id;                      // 检查项ID
    private String recordId;                // 关联巡检记录ID
    private String itemName;                    // 检查项名称
    private String itemCategory;                // 检查项分类（如上部结构、附属设施等）
    private Boolean isGood;                     // 是否完好（true:完好，false:损坏）
    private String damageType;                  // 损坏类型（如裂缝、锈蚀等）
    private String damageDegree;                // 损坏程度（轻微、中等、严重）
    private Integer damageQuantity;             // 损坏数量
    private String damagePosition;              // 损坏位置
    private String remark;                      // 备注
//    private String createTime;                  // 创建时间
//    private String updateTime;                  // 更新时间
}
