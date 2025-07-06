package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.RegularInspectionData;
import org.example.bridgemanagesystem.mapper.RegularInspectionDataMapper;
import org.example.bridgemanagesystem.service.RegularInspectionDataService;
import org.springframework.stereotype.Service;

@Service
public class RegularInspectionDataServiceImpl extends ServiceImpl<RegularInspectionDataMapper, RegularInspectionData> implements RegularInspectionDataService {

    /**
     * 根据桥梁名称查定期巡查表
     * @param bridgeName
     * @return
     */
    public RegularInspectionData searchRegularInspectionByName(String bridgeName){
        RegularInspectionData data = baseMapper.selectOne(
                new LambdaQueryWrapper<RegularInspectionData>().eq(RegularInspectionData::getBridgeName, bridgeName)
        );

        return data;
    }

}
