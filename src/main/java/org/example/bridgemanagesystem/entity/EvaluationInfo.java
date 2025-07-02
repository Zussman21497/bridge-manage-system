package org.example.bridgemanagesystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
  技术状况评估表
 */
public class EvaluationInfo {
    private String evaluationRecordId;    // 评估记录ID
    private String bridgeId;              // 桥梁ID
    private String evaluationTime;        // 评估时间
    private String evaluator;             // 评估人员
    private double bridgeDeckSystemWeight; // 桥面系权重
    private double superstructureWeight; // 上部结构权重
    private double substructureWeight;  // 下部结构权重
    private Integer deckBci;              // 桥面系BCI值
    private Integer superstructureBci;    // 上部结构BCI值
    private Integer superstructureBsi;    // 上部结构BSI值
    private Integer substructureBci;      // 下部结构BCI值
    private Integer substructureBsi;      // 下部结构BSI值
    private Integer wholeBridgeBci;       // 全桥BCI值
    private String integrityStatusLevel;  // 完好状态等级
    private String structuralConditionLevel; // 结构状况等级
    private Boolean triggerDirectJudgment;   // 是否触发直接判定条件
    private String damageItems;          // 损坏项目
    private String deductionPoints;      // 扣分值
    private String weightDistribution;   // 权重分配
    private String damageCauseAnalysis;  // 损坏原因分析
    private String maintenanceCountermeasures; // 养护对策
    private String reinforcementScheme;  // 加固方案
    private String trafficRestrictionMeasures; // 交通限制措施
}
