package org.example.bridgemanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.bridgemanagesystem.dto.SomeDailyInfoDto;
import org.example.bridgemanagesystem.entity.DailyInspectionData;

import java.util.List;

@Mapper
public interface DailyInspectionDataMapper extends BaseMapper<DailyInspectionData> {
    @Select("select bridge_name," +
            "inspection_date," +
            "inspector," +
            "inspection_unit," +
            "overall_status from bridge_inspection")
    List<SomeDailyInfoDto> getSomeDailyInfo();
}
