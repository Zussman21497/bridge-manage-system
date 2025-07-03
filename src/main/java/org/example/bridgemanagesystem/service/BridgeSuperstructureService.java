package org.example.bridgemanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.entity.BridgeSuperstructure;

public interface BridgeSuperstructureService extends IService<BridgeSuperstructure> {

    /**
     * 根据名字查询上部结构
     * @param bridgeName
     * @return
     */
    BridgeSuperstructure searchBridgeSuperstructureByName(String bridgeName);
}
