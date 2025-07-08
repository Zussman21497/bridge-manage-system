package org.example.bridgemanagesystem.service;

import org.example.bridgemanagesystem.dto.InspectionManagementDto;
import org.example.bridgemanagesystem.dto.MonitoringPlanVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MonitoringPlanService {

    public MonitoringPlanVO generate(InspectionManagementDto dto) {
        List<String> suggestions = new ArrayList<>();
        Map<String, Object> details = new LinkedHashMap<>();

        // 环境分析
        String env = dto.getEnvironment();
        String envRisk = switch (env) {
            case "山区" -> "高风险";
            case "城市" -> "中等风险";
            case "沿海" -> "高湿腐蚀";
            default -> "未知环境";
        };

        // 裂缝监测
        var crack = dto.getCrackWidthAndDepthMonitoringDto();
        if (crack != null) {
            details.put("Crack Monitoring", Map.of(
                    "Frequency", crack.getMonitoringFrequency(),
                    "Width Threshold", crack.getWidthThreshold() + "mm",
                    "Depth Threshold", crack.getDepthThreshold() + "mm"
            ));
            if (crack.getWidthThreshold() != null && crack.getWidthThreshold() > 0.3) {
                suggestions.add("裂缝宽度超过常规限值，建议加强观测。");
            }
        }

        // 应力应变
        var stress = dto.getStressAndStrainMonitoringDto();
        if (stress != null) {
            details.put("Stress/Strain Monitoring", Map.of(
                    "Frequency", stress.getMonitoringFrequency(),
                    "Threshold", stress.getThresholdRange() + " με"
            ));
            if (stress.getThresholdRange() != null && stress.getThresholdRange() > 200) {
                suggestions.add("应变阈值偏高，建议设置报警机制。");
            }
        }

        // 位移监测
        var disp = dto.getStructuralDisplacementMonitoringDto();
        if (disp != null) {
            details.put("Displacement Monitoring", Map.of(
                    "Frequency", disp.getMonitoringFrequency(),
                    "Threshold", disp.getThresholdRange() + " mm"
            ));
            if ("山区".equals(env) && "每日".equals(disp.getMonitoringFrequency())) {
                suggestions.add("山区建议每日监测位移，便于提前识别风险。");
            }
        }

        // 汇总 VO
        MonitoringPlanVO vo = new MonitoringPlanVO();
        vo.setSummary("环境：" + env + "（" + envRisk + "）的监测方案已生成");
        vo.setDetails(details);
        vo.setSuggestions(suggestions);

        return vo;
    }
}

