package org.example.bridgemanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.entity.EvaluationInfo;

public interface EvaluationInfoService extends IService<EvaluationInfo> {
    /*
    计算整个桥的BCI值
     */
    double count_bridge_deck_weight();
}
