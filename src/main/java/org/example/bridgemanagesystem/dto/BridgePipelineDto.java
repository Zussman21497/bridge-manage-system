package org.example.bridgemanagesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

//桥梁附挂管线表Dto
public class BridgePipelineDto {

    private String bridgeId;                       // 桥梁ID
    private String waterSupplyPipe;            // 给水管
    private String gasPipe;                    // 燃气管
    private String powerCable;                 // 电力缆
    private String telecommunicationCable;    // 通信电缆

}
