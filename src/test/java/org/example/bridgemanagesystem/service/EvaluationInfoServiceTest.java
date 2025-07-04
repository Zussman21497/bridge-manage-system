package org.example.bridgemanagesystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.bridgemanagesystem.entity.EvaluationInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EvaluationInfoServiceTest {
    @Autowired
    private EvaluationInfoService evaluationInfoService;

    //增
    @Test
    void testSave(){
        EvaluationInfo evaluationInfo=new EvaluationInfo();
        evaluationInfo.setEvaluationRecordId("001");
        evaluationInfo.setBridgeId("BR001");
        evaluationInfo.setEvaluationTime("20250704");
        evaluationInfo.setEvaluator("龙大");
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
        evaluationInfo.setDamageCauseAnalysis("风吹日晒,龙科均整的");
        evaluationInfo.setMaintenanceCountermeasures("龙科均去修理");
        evaluationInfo.setReinforcementScheme("好好弄");
        evaluationInfo.setTrafficRestrictionMeasures("无");

        evaluationInfoService.save(evaluationInfo);
    }

    //查
    @Test
    void testSearch(){
        List<EvaluationInfo> evaluationInfos = evaluationInfoService.listByIds(List.of("013"));
        evaluationInfos.forEach(System.out::println);
    }

    //改
    @Test
    void testUpdate(){
        EvaluationInfo e=new EvaluationInfo();
        e.setEvaluator("龙小");
        QueryWrapper<EvaluationInfo> wrapper=new QueryWrapper<EvaluationInfo>()
                .eq("evaluator","龙大");
        evaluationInfoService.update(e,wrapper);
    }

    //删
    @Test
    void testDelete(){
        QueryWrapper<EvaluationInfo> wrapper=new QueryWrapper<EvaluationInfo>()
                .eq("evaluator","龙小");
        evaluationInfoService.remove(wrapper);
    }
}