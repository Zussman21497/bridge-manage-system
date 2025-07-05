package org.example.bridgemanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.entity.BridgePipeline;

public interface BridgePipelineService extends IService<BridgePipeline> {

    /**
     * 根据桥梁名称进行附挂管线查询
     * @param bridgeName
     * @return
     */
    BridgePipeline searchBridgePipelineByName(String bridgeName);

}
