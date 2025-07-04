package org.example.bridgemanagesystem.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.bridgemanagesystem.entity.EvaluationInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;

import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.*;

@SpringBootTest
class EvaluationInfoMapperTest {

    @Autowired
    private EvaluationInfoMapper evaluationInfoMapper;

    /**
     * 测试插入
     */
    @Test
    void testInsert() {
        EvaluationInfo evaluationInfo=new EvaluationInfo();
        evaluationInfo.setEvaluationRecordId("012");
        evaluationInfo.setBridgeId("BR001");
        evaluationInfo.setEvaluationTime("20250704");
        evaluationInfo.setEvaluator("龙科均");
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
        evaluationInfoMapper.insert(evaluationInfo);
    }

    /**
     * 测试查询
     */
    @Test
    void testSearch(){
        // 构建查询条件
        QueryWrapper<EvaluationInfo> wrapper=new QueryWrapper<EvaluationInfo>()
                .select("bridge_id","evaluator");
        // 查询
        List<EvaluationInfo> evaluationInfos = evaluationInfoMapper.selectList(wrapper);
        evaluationInfos.forEach(System.out::println);

    }

    /**
     * 测试更新
     */
    @Test
    void testUpdate(){
        //要更新的数据
        EvaluationInfo e=new EvaluationInfo();
        e.setEvaluator("小龙小龙");
        //更新的条件
        QueryWrapper<EvaluationInfo> wrapper=new QueryWrapper<EvaluationInfo>()
                .eq("evaluator","龙科均");
        //执行
        evaluationInfoMapper.update(e,wrapper);
    }

    /**
     * 测试删除
     */
    @Test
    void testDelete(){
        QueryWrapper<EvaluationInfo> wrapper=new QueryWrapper<EvaluationInfo>()
                .eq("evaluator","龙科均");
        evaluationInfoMapper.delete(wrapper);
    }
}