package org.example.bridgemanagesystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

//桥梁一般资料表
public class BridgeNormalInfo {
    @TableId
    private String bridgeId;                       // 桥梁ID
    private String bridgeName;                     // 桥梁名称
    private String managementUnit;                 // 管理单位
    private String maintenanceUnit;                // 养护单位
    private String constructionUnit;               // 建设单位
    private String designUnit;                     // 设计单位
    private String supervisionUnit;                // 监理单位
    private String constructionUnitUpperPart;      // 施工单位
    private String completionDate;                 // 建成年月
    private Integer totalCost;                     // 总造价
    private String maintenanceCategory;            // 养护类别
    private String maintenanceGrade;               // 养护等级
    private String roadGrade;                      // 道路等级
    private String structureType;                  // 结构类型
    private String designLoad;                     // 设计荷载
    private String loadLimitStandard;              // 限载标准
    private String seismicIntensity;               // 抗震烈度
    private String skewAngle;                      // 正斜交角
    private Double numberOfBridgeSpans;            // 桥梁跨数
    private Double spanCombination;                // 跨径组合
    private Integer deckArea;                      // 桥面面积
    private Integer totalBridgeLength;             // 桥梁总长
    private Integer totalBridgeWidth;              // 桥梁总宽
    private Integer clearWidthOfCarriageway;       // 车行道净宽
    private Integer clearWidthOfSidewalk;          // 人行道净宽
    private String riverGrade;                     // 河道等级
    private Integer highestWaterLevel;             // 最高水位
    private Integer normalWaterLevel;              // 常水位

}

