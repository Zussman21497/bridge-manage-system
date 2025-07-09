package org.example.bridgemanagesystem.controller;

import org.example.bridgemanagesystem.dto.BridgeDailyAllDto;
import org.example.bridgemanagesystem.entity.DailyInspectionData;
import org.example.bridgemanagesystem.entity.DailyInspectionItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BridgeDailyInspectionControllerTest {

    @Autowired
    private BridgeDailyInspectionController b;
    @Test
    void searchDailyInspection() {
        b.searchDailyInspection("珠江大桥");
    }

    @Test
    void addDailyInspection() {
        BridgeDailyAllDto allDto=new BridgeDailyAllDto();
        DailyInspectionData data=new DailyInspectionData();
        data.setInspectionId("4");
        data.setBridgeName("重庆大桥");
//        data.setBridgeCode("2");
//        data.setRoadName("黄明路");
        data.setInspectionDate("2025-07-07");
        data.setInspector("龙科均");
        data.setInspectionUnit("长生桥桥梁检测站");
        data.setWeather("雷阵雨");
        data.setOverallStatus(1);
        allDto.setDailyInspectionData(data);

        List<DailyInspectionItem> dList=new ArrayList<>();
        DailyInspectionItem d=new DailyInspectionItem();
        d.setId("");
        d.setRecordId(data.getBridgeId());
        d.setItemName("人行道");
        d.setItemCategory("a");
        d.setIsGood(true);
        d.setDamageType("");
        d.setDamageDegree("");
        d.setDamageQuantity(0);
        d.setDamagePosition("");
        d.setRemark("");
        dList.add(d);

        allDto.setDailyInspectionItems(dList);

        b.addDailyInspection(allDto);
    }

    @Test
    void searchSomeDailyInspection() {
        b.searchSomeDailyInspection();
    }
}