package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.entity.BridgeSuperstructure;
import org.example.bridgemanagesystem.mapper.BridgeNormalInfoMapper;
import org.example.bridgemanagesystem.mapper.BridgeSuperstructureMapper;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.example.bridgemanagesystem.service.BridgeSuperstructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BridgeSuperstructureServiceImpl extends ServiceImpl<BridgeSuperstructureMapper, BridgeSuperstructure> implements BridgeSuperstructureService {

    @Autowired
    private BridgeNormalInfoService bridgeNormalInfoService;

    /**
     * 根据桥梁名称查询上部结构
     * @param bridgeName
     * @return
     */
    @Override
    public BridgeSuperstructure searchBridgeSuperstructureByName(String bridgeName){

        //根据桥梁名称去查桥梁id
        BridgeNormalInfo info = bridgeNormalInfoService.getInfoByName(bridgeName);

        String bridgeId = info.getBridgeId();

        //根据桥梁id查询上部结构
        BridgeSuperstructure bridgeInfo = baseMapper.selectById(bridgeId);

        return bridgeInfo;


    }

}
