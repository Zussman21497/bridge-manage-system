package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.RegularInspectionData;
import org.example.bridgemanagesystem.mapper.RegularInspectionDataMapper;
import org.example.bridgemanagesystem.service.RegularInspectionDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegularInspectionDataServiceImpl extends ServiceImpl<RegularInspectionDataMapper, RegularInspectionData> implements RegularInspectionDataService {

    @Override
    public List<RegularInspectionData> searchAll() {
        List<RegularInspectionData> list=baseMapper.searchAll();
        return list;
    }
}
