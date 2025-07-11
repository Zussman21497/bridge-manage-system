package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.BridgeSummaryInfo;
import org.example.bridgemanagesystem.mapper.BridgeSummaryInfoMapper;
import org.example.bridgemanagesystem.service.BridgeSummaryInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BridgeSummaryInfoServiceImpl extends ServiceImpl<BridgeSummaryInfoMapper, BridgeSummaryInfo> implements BridgeSummaryInfoService {

    /**
     * 获取桥梁名称，结构类型，建成年月
     * @return
     */
    public List<BridgeSummaryInfo> getBridgeSummary(){
        List<BridgeSummaryInfo> list = baseMapper.getBridgeSummary();

        if (list != null && !list.isEmpty()) {
            System.out.println("第一条数据的 bridgeId：" + list.get(0).getBridgeId());
        } else {
            System.out.println("查询结果为空");
        }
        return list;
    }

}
