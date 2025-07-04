package org.example.bridgemanagesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
  技术状况评估表
 */
@TableName("tech_status_evaluation")
public class EvaluationInfo {
    @TableId(value = "evaluation_record_id", type = IdType.INPUT)
    private String evaluationRecordId;    // 评估记录ID
    private String bridgeId;              // 桥梁ID
    private String evaluationTime;        // 评估时间
    private String evaluator;             // 评估人员
    private double bridgeDeckSystemWeight; // 桥面系权重
    private double superstructureWeight; // 上部结构权重
    private double substructureWeight;  // 下部结构权重
    private double deckBci;              // 桥面系BCI值
    private double superstructureBci;    // 上部结构BCI值
    private double superstructureBsi;    // 上部结构BSI值
    private double substructureBci;      // 下部结构BCI值
    private double substructureBsi;      // 下部结构BSI值
    private double wholeBridgeBci;       // 全桥BCI值
    private String integrityStatusLevel;  // 完好状态等级
    private String structuralConditionLevel; // 结构状况等级
    private Boolean triggerDirectJudgment;   // 是否触发直接判定条件
    private String maintenanceCountermeasures; // 养护对策
    private String reinforcementScheme;  // 加固方案
    private String trafficRestrictionMeasures; // 交通限制措施
}
