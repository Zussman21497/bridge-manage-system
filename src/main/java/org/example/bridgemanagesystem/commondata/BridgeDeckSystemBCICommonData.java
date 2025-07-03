package org.example.bridgemanagesystem.commondata;

/*
桥面系BCI权重细分
 */
public class BridgeDeckSystemBCICommonData {
    //else桥梁
    public static final double THICKNESSOFDECKPAVEMENT_WEIGHT_E=0.30; //桥面铺装权重
    public static final double BRIDGEHEAD_WEIGHT_E=0.15;              //桥头平顺权重
    public static final double EXPANSIONJOINT_WEIGHT_E=0.25;          //伸缩装置权重
    public static final double DRAINAGE_SYSTEM_WEIGHT_E=0.10;         //排水系统权重
    public static final double CARRIAGEWAY_WEIGHT_E=0.10;             //人行道权重
    public static final double RAILING_WEIGHT_E=0.10;                //栏杆权重

    //人行天桥
    public static final double THICKNESSOFDECKPAVEMENT_WEIGHT_R=0.40; //桥面铺装权重
    public static final double EXPANSIONJOINT_WEIGHT_R=0.15;          //伸缩装置权重
    public static final double DRAINAGE_SYSTEM_WEIGHT_R=0.20;         //排水系统权重
    public static final double RAILING_WEIGHT_R=0.25;                //栏杆权重
}
