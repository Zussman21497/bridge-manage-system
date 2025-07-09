package org.example.bridgemanagesystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.bridgemanagesystem.common.R;
import org.example.bridgemanagesystem.dto.RegularInspectionDataDto;
import org.example.bridgemanagesystem.entity.BridgeDefect;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.entity.RegularInspectionData;
import org.example.bridgemanagesystem.service.BridgeDefectService;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.example.bridgemanagesystem.service.RegularInspectionDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inspect/info")
public class BridgeRegularInspectionController {

    @Autowired
    private RegularInspectionDataService regularInspectionDataService;

    @Autowired
    private BridgeNormalInfoService b;

    @Autowired
    private BridgeDefectService bridgeDefectService;
    /**
     * 查询基础属性
     * @return
     */
    @GetMapping("/search")
    public R<List<RegularInspectionData>> searchRegularInspection(){
        List<RegularInspectionData> list=regularInspectionDataService.searchAll();
        if (list!=null){
            return R.success(list);
        }
        return R.error("查询失败");
    }

    /**
     * 根据名称查询定期检查详细数据
     * @param bridgeName
     * @return
     */
    @GetMapping("/search/{bridgeName}")
    public R<RegularInspectionDataDto> searchAllRegular(@PathVariable String bridgeName){
        String id=b.getInfoByName(bridgeName).getBridgeId();
        QueryWrapper<RegularInspectionData> wrapper=new QueryWrapper<RegularInspectionData>()
                .eq("bridge_name",bridgeName);
        RegularInspectionData data = regularInspectionDataService.getBaseMapper().selectOne(wrapper);
        if (data==null){
            return R.error("查询失败!");
        }

        QueryWrapper<BridgeDefect> wrapper1=new QueryWrapper<BridgeDefect>()
                .eq("bridge_id",id);
        BridgeDefect bridgeDefect = bridgeDefectService.getBaseMapper().selectOne(wrapper1);
        if (bridgeDefect==null){
            return R.error("查询失败!");
        }
        RegularInspectionDataDto dto=new RegularInspectionDataDto();
        dto.setRegularInspectionData(data);
        dto.setBridgeDefect(bridgeDefect);

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
        RegularInspectionData regularInspectionData=dto.getRegularInspectionData();

        String bridgeName=regularInspectionData.getBridgeName();
        BridgeNormalInfo name = b.getInfoByName(bridgeName);
        if(name==null){
            return R.error("没有此桥梁,无法添加检查表");
        }
        String id= name.getBridgeId();

        regularInspectionData.setBridgeId(id);
        BridgeDefect defect=dto.getBridgeDefect();
        defect.setBridgeId(id);

        boolean save = regularInspectionDataService.save(regularInspectionData);
        boolean save1 = bridgeDefectService.save(defect);

        if (save1&&save)return R.success("添加成功!");


        return R.error("添加失败!");
    }

    /**
     * 定期检查表更新
     * @param dto
     * @return
     */
    @PutMapping("/update")
    public R<String> updateRegularInspection(@RequestBody RegularInspectionDataDto dto){

        RegularInspectionData data = new RegularInspectionData();
        BeanUtils.copyProperties(dto, data);

        boolean isUpdated = regularInspectionDataService.updateById(data);

        return isUpdated
                ? R.success("定期检查表更新成功！")
                : R.error("定期检查表更新失败！");

    }



}
