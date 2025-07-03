package org.example.bridgemanagesystem.controller;

import lombok.extern.slf4j.Slf4j;
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
     * 计算整个桥的BCI值
     * @param id
     * @return
     */
    public Double count_bridge_BCI(String id){
        double BCI=0;
        double BCIm = 0; //桥面系BCI
        double BCIs = 0; //上部结构BCI
        double BCIx = 0; //下部结构BCI

        /*
        TODO:以情况而定计算BCImsx的值
        TODO:这个ID到时候从数据库里面查对应的桥梁分类
         */
        if (id=="人行天桥"){
            BCI=BCIm*BRIDGE_DECK_SYSTEM_WEIGHT_R+
                    BCIs*SUPERSTRUCTURE_WEIGHT_R+
                    BCIx*SUBSTRUCTURE_WEIGHT_R;
        }else {
            if(id=="拱桥"){
                BCI=BCIm*BRIDGE_DECK_SYSTEM_WEIGHT_G+
                        BCIs*SUPERSTRUCTURE_WEIGHT_G+
                        BCIx*SUBSTRUCTURE_WEIGHT_G;
            }
            else {
                BCI=BCIm*BRIDGE_DECK_SYSTEM_WEIGHT_E+
                        BCIs*SUPERSTRUCTURE_WEIGHT_E+
                        BCIx*SUBSTRUCTURE_WEIGHT_E;
            }
        }

        return BCI;
    }

    /**
     * 根据桥梁 ID 查询技术状况表
     * @param id
     */
    @GetMapping("/search/{id}")
    public void searchEvaluationInfo(@PathVariable String id){
        log.info("查询的桥梁的ID为:{}",id);
        EvaluationInfo evaluationInfo=evaluationInfoService.getById(id);
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
