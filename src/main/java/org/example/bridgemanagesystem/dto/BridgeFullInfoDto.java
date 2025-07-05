package org.example.bridgemanagesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.bridgemanagesystem.entity.BridgePipeline;

@Data
@AllArgsConstructor
@NoArgsConstructor
//桥梁全部资料表
public class BridgeFullInfoDto {
    private BridgeNormalInfoDto bridgeNormalInfoDto;
    private BridgeOtherWorkDto bridgeOtherWorkDto;
    private BridgePipelineDto bridgePipelineDto;
    private BridgeSubstructureDto bridgeSubstructureDto;
    private BridgeSuperstructureDto bridgeSuperstructureDto;
}
