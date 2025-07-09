package org.example.bridgemanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.bridgemanagesystem.entity.EvaluationInfo;

import java.util.List;

@Mapper
public interface EvaluationInfoMapper extends BaseMapper<EvaluationInfo> {
    @Override
    int insert(EvaluationInfo entity);

    @Select("select tech_status_evaluation.whole_bridge_bci from tech_status_evaluation")
    List<Integer> getBridgeBCI();
}

