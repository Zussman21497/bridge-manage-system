package org.example.bridgemanagesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

//桥梁附属工程表Dto
public class BridgeOtherWorkDto {

    private String catchmentOpeningDimensions;          // 集水口尺寸
    private Double numberOfCatchmentOpenings;           // 集水口数量
    private String drainPipeDimensions;                 // 泄水管尺寸
    private Integer drainPipeLength;                    // 泄水管长度
    private Integer totalLengthOfRailings;              // 栏杆总长
    private String railingStructure;                    // 栏杆结构
    private String endPostDimensions;                   // 端柱尺寸
    private String bankProtectionType;                  // 护岸类型
    private String retainingWallTypeOfApproachSlope;    // 引坡挡墙类型

}
