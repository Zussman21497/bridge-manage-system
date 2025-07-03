package org.example.bridgemanagesystem.service;

import org.example.bridgemanagesystem.entity.EvaluationInfo;

public interface EvaluationInfoService {

    /**
     * 根据id查询技术状况数据
     * @param id
     * @return
     */
    EvaluationInfo getById(String id);

}
