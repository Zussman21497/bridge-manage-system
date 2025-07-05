package org.example.bridgemanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.entity.BridgeOtherWork;

public interface BridgeOtherWorkService extends IService<BridgeOtherWork> {

    /**
     * 根据桥梁名称进行附属工程查询
     * @param bridgeName
     * @return
     */
    BridgeOtherWork searchBridgeOtherWorkByName(String bridgeName);
}
