package org.example.bridgemanagesystem.controller;

import org.example.bridgemanagesystem.common.R;
import org.example.bridgemanagesystem.dto.BridgeDailyAllDto;
import org.example.bridgemanagesystem.dto.DailyInspectionDataDto;
import org.example.bridgemanagesystem.entity.DailyInspectionData;
import org.example.bridgemanagesystem.entity.DailyInspectionItem;
import org.example.bridgemanagesystem.service.DailyInspectionDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daily/info")
public class BridgeDailyInspectionController {

    @Autowired
    private DailyInspectionDataService dailyInspectionDataService;

    @Autowired
    private DailyInspectionItemController d;
    /**
     * 日常检查表查询
     *
     * @param bridgeName
     * @return
     */
    @GetMapping("/search")
    public R<BridgeDailyAllDto> searchDailyInspection(@RequestParam String bridgeName) {

        if (bridgeName == null || bridgeName.trim().isEmpty()) {
            return R.error("桥梁名称不能为空！");
        }

        DailyInspectionData data = dailyInspectionDataService.searchDataByName(bridgeName);
        String id=data.getInspectionId();

        R<List<DailyInspectionItem>> listR = d.searchDailyInspectionItem(id);
        BridgeDailyAllDto BDAll=new BridgeDailyAllDto();
        BDAll.setDailyInspectionData(data);
        List<DailyInspectionItem> data1 = listR.getData();
        BDAll.setDailyInspectionItems(data1);

        if (data1!=null) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(BDAll);
            return R.success(BDAll);
        }

        return R.error("获取日常巡查表失败");
    }

    /**
     * 日常巡检表新添
     *
     * @param dto
     * @return
     */
    @PostMapping("/add")
    public R<String> addDailyInspection(@RequestBody BridgeDailyAllDto dto) {

        if (dto == null) {
            return R.error("表单数据为空！");
        }


        DailyInspectionData data = dto.getDailyInspectionData();
        List<DailyInspectionItem> dailyInspectionItems=dto.getDailyInspectionItems();

        d.addDailyInspectionItem(dailyInspectionItems);
        boolean isAdded = dailyInspectionDataService.save(data);

        return isAdded
                ? R.success("添加日常巡查表成功！")
                : R.error("添加日常巡查表失败！");

    }


    /**
     * 日常巡检表更新
     *
     * @param dto
     * @return
     */
    @PutMapping("/update")
    public R<String> updateDailyInspection(@RequestBody DailyInspectionDataDto dto) {

        if (dto == null){
            return R.error("表单数据为空！");
        }

        DailyInspectionData data = new DailyInspectionData();
        BeanUtils.copyProperties(dto, data);

        boolean isUpdated = dailyInspectionDataService.updateById(data);

        return isUpdated
                ? R.success("更新日常巡察表成功！")
                : R.error("更新日常巡查表失败！");

    }


}
