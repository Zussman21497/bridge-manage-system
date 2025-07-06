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

//桥梁附挂管线表
public class BridgePipeline {

    @TableId(type = IdType.INPUT)
    private String bridgeId;                   // 桥梁ID
    private String waterSupplyPipe;            // 给水管
    private String gasPipe;                    // 燃气管
    private String powerCable;                 // 电力缆
    private String telecommunicationCable;    // 通信电缆

}
