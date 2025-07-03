package org.example.bridgemanagesystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.bridgemanagesystem.common.R;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.entity.BridgeSubstructure;
import org.example.bridgemanagesystem.entity.BridgeSuperstructure;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.example.bridgemanagesystem.service.BridgeSubstructureService;
import org.example.bridgemanagesystem.service.BridgeSuperstructureService;
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

    @Autowired
    private BridgeSuperstructureService bridgeSuperstructureService;

    @Autowired
    private BridgeSubstructureService bridgeSubstructureService;


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

        BridgeNormalInfo bridgeInfo = bridgeNormalInfoService.getInfoByName(bridgeName);

        if(bridgeInfo != null){
            return R.success(bridgeInfo);
        }

        return R.error("获取桥梁一般资料失败！");
    }


    /**
     * 上部结构查询
     * @param bridgeName
     * @return
     */
    @GetMapping("/superstructure/search")
    public R<BridgeSuperstructure> searchBridgeSuperstructure(@RequestParam String bridgeName){

        if(bridgeName == null || bridgeName.trim().isEmpty()){
            return R.error("桥梁名称不能为空！");
        }

        BridgeSuperstructure bridgeInfo = bridgeSuperstructureService.searchBridgeSuperstructureByName(bridgeName);

        if(bridgeInfo != null){
            return R.success(bridgeInfo);
        }

        return R.error("获取桥梁上部结构失败！");

    }


    /**
     * 下部结构查询
     * @param bridgeName
     * @return
     */
    public R<BridgeSubstructure> searchBridgeSubstructure(@RequestParam String bridgeName){

        if(bridgeName == null || bridgeName.trim().isEmpty()){
            return R.error("桥梁名称不能为空！");
        }

        BridgeSubstructure bridgeInfo = bridgeSubstructureService.searchBridgeSubstructureByName(bridgeName);

        if(bridgeInfo != null){
            return R.success(bridgeInfo);
        }

        return R.error("获取桥梁下部结构失败！");

    }







}
