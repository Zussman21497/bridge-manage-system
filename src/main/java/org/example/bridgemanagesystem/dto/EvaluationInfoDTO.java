package org.example.bridgemanagesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationInfoDTO {
    private String evaluationRecordId;          // 评估记录ID
    private String bridgeId;                    // 桥梁ID
    private String evaluationTime;              // 评估时间
    private String evaluator;                   // 评估人员
    private Boolean triggerDirectJudgment;      // 是否触发直接判定条件
    private String maintenanceCountermeasures;  // 养护对策
    private String reinforcementScheme;         // 加固方案
    private String trafficRestrictionMeasures;  // 交通限制措施
}
