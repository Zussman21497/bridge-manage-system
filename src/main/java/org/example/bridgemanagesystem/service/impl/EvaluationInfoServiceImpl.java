package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.entity.EvaluationInfo;
import org.example.bridgemanagesystem.mapper.EvaluationInfoMapper;
import org.example.bridgemanagesystem.service.EvaluationInfoService;



import org.springframework.stereotype.Service;

import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.*;
import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.BRIDGE_DECK_SYSTEM_WEIGHT_E;
import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.BRIDGE_DECK_SYSTEM_WEIGHT_G;
import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.SUBSTRUCTURE_WEIGHT_E;
import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.SUBSTRUCTURE_WEIGHT_G;
import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.SUPERSTRUCTURE_WEIGHT_E;
import static org.example.bridgemanagesystem.commondata.BridgeBCICommonData.SUPERSTRUCTURE_WEIGHT_G;
import static org.example.bridgemanagesystem.commondata.BridgeDeckSystemBCICommonData.*;
import static org.example.bridgemanagesystem.commondata.SubstructureBCICommonData.*;
import static org.example.bridgemanagesystem.commondata.SuperstructureBCICommonData.*;

@Service
public class EvaluationInfoServiceImpl extends ServiceImpl<EvaluationInfoMapper,EvaluationInfo> implements EvaluationInfoService
{

    BridgeNormalInfo b=new BridgeNormalInfo();
    /**
     * 桥面系BCI计算
     * @return
     */
    @Override
    public double count_bridge_deck_bci(String id) {
        double BCIm;
        //TODO:后期这些 MDP均由前端输入

        int MDP1=0,MDP2=0,MDP3=0,MDP4=0;
        if(id=="人行天桥"){
            BCIm=MDP1*THICKNESSOFDECKPAVEMENT_WEIGHT_R+
                    MDP2*EXPANSIONJOINT_WEIGHT_R+
                    MDP3*DRAINAGE_SYSTEM_WEIGHT_R+
                    MDP4*RAILING_WEIGHT_R;
        }else{
            int MDP5=0,MDP6=0;
            BCIm=MDP1*THICKNESSOFDECKPAVEMENT_WEIGHT_E+
                    MDP2*EXPANSIONJOINT_WEIGHT_E+
                    MDP3*DRAINAGE_SYSTEM_WEIGHT_E+
                    MDP4*RAILING_WEIGHT_E+
                    MDP5*BRIDGEHEAD_WEIGHT_E+
                    MDP6*CARRIAGEWAY_WEIGHT_E;
        }

        return BCIm;
    }

    @Override
    public double count_superstructure_bci(String id) {
        double BCIs;
        //TODO:后期这些 SDP均由前端输入
        int SDP1=0,SDP2=0;
        if(id=="人行天桥"){
            BCIs=((100-SDP1)*GIRDER_WEIGHT_R+
                    (100-SDP2)*HORIZONTAL_LINKAGE_WEIGHT_R)
                    /2;
        }else {
            BCIs=((100-SDP1)*GIRDER_WEIGHT_E+
                    (100-SDP2)*HORIZONTAL_LINKAGE_WEIGHT_E)
                    /2;
        }

        return BCIs;
    }

    @Override
    public double count_substructure_bci(String id) {
        double BCIx;
        int SDP1=0,SDP2=0,SDP3=0,SDP4=0,SDP5=0,SDP6=0,SDP7=0,SDP8=0;
        if(id=="人行天桥"){
            BCIx=((100-SDP1)*PIER_DIMENSIONS_WEIGHT_R+
                    (100-SDP2)*PIER_BODY_WEIGHT_R+
                    (100-SDP3)*PIER_BASEELEVATION_WEIGHT_R+
                    (100-SDP4)*PIER_SUPPORT_WEIGHT_R+
                    (100-SDP5)*ABUTMENT_CAP_WEIGHT_R+
                    (100-SDP6)*ABUTMENT_BODY_WEIGHT_R+
                    (100-SDP7)*ABUTMENT_BASEELEVATION_WEIGHT_R+
                    (100-SDP8)*ABUTMENT_SUPPORT_WEIGHT_R)/8;
        }else {
            BCIx=((100-SDP1)*PIER_DIMENSIONS_WEIGHT_E+
                    (100-SDP2)*PIER_BODY_WEIGHT_E+
                    (100-SDP3)*PIER_BASEELEVATION_WEIGHT_E+
                    (100-SDP4)*PIER_SUPPORT_WEIGHT_E+
                    (100-SDP5)*ABUTMENT_CAP_WEIGHT_E+
                    (100-SDP6)*ABUTMENT_BODY_WEIGHT_E+
                    (100-SDP7)*ABUTMENT_BASEELEVATION_WEIGHT_E+
                    (100-SDP8)*ABUTMENT_SUPPORT_WEIGHT_E)/8;
        }
        return BCIx;
    }

    @Override
    public double count_bridge_BCI(String id) {
        double BCI=0;
        double BCIm = count_bridge_deck_bci(id); //桥面系BCI
        double BCIs = count_superstructure_bci(id); //上部结构BCI
        double BCIx = count_substructure_bci(id); //下部结构BCI

        /*
        TODO:这个ID到时候从数据库里面查对应的桥梁分类
         */
        if (id=="人行天桥"){
            BCI=BCIm*BRIDGE_DECK_SYSTEM_WEIGHT_R+
                    BCIs*SUPERSTRUCTURE_WEIGHT_R+
                    BCIx*SUBSTRUCTURE_WEIGHT_R;
        }else {
            if(id=="拱桥"){
                BCI=BCIm*BRIDGE_DECK_SYSTEM_WEIGHT_G+
                        BCIs*SUPERSTRUCTURE_WEIGHT_G+
                        BCIx*SUBSTRUCTURE_WEIGHT_G;
            }
            else {
                BCI=BCIm*BRIDGE_DECK_SYSTEM_WEIGHT_E+
                        BCIs*SUPERSTRUCTURE_WEIGHT_E+
                        BCIx*SUBSTRUCTURE_WEIGHT_E;
            }
        }

        return BCI;
    }

    @Override
    public EvaluationInfo getByName(String bridgeName) {
        return null;
    }


}