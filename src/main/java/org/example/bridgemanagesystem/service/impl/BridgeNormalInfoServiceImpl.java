package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.mapper.BridgeNormalInfoMapper;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BridgeNormalInfoServiceImpl extends ServiceImpl<BridgeNormalInfoMapper, BridgeNormalInfo> implements BridgeNormalInfoService {

    @Override
    public BridgeNormalInfo getInfoByName(String bridgeName){
        BridgeNormalInfo info = baseMapper.selectOne(
                new LambdaQueryWrapper<BridgeNormalInfo>().eq(BridgeNormalInfo::getBridgeName, bridgeName)
        );
        return info;
    }

    @Override
    public List<String> getAllBridgeNames(){
        List<String> list = baseMapper.getAllBridgeNames();
        return list;
    }

    @Override
    public List<String> getAllBridgeTypes(){
        List<String> list = baseMapper.getAllBridgeTypes();
        return list;
    }


}
