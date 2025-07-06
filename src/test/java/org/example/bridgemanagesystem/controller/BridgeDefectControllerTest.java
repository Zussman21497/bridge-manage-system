package org.example.bridgemanagesystem.controller;

import org.example.bridgemanagesystem.entity.BridgeDefect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BridgeDefectControllerTest {

    @Autowired
    private BridgeDefectController bridgeDefectController;

    @Test
    void searchDefect() {
        bridgeDefectController.searchDefect("黄河大桥");
    }

    @Test
    void updateDefect() {
        BridgeDefect b=new BridgeDefect();
        b.setBridgeId("BR001");
        b.setRailing(100);
        bridgeDefectController.updateDefect(b);
    }

    @Test
    void addDefect() {
        BridgeDefect b=new BridgeDefect();
        b.setId(1);
        b.setBridgeId("BR003");
        b.setThicknessOfDeckPavement(5);
        b.setBridgeHead(5);
        b.setExpansionJoint(5);
        b.setDrainageSystem(5);
        b.setCarriageway(5);
        b.setRailing(15);
        b.setPierDimensions(15);
        b.setPierBody(15);
        b.setPierBaseElevation(15);
        b.setPierSupport(15);
        b.setAbutmentDimensions(25);
        b.setAbutmentBody(40);
        b.setAbutmentBaseElevation(15);
        b.setAbutmentSupport(25);
        b.setGirder(10);
        b.setHorizontalLinkage(5);

        bridgeDefectController.addDefect(b);
    }
}