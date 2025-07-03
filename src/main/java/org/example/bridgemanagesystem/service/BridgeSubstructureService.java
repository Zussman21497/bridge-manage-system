package org.example.bridgemanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.entity.BridgeSubstructure;

public interface BridgeSubstructureService extends IService<BridgeSubstructure> {

    //根据桥梁名称进行下部结构查询
    BridgeSubstructure searchBridgeSubstructureByName(String bridgeName);

}
