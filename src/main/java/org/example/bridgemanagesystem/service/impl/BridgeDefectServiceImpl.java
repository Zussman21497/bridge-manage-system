package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.BridgeDefect;
import org.example.bridgemanagesystem.mapper.BridgeDefectMapper;
import org.example.bridgemanagesystem.service.BridgeDefectService;
import org.springframework.stereotype.Service;

@Service
public class BridgeDefectServiceImpl extends ServiceImpl<BridgeDefectMapper, BridgeDefect> implements BridgeDefectService {
}
