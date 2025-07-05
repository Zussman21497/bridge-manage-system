package org.example.bridgemanagesystem.common;

import org.example.bridgemanagesystem.dto.*;
import org.example.bridgemanagesystem.entity.*;
import org.springframework.beans.BeanUtils;

//工具类，用于把dto转换为实体类
public class BridgeConverter {

    //转换桥梁一般资料
    public static BridgeNormalInfo toEntity(BridgeNormalInfoDto bridgeNormalInfoDto) {
        BridgeNormalInfo bridgeNormalInfo = new BridgeNormalInfo();
        BeanUtils.copyProperties(bridgeNormalInfoDto, bridgeNormalInfo);
        return bridgeNormalInfo;
    }

    //转换桥梁附属工程
    public static BridgeOtherWork toEntity(BridgeOtherWorkDto bridgeOtherWorkDto) {
        BridgeOtherWork bridgeOtherWork = new BridgeOtherWork();
        BeanUtils.copyProperties(bridgeOtherWorkDto, bridgeOtherWork);
        return bridgeOtherWork;
    }

    //转换桥梁附挂管线
    public static BridgePipeline toEntity(BridgePipelineDto bridgePipelineDto) {
        BridgePipeline bridgePipeline = new BridgePipeline();
        BeanUtils.copyProperties(bridgePipelineDto, bridgePipeline);
        return bridgePipeline;
    }

    //转换桥梁上部结构
    public static BridgeSuperstructure toEntity(BridgeSuperstructureDto bridgeSuperstructureDto){
        BridgeSuperstructure bridgeSuperstructure = new BridgeSuperstructure();
        BeanUtils.copyProperties(bridgeSuperstructureDto, bridgeSuperstructure);
        return bridgeSuperstructure;
    }

    //转换桥梁下部结构
    public static BridgeSubstructure toEntity(BridgeSubstructureDto bridgeSubstructureDto){
        BridgeSubstructure bridgeSubstructure = new BridgeSubstructure();
        BeanUtils.copyProperties(bridgeSubstructureDto, bridgeSubstructure);
        return bridgeSubstructure;
    }



}
