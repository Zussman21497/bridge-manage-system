package org.example.bridgemanagesystem.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BridgeRegularInspectionControllerTest {

    @Autowired
    private BridgeRegularInspectionController b;

    @Test
    void searchRegularInspection() {
        b.searchRegularInspection();
    }

    @Test
    void searchAllRegular() {
        b.searchAllRegular("黄河大桥");
    }
}