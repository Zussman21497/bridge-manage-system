package org.example.bridgemanagesystem.controller;

import org.example.bridgemanagesystem.common.R;
import org.example.bridgemanagesystem.dto.InspectionManagementDto;
import org.example.bridgemanagesystem.dto.MonitoringPlanVO;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.example.bridgemanagesystem.service.MonitoringPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bridge/inspection")
public class BridgeInspectionController {

    @Autowired
    private BridgeNormalInfoService bridgeNormalInfoService;

    @Autowired
    private MonitoringPlanService planService;

    /**
     * 查询所有桥梁类型
     * @return
     */
    @GetMapping("/getAllBridges")
    public R<List<String>> searchAllBridgeTypes(){
        List<String> list = bridgeNormalInfoService.getAllBridgeTypes();

        if(list != null){
            return R.success(list);
        }

        return R.error("获取全部桥梁类型失败！");

    }

    /**
     * 生成监测方案
     * @param dto
     * @return
     */
    @PostMapping("/generateMonitoringPlan")
    public R<MonitoringPlanVO> generateMonitoringPlan(@RequestBody InspectionManagementDto dto){
        if(dto == null){
            return R.error("表单数据为空！");
        }

        MonitoringPlanVO plan = planService.generate(dto);
        return R.success(plan);

    }


}
