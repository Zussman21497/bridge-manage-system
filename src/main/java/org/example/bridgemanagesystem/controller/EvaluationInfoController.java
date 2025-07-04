package org.example.bridgemanagesystem.controller;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
     * 根据桥梁名称查询技术状况表
     * @param bridgeName
     */
    @GetMapping("/search/{bridgeName}")
    public R<EvaluationInfo> searchEvaluationInfo(@PathVariable String bridgeName){
        log.info("查询的桥梁的名称为:{}",bridgeName);
        EvaluationInfo evaluationInfo=evaluationInfoService.getByName(bridgeName);
        return R.success(evaluationInfo);
    }


    /**
     * 新添桥梁技术状况表
     * @param
     */
    @PostMapping("/add")
    public void addEvaluationInfo(@RequestBody EvaluationInfo evaluationInfo){
        log.info("添加桥梁技术状况评估表:{}",evaluationInfo);
        evaluationInfoService.save(evaluationInfo);
    }

    /**
     * 更新桥梁技术状况表信息
     * @param
     */
    @PutMapping("/update")
    public void updateEvaluationInfo(@RequestBody EvaluationInfo evaluationInfo){
        log.info("新桥梁技术状况信息:{}",evaluationInfo);
        String id = evaluationInfo.getBridgeId();
        QueryWrapper<EvaluationInfo> wrapper=new QueryWrapper<EvaluationInfo>()
                .eq("bridge_id",id);
        evaluationInfoService.update(evaluationInfo,wrapper);
    }

}
