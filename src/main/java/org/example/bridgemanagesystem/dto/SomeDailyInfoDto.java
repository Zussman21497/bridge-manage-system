package org.example.bridgemanagesystem.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SomeDailyInfoDto {
    private String bridgeName;                  // 桥梁名称
    private String inspectionDate;              // 巡检日期（格式：yyyy-MM-dd）
    private String inspector;                   // 巡检人员
    private String inspectionUnit;              // 巡检单位
    private Integer overallStatus;              // 总体状况（1:良好，2:一般，3:较差，4:危险）
}
