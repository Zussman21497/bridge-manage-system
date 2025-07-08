package org.example.bridgemanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.dto.SomeDailyInfoDto;
import org.example.bridgemanagesystem.entity.DailyInspectionData;

import java.util.List;

public interface DailyInspectionDataService extends IService<DailyInspectionData> {

    /**
     * 根据桥梁名字获取日常巡查表
     * @param bridgeName
     * @return
     */
    DailyInspectionData searchDataByName(String bridgeName);

    List<SomeDailyInfoDto> getSomeDailyInfo();
}
