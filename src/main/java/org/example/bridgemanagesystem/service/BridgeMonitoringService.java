package org.example.bridgemanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.entity.BridgeMonitoring;

public interface BridgeMonitoringService extends IService<BridgeMonitoring> {

    /**
     * 根据桥梁名称查桥梁检测表
     * @param bridgeName
     * @return
     */
    BridgeMonitoring searchBridgeMonitoringByName(String bridgeName);


}
