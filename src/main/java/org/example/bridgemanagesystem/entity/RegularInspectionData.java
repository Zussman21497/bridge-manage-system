package org.example.bridgemanagesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


//定期检查表
@TableName("regular_inspection")
public class RegularInspectionData {

    @TableId(type = IdType.AUTO)
    private Integer recordId;           // 记录ID
    private String bridgeName;          //桥梁名称
    private String bridgeId ;            // 桥梁ID
    private String inspectionDate;        // 检查日期
    private String inspectionUnit;      // 检查单位
    private String inspectionCycle;     // 检查周期
    private String inspector;           // 检查人员
    private String nextInspectionDate;    // 下次检查时间
    private String suggestions;         // 建议
}
