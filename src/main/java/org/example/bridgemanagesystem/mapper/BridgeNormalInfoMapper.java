package org.example.bridgemanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;

import java.util.List;

@Mapper
public interface BridgeNormalInfoMapper extends BaseMapper<BridgeNormalInfo> {


    @Select("SELECT bridge_name FROM bridge_normal_info")
    List<String> getAllBridgeNames();

}
