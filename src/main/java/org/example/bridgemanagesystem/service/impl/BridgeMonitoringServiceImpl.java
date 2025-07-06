package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.BridgeMonitoring;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.mapper.BridgeMonitoringMapper;
import org.example.bridgemanagesystem.service.BridgeMonitoringService;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BridgeMonitoringServiceImpl extends ServiceImpl<BridgeMonitoringMapper, BridgeMonitoring> implements BridgeMonitoringService {

    @Autowired
    private BridgeNormalInfoService bridgeNormalInfoService;
    /**
     * 桥型检测表查询
     * @param bridgeName
     * @return
     */
    @Override
    public BridgeMonitoring searchBridgeMonitoringByName(String bridgeName){

        //先根据桥梁名称查桥梁id
        BridgeNormalInfo bridgeNormalInfo = bridgeNormalInfoService.getInfoByName(bridgeName);
        String id = bridgeNormalInfo.getBridgeId();


        //再根据桥梁id查桥型检测表
        BridgeMonitoring bridgeMonitoring = baseMapper.selectById(id);

        return bridgeMonitoring;
    }


}
