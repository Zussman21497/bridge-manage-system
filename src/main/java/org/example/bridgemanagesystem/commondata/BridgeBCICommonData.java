package org.example.bridgemanagesystem.commondata;

/*
桥面系数常量权重
 */
public class BridgeBCICommonData {
    //桥面系
    public static final double BRIDGE_DECK_SYSTEM_WEIGHT_E=0.15;    //else
    public static final double BRIDGE_DECK_SYSTEM_WEIGHT_G=0.10;    //拱桥
    public static final double BRIDGE_DECK_SYSTEM_WEIGHT_R=0.15;    //人行天桥
    //上部结构
    public static final double SUPERSTRUCTURE_WEIGHT_E=0.40;        // else
    public static final double SUPERSTRUCTURE_WEIGHT_G=0.45;        //拱桥
    public static final double SUPERSTRUCTURE_WEIGHT_R=0.45;        //人行天桥
    //下部结构
    public static final double SUBSTRUCTURE_WEIGHT_E=0.45;          // else
    public static final double SUBSTRUCTURE_WEIGHT_G=0.45;          //拱桥
    public static final double SUBSTRUCTURE_WEIGHT_R=0.40;          //人行天桥
}
