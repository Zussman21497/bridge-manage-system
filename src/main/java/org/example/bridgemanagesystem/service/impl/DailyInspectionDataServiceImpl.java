package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.DailyInspectionData;
import org.example.bridgemanagesystem.mapper.DailyInspectionDataMapper;
import org.example.bridgemanagesystem.service.DailyInspectionDataService;
import org.springframework.stereotype.Service;

@Service
public class DailyInspectionDataServiceImpl extends ServiceImpl<DailyInspectionDataMapper, DailyInspectionData> implements DailyInspectionDataService {

    /**
     * 根据桥梁名字获取日常巡查表
     * @param bridgeName
     * @return
     */
    public DailyInspectionData searchDataByName(String bridgeName){
        DailyInspectionData data = baseMapper.selectOne(
                new LambdaQueryWrapper<DailyInspectionData>().eq(DailyInspectionData::getBridgeName,bridgeName)
        );

        return data;
    }

}
