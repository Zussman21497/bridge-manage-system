package org.example.bridgemanagesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.bridgemanagesystem.entity.BridgeDefect;
import org.example.bridgemanagesystem.entity.RegularInspectionData;

@Data
@AllArgsConstructor
@NoArgsConstructor
//定期检查表Dto
public class RegularInspectionDataDto {
    RegularInspectionData regularInspectionData;
    BridgeDefect bridgeDefect;
}
