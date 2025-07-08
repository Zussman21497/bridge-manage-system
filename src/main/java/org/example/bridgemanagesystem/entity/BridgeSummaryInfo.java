package org.example.bridgemanagesystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridgeSummaryInfo {
    
    private String bridgeId;
    private String bridgeName;                     // 桥梁名称
    private String structureType;                  // 结构类型
    private String completionDate;                 // 建成年月

}
