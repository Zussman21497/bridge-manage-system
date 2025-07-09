package org.example.bridgemanagesystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.bridgemanagesystem.common.BridgeConverter;
import org.example.bridgemanagesystem.common.R;
import org.example.bridgemanagesystem.dto.*;
import org.example.bridgemanagesystem.entity.*;
import org.example.bridgemanagesystem.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/bridge")
public class BridgeInfoController {

    @Autowired
    private BridgeNormalInfoService bridgeNormalInfoService;

    @Autowired
    private BridgeSuperstructureService bridgeSuperstructureService;

    @Autowired
    private BridgeSubstructureService bridgeSubstructureService;

    @Autowired
    private BridgeOtherWorkService bridgeOtherWorkService;

    @Autowired
    private BridgePipelineService bridgePipelineService;

    @Autowired
    private  BridgeSummaryInfoService bridgeSummaryInfoService;


    /**
     * 查询所有桥梁名称返回给前端的下拉框
     * @return
     */
    @GetMapping("/searchBridgeNames")
    public R<List<String>> searchBridgeNames(){
        List<String> list = bridgeNormalInfoService.getAllBridgeNames();
        if(list == null){
            return R.error("未获取到桥梁名称");
        }
        return R.success(list);
    }

    /**
     * 把桥梁名称，结构类型，建成年月传给前端
     * @return
     */
    @GetMapping("/searchSummaryInfo")
    public R<List<BridgeSummaryInfo>> searchSummaryInfo(){

        List<BridgeSummaryInfo> list = bridgeSummaryInfoService.getBridgeSummary();

        if(list == null){
            return R.error("获取桥梁简易信息失败！");
        }
        return R.success(list);
    }



    /**
     * 桥梁一般资料查询
     *
     * @param bridgeName
     * @return
     */
    @GetMapping("/normal/search")
    public R<BridgeNormalInfoDto> searchGeneralBridgeInfo(@RequestParam String bridgeName) {

        if (bridgeName == null || bridgeName.trim().isEmpty()) {
            return R.error("桥梁名称不能为空！");
        }

        BridgeNormalInfo bridgeInfo = bridgeNormalInfoService.getInfoByName(bridgeName);

        if (bridgeInfo != null) {
            BridgeNormalInfoDto dto = new BridgeNormalInfoDto();
            BeanUtils.copyProperties(bridgeInfo, dto);
            return R.success(dto);
        }

        return R.error("获取桥梁一般资料失败！");
    }


    /**
     * 上部结构查询
     *
     * @param bridgeName
     * @return
     */
    @GetMapping("/superstructure/search")
    public R<BridgeSuperstructureDto> searchBridgeSuperstructure(@RequestParam String bridgeName) {

        if (bridgeName == null || bridgeName.trim().isEmpty()) {
            return R.error("桥梁名称不能为空！");
        }

        BridgeSuperstructure bridgeInfo = bridgeSuperstructureService.searchBridgeSuperstructureByName(bridgeName);

        if (bridgeInfo != null) {
            BridgeSuperstructureDto dto = new BridgeSuperstructureDto();
            BeanUtils.copyProperties(bridgeInfo, dto);
            return R.success(dto);
        }

        return R.error("获取桥梁上部结构失败！");

    }


    /**
     * 下部结构查询
     *
     * @param bridgeName
     * @return
     */
    @GetMapping("/substructure/search")
    public R<BridgeSubstructureDto> searchBridgeSubstructure(@RequestParam String bridgeName) {

        if (bridgeName == null || bridgeName.trim().isEmpty()) {
            return R.error("桥梁名称不能为空！");
        }

        BridgeSubstructure bridgeInfo = bridgeSubstructureService.searchBridgeSubstructureByName(bridgeName);

        if (bridgeInfo != null) {
            BridgeSubstructureDto dto = new BridgeSubstructureDto();
            BeanUtils.copyProperties(bridgeInfo, dto);
            return R.success(dto);
        }

        return R.error("获取桥梁下部结构失败！");

    }


    /**
     * 附属工程查询
     *
     * @param bridgeName
     * @return
     */
    @GetMapping("/other/work/search")
    public R<BridgeOtherWorkDto> searchBridgeOtherWork(@RequestParam String bridgeName) {

        if (bridgeName == null || bridgeName.trim().isEmpty()) {
            return R.error("桥梁名称不能为空！");
        }

        BridgeOtherWork bridgeInfo = bridgeOtherWorkService.searchBridgeOtherWorkByName(bridgeName);

        if (bridgeInfo != null) {
            BridgeOtherWorkDto dto = new BridgeOtherWorkDto();
            BeanUtils.copyProperties(bridgeInfo, dto);
            return R.success(dto);
        }

        return R.error("获取桥梁附属工程信息失败！");
    }

    /**
     * 附挂管线查询
     *
     * @param bridgeName
     * @return
     */
    @GetMapping("/pipeline/search")
    public R<BridgePipelineDto> searchBridgePipeline(@RequestParam String bridgeName) {

        if (bridgeName == null || bridgeName.trim().isEmpty()) {
            return R.error("桥梁名称不能为空！");
        }

        BridgePipeline bridgePipeline = bridgePipelineService.searchBridgePipelineByName(bridgeName);

        if (bridgePipeline != null) {
            BridgePipelineDto dto = new BridgePipelineDto();
            BeanUtils.copyProperties(bridgePipeline, dto);
            return R.success(dto);
        }

        return R.error("获取桥梁附挂管线信息失败！");
    }

    /**
     * 桥梁数据添加
     * @param bridgeFullInfoDto
     * @return
     */
    @PostMapping("/info/add")
// 关键：指定异常回滚（所有异常都回滚），确保数据一致性
    @Transactional(rollbackFor = Exception.class)
    public R<String> addBridgeFullInfo(@RequestBody BridgeFullInfoDto bridgeFullInfoDto) {
        try {
            // 1. 校验参数完整性
            if (bridgeFullInfoDto == null
                    || bridgeFullInfoDto.getBridgeNormalInfoDto() == null
                    || bridgeFullInfoDto.getBridgeOtherWorkDto() == null
                    || bridgeFullInfoDto.getBridgePipelineDto() == null
                    || bridgeFullInfoDto.getBridgeSuperstructureDto() == null
                    || bridgeFullInfoDto.getBridgeSubstructureDto() == null) {
                return R.error("表单数据不完整！");
            }

            // 2. 生成唯一桥梁ID（核心改进点）
            // 使用UUID确保各表数据关联到同一桥梁
            String bridgeId = UUID.randomUUID().toString().replaceAll("-", "");

            // 3. 为所有DTO设置统一的bridgeId（关键步骤）
            // 确保桥梁一般资料表的ID
            bridgeFullInfoDto.getBridgeNormalInfoDto().setBridgeId(bridgeId);
            // 确保上部结构表的ID与桥梁一致
            bridgeFullInfoDto.getBridgeSuperstructureDto().setBridgeId(bridgeId);
            // 确保下部结构表的ID与桥梁一致
            bridgeFullInfoDto.getBridgeSubstructureDto().setBridgeId(bridgeId);
            // 确保附属工程表的ID与桥梁一致
            bridgeFullInfoDto.getBridgeOtherWorkDto().setBridgeId(bridgeId);
            // 确保附挂管线表的ID与桥梁一致
            bridgeFullInfoDto.getBridgePipelineDto().setBridgeId(bridgeId);

            // 4. 转换DTO为实体并保存（简化判断逻辑）
            // 桥梁一般资料
            BridgeNormalInfo bridgeNormalInfo = BridgeConverter.toEntity(bridgeFullInfoDto.getBridgeNormalInfoDto());
            bridgeNormalInfoService.save(bridgeNormalInfo);

            // 桥梁附属工程
            BridgeOtherWork bridgeOtherWork = BridgeConverter.toEntity(bridgeFullInfoDto.getBridgeOtherWorkDto());
            bridgeOtherWorkService.save(bridgeOtherWork);

            // 桥梁附挂管线
            BridgePipeline bridgePipeline = BridgeConverter.toEntity(bridgeFullInfoDto.getBridgePipelineDto());
            bridgePipelineService.save(bridgePipeline);

            // 桥梁上部结构
            BridgeSuperstructure bridgeSuperstructure = BridgeConverter.toEntity(bridgeFullInfoDto.getBridgeSuperstructureDto());
            bridgeSuperstructureService.save(bridgeSuperstructure);

            // 桥梁下部结构
            BridgeSubstructure bridgeSubstructure = BridgeConverter.toEntity(bridgeFullInfoDto.getBridgeSubstructureDto());
            bridgeSubstructureService.save(bridgeSubstructure);

            // 5. 所有保存成功返回
            return R.success("添加成功！");

        } catch (Exception e) {
            // 6. 捕获异常并打印日志（方便排查问题）
            // 注意：实际项目中使用日志框架（如Slf4j）替代System.out
            e.printStackTrace();
            // 事务会自动回滚（因@Transactional配置）
            return R.error("服务器内部错误：" + e.getMessage());
        }
    }


}
