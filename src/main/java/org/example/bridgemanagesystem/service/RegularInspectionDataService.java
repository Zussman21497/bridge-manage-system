package org.example.bridgemanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.entity.RegularInspectionData;

public interface RegularInspectionDataService extends IService<RegularInspectionData> {

    /**
     * 根据桥梁名字查定期检查表
     * @param bridgeName
     * @return
     */
    RegularInspectionData searchRegularInspectionByName(String bridgeName);

}
