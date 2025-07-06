package org.example.bridgemanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.bridgemanagesystem.entity.BridgeSummaryInfo;

import java.util.List;

@Mapper
public interface BridgeSummaryInfoMapper extends BaseMapper<BridgeSummaryInfo> {


    //获取桥梁名称，结构类型，建成年月
    @Select("SELECT bridge_name, structure_type, completion_date FROM bridge_normal_info")
    List<BridgeSummaryInfo> getBridgeSummary();

}
