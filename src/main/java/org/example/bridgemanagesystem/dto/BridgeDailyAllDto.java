package org.example.bridgemanagesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.bridgemanagesystem.entity.DailyInspectionData;
import org.example.bridgemanagesystem.entity.DailyInspectionItem;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BridgeDailyAllDto {
    private DailyInspectionData dailyInspectionData;
    private List<DailyInspectionItem> dailyInspectionItems;
}
