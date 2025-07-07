package org.example.bridgemanagesystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 桥梁巡检主表
@TableName("bridge_inspection")
public class DailyInspectionData {
    @TableField("id")
    private String inspectionId;                // 巡检记录ID
    private String bridgeName;                  // 桥梁名称
    private String bridgeCode;                  // 桥梁编号
    private String roadName;                    // 所在道路名称
    private String inspectionDate;              // 巡检日期（格式：yyyy-MM-dd）
    private String inspector;                   // 巡检人员
    private String inspectionUnit;              // 巡检单位
    private String weather;                     // 天气情况
    private String temperature;                 // 温度
    private Integer overallStatus;              // 总体状况（1:良好，2:一般，3:较差，4:危险）
    private String remark;                      // 备注信息
    private String createTime;                  // 创建时间
    private String updateTime;                  // 更新时间
}