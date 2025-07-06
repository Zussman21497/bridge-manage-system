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


    /**
     * 查询所有桥梁名称返回给前端的下拉框
     * @return
     */
    public R<List<String>> searchBridgeNames(){
        List<String> list = bridgeNormalInfoService.getAllBridgeNames();

        if(list == null){
            return R.error("未获取到桥梁名称");
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
    @Transactional
    public R<String> addBridgeFullInfo(@RequestBody BridgeFullInfoDto bridgeFullInfoDto){

        if (bridgeFullInfoDto == null
                || bridgeFullInfoDto.getBridgeNormalInfoDto() == null
                || bridgeFullInfoDto.getBridgeOtherWorkDto() == null
                || bridgeFullInfoDto.getBridgePipelineDto() == null
                || bridgeFullInfoDto.getBridgeSuperstructureDto() == null
                || bridgeFullInfoDto.getBridgeSubstructureDto() == null) {

            return R.error("表单数据不完整！");
        }


        //分给桥梁一般资料
        BridgeNormalInfo bridgeNormalInfo = BridgeConverter.toEntity(bridgeFullInfoDto.getBridgeNormalInfoDto());
        boolean nor = bridgeNormalInfoService.save(bridgeNormalInfo);


        //分给桥梁附属工程
        BridgeOtherWork bridgeOtherWork = BridgeConverter.toEntity(bridgeFullInfoDto.getBridgeOtherWorkDto());
        boolean other = bridgeOtherWorkService.save(bridgeOtherWork);

        //分给桥梁附挂管线
        BridgePipeline bridgePipeline = BridgeConverter.toEntity(bridgeFullInfoDto.getBridgePipelineDto());
         boolean pipe = bridgePipelineService.save(bridgePipeline);


        //分给桥梁上部结构
        BridgeSuperstructure bridgeSuperstructure = BridgeConverter.toEntity(bridgeFullInfoDto.getBridgeSuperstructureDto());
        boolean supe = bridgeSuperstructureService.save(bridgeSuperstructure);

        //分给桥梁下部结构
        BridgeSubstructure bridgeSubstructure = BridgeConverter.toEntity(bridgeFullInfoDto.getBridgeSubstructureDto());
        boolean sub = bridgeSubstructureService.save(bridgeSubstructure);

        if (!nor) return R.error("桥梁一般资料保存失败！");
        if (!other) return R.error("桥梁附属工程保存失败！");
        if (!pipe) return R.error("桥梁附挂管线保存失败！");
        if (!supe) return R.error("桥梁上部结构保存失败！");
        if (!sub) return R.error("桥梁下部结构保存失败！");

        return R.success("添加成功！");


    }


}
