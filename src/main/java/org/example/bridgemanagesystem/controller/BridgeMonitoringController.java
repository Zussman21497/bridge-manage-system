package org.example.bridgemanagesystem.controller;

import org.example.bridgemanagesystem.common.R;
import org.example.bridgemanagesystem.dto.BridgeMonitoringDto;
import org.example.bridgemanagesystem.entity.BridgeMonitoring;
import org.example.bridgemanagesystem.service.BridgeMonitoringService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bridge/inspect/info")
public class BridgeMonitoringController {

    @Autowired
    private BridgeMonitoringService bridgeMonitoringService;

    /**
     * 桥型检测表查询
     *
     * @param bridgeName
     * @return
     */
    @GetMapping("/search")
    public R<BridgeMonitoringDto> searchBridgeMonitoring(@RequestParam String bridgeName) {

        if (bridgeName == null || bridgeName.trim().isEmpty()) {
            return R.error("桥梁名称不能为空！");
        }

        BridgeMonitoring bridgeMonitoring = bridgeMonitoringService.searchBridgeMonitoringByName(bridgeName);

        if (bridgeMonitoring == null) {
            return R.error("未获取到桥型检测表");
        }

        BridgeMonitoringDto dto = new BridgeMonitoringDto();
        BeanUtils.copyProperties(bridgeMonitoring, dto);

        return R.success(dto);
    }

    /**
     * 桥型检测表新添
     *
     * @param dto
     * @return
     */
    @PostMapping("/add")
    public R<String> addBridgeMonitoring(@RequestBody BridgeMonitoringDto dto) {

        if (dto == null) {
            return R.error("表单数据为空！");
        }

        BridgeMonitoring data = new BridgeMonitoring();
        BeanUtils.copyProperties(dto, data);

        boolean isAdded = bridgeMonitoringService.save(data);

        return isAdded
                ? R.success("添加桥型检测表成功!")
                : R.error("添加桥型检测表失败！");

    }

    /**
     * 桥型检测表更新
     * @param dto
     * @return
     */
    @PutMapping("/update")
    public R<String> updateBridgeMonitoring(@RequestBody BridgeMonitoringDto dto){

        if (dto == null) {
            return R.error("表单数据为空！");
        }

        BridgeMonitoring bridgeMonitoring = new BridgeMonitoring();
        BeanUtils.copyProperties(dto, bridgeMonitoring);

        boolean isUpdated = bridgeMonitoringService.updateById(bridgeMonitoring);

        return isUpdated
                ? R.success("更新桥型检测表成功!")
                : R.error("更新桥型检测表失败！");

    }
}
