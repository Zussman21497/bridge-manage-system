package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.DailyInspectionItem;
import org.example.bridgemanagesystem.mapper.DailyInspectionItemMapper;
import org.example.bridgemanagesystem.service.DailyInspectionItemService;
import org.springframework.stereotype.Service;

@Service
public class DailyInspectionItemServiceImpl extends ServiceImpl<DailyInspectionItemMapper, DailyInspectionItem> implements DailyInspectionItemService {
}
