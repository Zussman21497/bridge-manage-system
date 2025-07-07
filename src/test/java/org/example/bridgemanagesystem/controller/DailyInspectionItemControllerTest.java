package org.example.bridgemanagesystem.controller;

import org.example.bridgemanagesystem.entity.DailyInspectionItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DailyInspectionItemControllerTest {

    @Autowired
    private DailyInspectionItemController d0;
    @Test
    void searchDailyInspectionItem() {
        d0.searchDailyInspectionItem("1");
    }

    @Test
    void addDailyInspectionItem() {
        List<DailyInspectionItem> dList=new ArrayList<>();
        DailyInspectionItem d=new DailyInspectionItem();
        d.setId("");
        d.setRecordId("2");
        d.setItemName("人行道");
        d.setItemCategory("a");
        d.setIsGood(true);
        d.setDamageType("");
        d.setDamageDegree("");
        d.setDamageQuantity(0);
        d.setDamagePosition("");
        d.setDamageDescription("");
        d.setRepairSuggestion("");
        dList.add(d);

        d0.addDailyInspectionItem(dList);
    }
}