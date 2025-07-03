package org.example.bridgemanagesystem.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;

public interface BridgeNormalInfoService extends IService<BridgeNormalInfo> {

    //根据名字查桥梁一般信息
    BridgeNormalInfo getInfoByName(String bridgeName);

}
