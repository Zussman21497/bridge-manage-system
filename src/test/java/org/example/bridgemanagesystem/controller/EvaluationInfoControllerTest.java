package org.example.bridgemanagesystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.bridgemanagesystem.entity.EvaluationInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EvaluationInfoControllerTest {

    @Autowired
    private EvaluationInfoController e=new EvaluationInfoController();

    @Test
    void testAddEvaluationInfo() {
        EvaluationInfo evaluationInfo=new EvaluationInfo();
        evaluationInfo.setEvaluationRecordId("003");
        evaluationInfo.setBridgeId("BR003");
        evaluationInfo.setEvaluationTime("20250705");
        evaluationInfo.setEvaluator("龙科均_大孩版");
        evaluationInfo.setBridgeDeckSystemWeight(BRIDGE_DECK_SYSTEM_WEIGHT_E);
        evaluationInfo.setSuperstructureWeight(SUPERSTRUCTURE_WEIGHT_E);
        evaluationInfo.setSubstructureWeight(SUBSTRUCTURE_WEIGHT_E);
        evaluationInfo.setDeckBci(94);
        evaluationInfo.setSuperstructureBci(94);
        evaluationInfo.setSuperstructureBsi(92);
        evaluationInfo.setSubstructureBci(96);
        evaluationInfo.setSubstructureBsi(95);
        evaluationInfo.setWholeBridgeBci(96);
        evaluationInfo.setIntegrityStatusLevel("A");
        evaluationInfo.setStructuralConditionLevel("A-");
        evaluationInfo.setTriggerDirectJudgment(true);
        evaluationInfo.setDamageItems("无");
        evaluationInfo.setDeductionPoints("0");
        evaluationInfo.setWeightDistribution("0.0");
        evaluationInfo.setDamageCauseAnalysis("风吹日晒,龙科均_大孩版整的");
        evaluationInfo.setMaintenanceCountermeasures("龙科均_大孩版去修理");
        evaluationInfo.setReinforcementScheme("好好弄");
        evaluationInfo.setTrafficRestrictionMeasures("无");

        e.addEvaluationInfo(evaluationInfo);
    }

    @Test
    void testSearchEvaluationInfo() {
        e.searchEvaluationInfo("长江大桥");
    }

    @Test
    void testUpdateEvaluationInfo() {
        EvaluationInfo evaluationInfo=new EvaluationInfo();
        evaluationInfo.setBridgeId("BR002");
        evaluationInfo.setEvaluator("大大龙");
        e.updateEvaluationInfo(evaluationInfo);
    }
}