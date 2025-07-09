package org.example.bridgemanagesystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.example.bridgemanagesystem.common.R;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.dto.EvaluationInfoDTO;
import org.example.bridgemanagesystem.entity.EvaluationInfo;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.example.bridgemanagesystem.service.EvaluationInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.*;


@RestController
@RequestMapping("/technology/info")
@Slf4j

public class EvaluationInfoController {

    @Autowired
    private EvaluationInfoService evaluationInfoService;
    @Autowired
    BridgeNormalInfoService b;

    /**
     * 根据桥梁名称查询技术状况表
     * @param bridgeName
     */
    @GetMapping("/search/{bridgeName}")
    public R<EvaluationInfo> searchEvaluationInfo(@PathVariable String bridgeName){
        log.info("查询的桥梁的名称为:{}",bridgeName);
        EvaluationInfo evaluationInfo=evaluationInfoService.getByName(bridgeName);
        if(evaluationInfo!=null){
            return R.success(evaluationInfo);
        }
        return R.error("查询桥梁技术评估失败!!");
    }

    /**
     * 新添桥梁技术状况表
     * @param
     */
    @PostMapping("/add")
    public R<String> addEvaluationInfo(@RequestBody EvaluationInfoDTO evaluationInfoDTO){
        log.info("添加桥梁技术状况评估表:{}",evaluationInfoDTO);
        System.out.println();
        System.out.println();
        System.out.println();
        //创建Info类,将DTO拷贝到Info里面
        EvaluationInfo evaluationInfo=new EvaluationInfo();
        BeanUtils.copyProperties(evaluationInfoDTO,evaluationInfo);
        log.info("拷贝后的数据:{}",evaluationInfo);
        System.out.println();
        System.out.println(evaluationInfo.getBridgeId());
        System.out.println();
        //查询桥梁的类型
        BridgeNormalInfo info = b.getById(evaluationInfo.getBridgeId());
        if(info==null){
            return R.error("找不到此桥梁数据");
        }
        String id=info.getBridgeId();
        String bridgeType=info.getStructureType();

        //根据桥梁类型设置权重
        if(bridgeType.equals("人行天桥")){
            evaluationInfo.setBridgeDeckSystemWeight(BRIDGE_DECK_SYSTEM_WEIGHT_R);
            evaluationInfo.setSuperstructureWeight(SUPERSTRUCTURE_WEIGHT_R);
            evaluationInfo.setSubstructureWeight(SUBSTRUCTURE_WEIGHT_R);
        }
        else if (bridgeType.equals("拱桥")) {
            evaluationInfo.setBridgeDeckSystemWeight(BRIDGE_DECK_SYSTEM_WEIGHT_G);
            evaluationInfo.setSuperstructureWeight(SUPERSTRUCTURE_WEIGHT_G);
            evaluationInfo.setSubstructureWeight(SUBSTRUCTURE_WEIGHT_G);
        }
        else {
            evaluationInfo.setBridgeDeckSystemWeight(BRIDGE_DECK_SYSTEM_WEIGHT_E);
            evaluationInfo.setSuperstructureWeight(SUPERSTRUCTURE_WEIGHT_E);
            evaluationInfo.setSubstructureWeight(SUBSTRUCTURE_WEIGHT_E);
        }

        //计算BCI,BSI等相关数据
        double bcim,bcis,bcix,bsis,bsix,bci;
        bcim=evaluationInfoService.count_bridge_deck_bci(id);
        bcis=evaluationInfoService.count_superstructure_bci(id);
        bsis=evaluationInfoService.count_superstructure_bsi(id);
        bcix=evaluationInfoService.count_substructure_bci(id);
        bsix=evaluationInfoService.count_substructure_bsi(id);
        bci=evaluationInfoService.count_bridge_BCI(id);

        evaluationInfo.setDeckBci(bcim);
        evaluationInfo.setSuperstructureBci(bcis);
        evaluationInfo.setSuperstructureBsi(bsis);
        evaluationInfo.setSubstructureBci(bcix);
        evaluationInfo.setSubstructureBsi(bsix);
        evaluationInfo.setWholeBridgeBci(bci);

        evaluationInfo.setIntegrityStatusLevel(evaluationInfoService.judge_bci(bci));
        evaluationInfo.setStructuralConditionLevel(evaluationInfoService.judge_bsi((bsis+bsix)/2));

        boolean save = evaluationInfoService.save(evaluationInfo);
        if(!save){
            R.error("添加失败");
        }
        return R.success("添加成功!");
    }

    /**
     * 更新桥梁技术状况表信息
     * @param
     */
    @PutMapping("/update")
    public R<String> updateEvaluationInfo(@RequestBody EvaluationInfoDTO evaluationInfoDTO){
        log.info("新桥梁技术状况信息:{}",evaluationInfoDTO);
        String id = evaluationInfoDTO.getBridgeId();
        QueryWrapper<EvaluationInfo> wrapper=new QueryWrapper<EvaluationInfo>()
                .eq("bridge_id",id);

        EvaluationInfo evaluationInfo=new EvaluationInfo();
        BeanUtils.copyProperties(evaluationInfoDTO,evaluationInfo);
        //查询桥梁的类型
        BridgeNormalInfo info = b.getById(evaluationInfo.getBridgeId());
        if(info==null){
            return R.error("找不到对应的桥梁数据!");
        }
        String bridgeType=info.getStructureType();

        //根据桥梁类型设置权重
        if(bridgeType.equals("人行天桥")){
            evaluationInfo.setBridgeDeckSystemWeight(BRIDGE_DECK_SYSTEM_WEIGHT_R);
            evaluationInfo.setSuperstructureWeight(SUPERSTRUCTURE_WEIGHT_R);
            evaluationInfo.setSubstructureWeight(SUBSTRUCTURE_WEIGHT_R);
        }
        else if (bridgeType.equals("拱桥")) {
            evaluationInfo.setBridgeDeckSystemWeight(BRIDGE_DECK_SYSTEM_WEIGHT_G);
            evaluationInfo.setSuperstructureWeight(SUPERSTRUCTURE_WEIGHT_G);
            evaluationInfo.setSubstructureWeight(SUBSTRUCTURE_WEIGHT_G);
        }
        else {
            evaluationInfo.setBridgeDeckSystemWeight(BRIDGE_DECK_SYSTEM_WEIGHT_E);
            evaluationInfo.setSuperstructureWeight(SUPERSTRUCTURE_WEIGHT_E);
            evaluationInfo.setSubstructureWeight(SUBSTRUCTURE_WEIGHT_E);
        }
        //计算BCI,BSI等相关数据
        double bcim,bcis,bcix,bsis,bsix,bci;
        bcim=evaluationInfoService.count_bridge_deck_bci(id);
        bcis=evaluationInfoService.count_superstructure_bci(id);
        bsis=evaluationInfoService.count_superstructure_bsi(id);
        bcix=evaluationInfoService.count_substructure_bci(id);
        bsix=evaluationInfoService.count_substructure_bsi(id);
        bci=evaluationInfoService.count_bridge_BCI(id);

        evaluationInfo.setDeckBci(bcim);
        evaluationInfo.setSuperstructureBci(bcis);
        evaluationInfo.setSuperstructureBsi(bsis);
        evaluationInfo.setSubstructureBci(bcix);
        evaluationInfo.setSubstructureBsi(bsix);
        evaluationInfo.setWholeBridgeBci(bci);

        evaluationInfo.setIntegrityStatusLevel(evaluationInfoService.judge_bci(bci));
        evaluationInfo.setStructuralConditionLevel(evaluationInfoService.judge_bsi((bsis+bsix)/2));

        boolean update = evaluationInfoService.update(evaluationInfo, wrapper);
        if (!update){
            return R.error("更新失败!");
        }
        return R.success("更新数据成功!");
    }

    /**
     * 查询所有桥梁的BCI值
     */
    @GetMapping("/bci")
    public R<List<Integer>> searchBridgeBCI(){

        List<Integer> list=evaluationInfoService.getBridgeBCI();
        if (list!=null){
            return R.success(list);
        }
        return R.error("查询失败!");
    }
}
