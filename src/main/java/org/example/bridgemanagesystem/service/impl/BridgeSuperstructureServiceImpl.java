package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.BridgeSuperstructure;
import org.example.bridgemanagesystem.mapper.BridgeSuperstructureMapper;
import org.example.bridgemanagesystem.service.BridgeSuperstructureService;
import org.springframework.stereotype.Service;

@Service
public class BridgeSuperstructureServiceImpl extends ServiceImpl<BridgeSuperstructureMapper, BridgeSuperstructure> implements BridgeSuperstructureService {

    @Override
    public BridgeSuperstructure searchBridgeSuperstructureByName(String bridgeName){

        return null;
    }

}
