package org.example.bridgemanagesystem.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BridgeInfoControllerTest {

    @Autowired
    private BridgeInfoController b;
    @Test
    void searchBridgeNames() {
        b.searchBridgeNames();
    }

    @Test
    void searchBridgeSuperstructure() {
        b.searchBridgeSuperstructure("长江大桥");
    }
}