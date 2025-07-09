package org.example.bridgemanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.bridgemanagesystem.entity.RegularInspectionData;

import java.util.List;

@Mapper
public interface RegularInspectionDataMapper extends BaseMapper<RegularInspectionData>{
    @Select("select record_id, " +
            "bridge_name, " +
            "inspection_date, " +
            "inspection_unit, " +
            "inspection_cycle, " +
            "inspector, " +
            "next_inspection_date, " +
            "suggestions from regular_inspection")
    List<RegularInspectionData> searchAll();
}
