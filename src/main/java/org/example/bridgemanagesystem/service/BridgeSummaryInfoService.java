package org.example.bridgemanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.entity.BridgeSummaryInfo;

import java.util.List;

public interface BridgeSummaryInfoService extends IService<BridgeSummaryInfo> {

    //获取桥梁名称，结构类型，建成年月
    List<BridgeSummaryInfo> getBridgeSummary();

}
