package org.example.bridgemanagesystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.bridgemanagesystem.dto.EvaluationInfoDTO;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.entity.EvaluationInfo;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.example.bridgemanagesystem.service.EvaluationInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
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
        EvaluationInfoDTO evaluationInfoDTO=new EvaluationInfoDTO();
        evaluationInfoDTO.setEvaluationRecordId("001");
        evaluationInfoDTO.setBridgeId("BR003");
        evaluationInfoDTO.setEvaluationTime("20250705");
        evaluationInfoDTO.setEvaluator("龙科均_小孩版");
        evaluationInfoDTO.setTriggerDirectJudgment(true);
        evaluationInfoDTO.setMaintenanceCountermeasures("龙科均_小孩版去修理");
        evaluationInfoDTO.setReinforcementScheme("再多浇点混泥土");
        evaluationInfoDTO.setTrafficRestrictionMeasures("江津区车辆不许走");

       e.addEvaluationInfo(evaluationInfoDTO);
    }

    @Test
    void testSearchEvaluationInfo() {
        e.searchEvaluationInfo("长江大桥");
    }

    @Test
    void testUpdateEvaluationInfo() {
        EvaluationInfoDTO evaluationInfoDTO=new EvaluationInfoDTO();
        evaluationInfoDTO.setBridgeId("BR003");
        evaluationInfoDTO.setEvaluator("大大龙");
        e.updateEvaluationInfo(evaluationInfoDTO);
    }
}