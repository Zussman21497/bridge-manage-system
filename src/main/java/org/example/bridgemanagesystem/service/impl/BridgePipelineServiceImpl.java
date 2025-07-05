package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.entity.BridgePipeline;
import org.example.bridgemanagesystem.mapper.BridgePipelineMapper;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.example.bridgemanagesystem.service.BridgePipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BridgePipelineServiceImpl extends ServiceImpl<BridgePipelineMapper, BridgePipeline> implements BridgePipelineService {

    @Autowired
    private BridgeNormalInfoService bridgeNormalInfoService;

    /**
     * 根据桥梁名称进行附挂管线查询
     * @param bridgeName
     * @return
     */
    @Override
    public BridgePipeline searchBridgePipelineByName(String bridgeName){
        //根据桥梁名称查桥梁id
        BridgeNormalInfo bridgeNormalInfo = bridgeNormalInfoService.getInfoByName(bridgeName);
        String bridgeId = bridgeNormalInfo.getBridgeId();

        //根据桥梁id查桥梁附挂管线信息
        BridgePipeline bridgePipeline = baseMapper.selectById(bridgeId);

        return bridgePipeline;
    }


}
