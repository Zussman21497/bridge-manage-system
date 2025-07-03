package org.example.bridgemanagesystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.bridgemanagesystem.test.Test_bridge;
import org.springframework.web.bind.annotation.*;

import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.*;


@RestController
@Slf4j
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

    /**
     * 根据桥梁 ID 查询技术状况表
     * @param id
     */
    @GetMapping("/technology/info/search/{id}")
    public void searchEvaluationInfo(@PathVariable String id){
        log.info("查询的桥梁的ID为:{}",id);
    }




    /**
     * 新添桥梁技术状况表
     * @param testBridge
     */
    @PostMapping("/technology/info/add")
    public void addEvaluationInfo(@RequestBody Test_bridge testBridge){
        log.info("添加桥梁技术状况评估表:{}",testBridge);
    }

    /**
     * 更新桥梁技术状况表信息
     * @param testBridge
     */
    @PutMapping("/technology/info/update")
    public void updateEvaluationInfo(@RequestBody Test_bridge testBridge){
        log.info("原桥梁技术状况信息:{}",testBridge);
    }
}
