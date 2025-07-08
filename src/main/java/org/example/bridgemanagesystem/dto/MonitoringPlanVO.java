package org.example.bridgemanagesystem.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MonitoringPlanVO {
    private String summary;                   // 环境总结
    private Map<String, Object> details;      // 每项监测配置
    private List<String> suggestions;         // 系统建议
}

