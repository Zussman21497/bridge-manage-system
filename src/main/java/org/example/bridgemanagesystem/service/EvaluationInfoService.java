package org.example.bridgemanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.dto.EvaluationInfoDTO;
import org.example.bridgemanagesystem.entity.EvaluationInfo;

public interface EvaluationInfoService extends IService<EvaluationInfo> {
    /*
    计算桥面系 BCI值
     */
    double count_bridge_deck_bci(String id);

    /*
    计算上部结构 BCI值
     */
    double count_superstructure_bci(String id);

    /*
    计算上部结构 BSI值
     */
    double count_superstructure_bsi(String id);

    /*
    计算下部结构 BCI值
     */
    double count_substructure_bci(String id);

    /*
    计算下部结构 BSI值
     */
    double count_substructure_bsi(String id);
    /*
    计算整个桥的 BCI
     */
    double count_bridge_BCI(String id);

    String judge_bci(double BCI);

    String judge_bsi(double BSI);

    /*
    根据桥梁名称查询桥梁技术状况评估表
     */
    EvaluationInfo getByName(String bridgeName);
}