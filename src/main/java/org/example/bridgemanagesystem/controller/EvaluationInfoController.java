package org.example.bridgemanagesystem.controller;

import org.springframework.web.bind.annotation.RestController;

import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.*;


@RestController
public class EvaluationInfoController {
    public Double count_bridge_BCI(){
        double BCI;
        double BCIm = 0; //桥面系BCI
        double BCIs = 0; //上部结构BCI
        double BCIx = 0; //下部结构BCI

        /*
        TODO:之后这里要判断桥的类型,选择不同的权重值计算
        以情况而定是否需要计算BCImsx的值
         */
        BCI=BRIDGE_DECK_SYSTEM_WEIGHT_1*BCIm+
                SUBSTRUCTURE_WEIGHT_1*BCIs+
                SUPERSTRUCTURE_WEIGHT_1*BCIx;

        return BCI;
    }
}
