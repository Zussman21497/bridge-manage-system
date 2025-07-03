package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.entity.BridgeSubstructure;
import org.example.bridgemanagesystem.mapper.BridgeSubstructureMapper;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.example.bridgemanagesystem.service.BridgeSubstructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BridgeSubstructureServiceImpl extends ServiceImpl<BridgeSubstructureMapper, BridgeSubstructure> implements BridgeSubstructureService {

    @Autowired
    private BridgeNormalInfoService bridgeNormalInfoService;

    /**
     * 根据桥梁名称进行下部结构查询
     * @param bridgeName
     * @return
     */
    @Override
    public BridgeSubstructure searchBridgeSubstructureByName(String bridgeName){

        //根据桥梁名称查桥梁id
        BridgeNormalInfo info = bridgeNormalInfoService.getInfoByName(bridgeName);

        String bridgeId = info.getBridgeId();

        //根据桥梁id查桥梁下部结构
        BridgeSubstructure bridgeInfo = baseMapper.selectById(bridgeId);

        return bridgeInfo;

    }


}
