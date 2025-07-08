package org.example.bridgemanagesystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.bridgemanagesystem.common.R;
import org.example.bridgemanagesystem.entity.DailyInspectionItem;
import org.example.bridgemanagesystem.service.DailyInspectionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DailyInspectionItemController {

    @Autowired
    private DailyInspectionItemService d;

    /**
     * 根据检查记录中的id查询检查项目情况
     * @param id
     * @return
     */
    @GetMapping("")
    public R<List<DailyInspectionItem>> searchDailyInspectionItem(@PathVariable String id){
        if(id==null||id.isEmpty()){
            return R.error("id为空");
        }
        QueryWrapper<DailyInspectionItem> wrapper=new QueryWrapper<DailyInspectionItem>()
                .eq("record_id",id);

        List<DailyInspectionItem> dailyInspectionItem = d.getBaseMapper().selectList(wrapper);
        if (dailyInspectionItem!=null)return R.success(dailyInspectionItem);

        return R.error("查询错误!");
    }

    /**
     * 新添桥梁日常检查项目
     * @param dailyInspectionItems
     * @return
     */
    @PostMapping("")
    public String addDailyInspectionItem(@RequestBody List<DailyInspectionItem> dailyInspectionItems){
        if (dailyInspectionItems==null||dailyInspectionItems.isEmpty()){
            return "传入数据有误!";
        }
        boolean b = d.saveBatch(dailyInspectionItems);
        if (b) return "添加日常巡查项目成功!";
        return "添加日常巡检项目失败!";
    }

}
