package org.example.bridgemanagesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

//桥梁上部结构表
public class BridgeSuperstructure {

    @TableId(type = IdType.INPUT)
    private String bridgeId;                             // 桥梁ID
    private String girderType;                           // 主梁形式
    private String girderDimensions;                     // 主梁尺寸
    private Double numberOfGirders;                       // 主梁数量
    private String crossBeamType;                         // 横梁形式
    private Integer clearanceUnderMainSpan;              // 主跨桥下净空
    private Integer clearanceUnderBridge;                 // 桥下净高
    private String spanRatioOfArchBridge;                 // 拱桥矢跨比
    private String supportType;                            // 支座型式
    private Double numberOfSupports;                       // 支座数量
    private String deckStructure;                          // 桥面结构
    private Integer thicknessOfDeckPavement;               // 桥面铺装厚度
    private String expansionJointType;                     // 伸缩缝型式
    private Double numberOfExpansionJoints;                 // 伸缩缝数量
    private Integer mainBridgeLongitudinalSlope;           // 主桥纵坡
    private Integer mainBridgeCrossSlope;                   // 主桥横坡
    private Integer approachBridgeLongitudinalSlope;       // 引桥纵坡
    private Integer approachBridgeCrossSlope;               // 引桥横坡

}
