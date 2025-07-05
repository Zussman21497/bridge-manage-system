package org.example.bridgemanagesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
桥梁项目扣分表
 */
@TableName("bridge_defect")
public class BridgeDefect {
    private Integer id; // 主键ID
    private String bridgeId; // 桥梁ID
    private Integer thicknessOfDeckPavement; // 桥面铺装
    private Integer bridgeHead; // 桥头平顺
    private Integer expansionJoint; // 伸缩装置
    private Integer drainageSystem; // 排水系统
    private Integer carriageway; // 人行道
    private Integer railing; // 栏杆
    private Integer pierDimensions; // 盖梁
    private Integer pierBody; // 墩身
    private Integer pierBaseElevation; // 桥墩基础
    private Integer pierSupport; // 桥墩支座
    private Integer abutmentDimensions; // 台帽
    private Integer abutmentBody; // 台身
    private Integer abutmentBaseElevation; // 桥台基础
    private Integer abutmentSupport; // 桥台支座
    private Integer girder; // 主梁
    private Integer horizontalLinkage; // 横向联系
}
