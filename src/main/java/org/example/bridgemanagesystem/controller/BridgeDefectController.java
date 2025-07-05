package org.example.bridgemanagesystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.example.bridgemanagesystem.entity.BridgeDefect;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.entity.EvaluationInfo;
import org.example.bridgemanagesystem.service.BridgeDefectService;
import org.example.bridgemanagesystem.service.EvaluationInfoService;
import org.example.bridgemanagesystem.service.impl.BridgeNormalInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bridge/defect")
@Slf4j
public class BridgeDefectController {

    @Autowired
    private BridgeDefectService bridgeDefectService;
    @Autowired
    BridgeNormalInfoServiceImpl b;
    /**
     * 查询桥梁扣分项目表
     * @param bridgeName
     */
    @GetMapping("/search/{bridgeName}")
    public void searchDefect(@PathVariable String bridgeName){
        log.info("查询桥梁的名称:{}",bridgeName);
        BridgeNormalInfo info = b.getInfoByName(bridgeName);
        String id=info.getBridgeId();
        QueryWrapper<BridgeDefect> wrapper=new QueryWrapper<BridgeDefect>()
                .eq("bridge_id",id);
        bridgeDefectService.getBaseMapper().selectOne(wrapper);
    }

    @PutMapping("/update")
    public void updateDefect(@RequestBody BridgeDefect bridgeDefect){
        log.info("更新的桥梁扣分项目:{}",bridgeDefect);
        String id=bridgeDefect.getBridgeId();
        QueryWrapper<BridgeDefect> wrapper=new QueryWrapper<BridgeDefect>()
                .eq("bridge_id",id);
        bridgeDefectService.update(bridgeDefect,wrapper);

    }

    @PostMapping("/add")
    public void addDefect(@RequestBody BridgeDefect bridgeDefect){
        log.info("新添的桥梁扣分项目:{}",bridgeDefect);
        bridgeDefectService.save(bridgeDefect);
    }
}
