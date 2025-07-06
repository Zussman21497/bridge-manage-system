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

//桥梁下部结构表
public class BridgeSubstructure {

    @TableId(type = IdType.INPUT)
    private String bridgeId;                             // 桥梁ID
    private String pierType;                             // 桥墩形式
    private Double numberOfPiers;                        // 桥墩数量
    private Integer pierElevation;                       // 桥墩标高
    private String capDimensions;                        // 盖梁尺寸
    private Integer baseElevationOfPier;                 // 基底标高
    private String bottomPlateDimensions;                // 底板尺寸
    private String foundationPileDimensions;             // 基桩尺寸
    private Double numberOfFoundationPiles;               // 基桩根数
    private String abutmentType;                          // 桥台形式
    private Double numberOfAbutments;                      // 桥台数量
    private Integer abutmentElevation;                    // 桥台标高
    private Integer baseElevationOfAbutment;              // 基底标高
    private String abutmentCapDimensions;                 // 台帽尺寸
    private String abutmentBottomPlateDimensions;         // 底板尺寸
    private String abutmentFoundationPileDimensions;      // 基桩尺寸
    private Double abutmentNumberOfFoundationPiles;       // 基桩根数
    private Integer thicknessOfRetainingWall;             // 挡土墙厚度
    private String wingWallType;                           // 翼墙形式
    private Integer lengthOfWingWall;                      // 翼墙长度

}

