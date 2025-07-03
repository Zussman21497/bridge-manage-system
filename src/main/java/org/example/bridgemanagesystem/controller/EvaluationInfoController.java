package org.example.bridgemanagesystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.bridgemanagesystem.common.R;
import org.example.bridgemanagesystem.entity.EvaluationInfo;
import org.example.bridgemanagesystem.service.EvaluationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.*;


@RestController
@RequestMapping("/technology/info")
@Slf4j
public class EvaluationInfoController {

    @Autowired
    private EvaluationInfoService evaluationInfoService;

    /**
     * 根据桥梁 ID 查询技术状况表
     * @param bridgeName
     */
    @GetMapping("/search")
    public R<EvaluationInfo> searchEvaluationInfo(@PathVariable String bridgeName){
        log.info("查询的桥梁的名称为:{}",bridgeName);
        EvaluationInfo evaluationInfo=evaluationInfoService.getByName(bridgeName);
        return null;
    }




    /**
     * 新添桥梁技术状况表
     * @param
     */
    @PostMapping("/add")
    public void addEvaluationInfo(@RequestBody EvaluationInfo evaluationInfo){
        log.info("添加桥梁技术状况评估表:{}",evaluationInfo);
    }

    /**
     * 更新桥梁技术状况表信息
     * @param
     */
    @PutMapping("/update")
    public void updateEvaluationInfo(@RequestBody EvaluationInfo evaluationInfo){
        log.info("原桥梁技术状况信息:{}",evaluationInfo);
    }
}
