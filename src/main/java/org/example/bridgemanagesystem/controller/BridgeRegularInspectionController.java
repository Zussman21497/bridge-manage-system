package org.example.bridgemanagesystem.controller;

import org.example.bridgemanagesystem.common.R;
import org.example.bridgemanagesystem.dto.RegularInspectionDataDto;
import org.example.bridgemanagesystem.entity.RegularInspectionData;
import org.example.bridgemanagesystem.service.RegularInspectionDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inspect/info")
public class BridgeRegularInspectionController {

    @Autowired
    private RegularInspectionDataService regularInspectionDataService;

    /**
     * 定期检查表查询
     * @param bridgeName
     * @return
     */
    @GetMapping("/search")
    public R<RegularInspectionDataDto> searchRegularInspection(@RequestParam String bridgeName){

        if(bridgeName == null || bridgeName.trim().isEmpty()){
            return R.error("桥梁名称不能为空！");
        }

        RegularInspectionData data = regularInspectionDataService.searchRegularInspectionByName(bridgeName);

        if(data == null){
            return R.error("未获取到日常巡察表");
        }

        RegularInspectionDataDto dto = new RegularInspectionDataDto();
        BeanUtils.copyProperties(data, dto);

        return R.success(dto);

    }

    /**
     * 定期检查表新添
     * @param dto
     * @return
     */
    @PostMapping("/add")
    public R<String> addRegularInspection(@RequestBody RegularInspectionDataDto dto){

        if(dto == null){
            return R.error("表单数据为空！");
        }

        RegularInspectionData data = new RegularInspectionData();
        BeanUtils.copyProperties(dto, data);

        boolean isAdded = regularInspectionDataService.save(data);

        return isAdded
                ? R.success("日常巡查表添加成功！")
                : R.error("日常巡察表添加失败！");

    }

}
