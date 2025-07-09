package org.example.bridgemanagesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.entity.RegularInspectionData;

import java.util.List;

public interface RegularInspectionDataService extends IService<RegularInspectionData> {

    List<RegularInspectionData> searchAll();
}
