package org.example.bridgemanagesystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.bridgemanagesystem.common.R;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.entity.BridgeSuperstructure;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/bridge")
public class BridgeController {

    @Autowired
    private BridgeNormalInfoService bridgeNormalInfoService;


    /**
     * 桥梁一般资料查询
     * @param bridgeName
     * @return
     */
    @GetMapping("/normal/search")
    public R<BridgeNormalInfo> searchGeneralBridgeInfo(@RequestParam String bridgeName){

        if(bridgeName == null || bridgeName.trim().isEmpty()){
            return R.error("桥梁名称不能为空！");
        }

        BridgeNormalInfo info = bridgeNormalInfoService.getInfoByName(bridgeName);

        if(info != null){
            return R.success(info);
        }

        return R.error("获取失败！");
    }


    public R<BridgeSuperstructure> searchBridgeSuperstructure(@RequestParam String bridgeName){

        if(bridgeName != null || bridgeName.trim().isEmpty()){
            return R.error("桥梁名称不能为空！");
        }

        return null;


    }





}
