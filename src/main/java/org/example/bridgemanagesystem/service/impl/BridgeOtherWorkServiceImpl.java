package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.entity.BridgeOtherWork;
import org.example.bridgemanagesystem.mapper.BridgeOtherWorkMapper;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.example.bridgemanagesystem.service.BridgeOtherWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BridgeOtherWorkServiceImpl extends ServiceImpl<BridgeOtherWorkMapper, BridgeOtherWork> implements BridgeOtherWorkService {

    @Autowired
    private BridgeNormalInfoService bridgeNormalInfoService;

    /**
     * 根据桥梁名称进行附属工程查询
     * @param bridgeName
     * @return
     */
    @Override
    public BridgeOtherWork searchBridgeOtherWorkByName(String bridgeName){

        //根据桥梁名称查桥梁id
        BridgeNormalInfo bridgeInfo = bridgeNormalInfoService.getInfoByName(bridgeName);
        String bridgeId = bridgeInfo.getBridgeId();

        //根据桥梁id查附属工程信息
        BridgeOtherWork bridgeOtherWork = baseMapper.selectById(bridgeId);

        return bridgeOtherWork;
    }

}
