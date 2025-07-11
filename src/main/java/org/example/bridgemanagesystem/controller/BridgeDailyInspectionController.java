package org.example.bridgemanagesystem.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.bridgemanagesystem.common.R;
import org.example.bridgemanagesystem.dto.BridgeDailyAllDto;
import org.example.bridgemanagesystem.dto.DailyInspectionDataDto;
import org.example.bridgemanagesystem.dto.SomeDailyInfoDto;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.entity.DailyInspectionData;
import org.example.bridgemanagesystem.entity.DailyInspectionItem;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
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

    @Autowired
    private BridgeNormalInfoService b;
    /**
     * 日常检查表查询所有
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
        if (data == null) {
            return R.error("未找到该桥梁的巡检数据");
        }
        String id=data.getInspectionId();
        if (id == null || id.trim().isEmpty()) {
            return R.error("巡检记录 ID 为空");
        }

        R<List<DailyInspectionItem>> listR = d.searchDailyInspectionItem(id);
        if (listR == null || listR.getData() == null) {
            return R.error("未找到检查项数据");
        }

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
     * 查询日常表的部分数据
     * @return
     */
    @GetMapping("/search/some")
    public R<List<SomeDailyInfoDto>> searchSomeDailyInspection(){
        List<SomeDailyInfoDto> list=dailyInspectionDataService.getSomeDailyInfo();
        if (list!=null){
            return R.success(list);
        }
        return R.error("查询失败");
    }

    /**
     * 日常巡检表新添
     *
     * @param dto
     * @return
     */
    @Autowired
    IService<DailyInspectionItem> dailyInspectionItemService;
    @PostMapping("/add")
    public R<String> addDailyInspection(@RequestBody BridgeDailyAllDto dto) {
        if (dto == null) {
            return R.error("表单数据为空！");
        }

        DailyInspectionData data = dto.getDailyInspectionData();
        String bridgeName = data.getBridgeName();
        BridgeNormalInfo info=b.getInfoByName(bridgeName);
        if (info==null){
            return R.error("没有此桥梁,无法添加");
        }
        String id=info.getBridgeId();
        data.setBridgeId(id);

        boolean isMainSaved = dailyInspectionDataService.save(data);
        if (!isMainSaved) {
            return R.error("添加主记录失败！");
        }

        String inspectionId = data.getInspectionId();
        if (inspectionId == null) {
            return R.error("主记录ID生成失败！");
        }

        List<DailyInspectionItem> dailyInspectionItems = dto.getDailyInspectionItems();
        dailyInspectionItems.forEach(item -> {
            item.setRecordId(inspectionId);
        });

        boolean isItemsSaved = dailyInspectionItemService.saveBatch(dailyInspectionItems);
        if (!isItemsSaved) {
            throw new RuntimeException("检查项保存失败");
        }

        return R.success("添加日常巡查表及检查项成功！");
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
