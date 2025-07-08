package org.example.bridgemanagesystem.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;

import java.util.List;

public interface BridgeNormalInfoService extends IService<BridgeNormalInfo> {

    //根据名字查桥梁一般信息
    BridgeNormalInfo getInfoByName(String bridgeName);

    //获取所有桥梁名称
    List<String> getAllBridgeNames();

    //获取所有桥梁类型
    List<String> getAllBridgeTypes();

}
