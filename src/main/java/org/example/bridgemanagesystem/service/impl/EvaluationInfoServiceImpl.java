package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.EvaluationInfo;
import org.example.bridgemanagesystem.mapper.EvaluationInfoMapper;
import org.example.bridgemanagesystem.service.EvaluationInfoService;
import org.example.bridgemanagesystem.test.Test_bridge;
import org.springframework.stereotype.Service;

@Service
public class EvaluationInfoServiceImpl extends ServiceImpl<EvaluationInfoMapper,EvaluationInfo> implements EvaluationInfoService
{
    Test_bridge t=new Test_bridge();

    @Override
    public double count_bridge_deck_weight() {
        int BCI;

        return 0;
    }
}
