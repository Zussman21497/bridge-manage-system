package org.example.bridgemanagesystem.service.impl;

import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EvaluationInfoServiceImplTest {

    @Autowired
    private EvaluationInfoServiceImpl evaluationInfoService;
    @Autowired
    private BridgeNormalInfoServiceImpl b;

    @Test
    void getByName() {
        BridgeNormalInfo info = b.getInfoByName("长江大桥");
        System.out.println(info);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        String id=info.getBridgeId();
        System.out.println(evaluationInfoService.getById(id));
    }
}