package org.example.bridgemanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.bridgemanagesystem.entity.BridgeDefect;
import org.example.bridgemanagesystem.entity.BridgeNormalInfo;
import org.example.bridgemanagesystem.entity.EvaluationInfo;
import org.example.bridgemanagesystem.mapper.EvaluationInfoMapper;
import org.example.bridgemanagesystem.service.BridgeDefectService;
import org.example.bridgemanagesystem.service.BridgeNormalInfoService;
import org.example.bridgemanagesystem.service.EvaluationInfoService;


import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private  EvaluationInfoService evaluationInfoService;
    @Autowired
    BridgeNormalInfoServiceImpl b;
    @Autowired
    BridgeDefectService defectService;
    @Autowired
    private BridgeNormalInfoService bridgeNormalInfoService;

    /**
     * 桥面系BCI计算
     * @param id
     * @return
     */
    @Override
    public double count_bridge_deck_bci(String id) {
        double BCIm;

        //得到扣分数据
        QueryWrapper<BridgeDefect> wrapper=new QueryWrapper<BridgeDefect>()
                .eq("bridge_id",id);
        BridgeDefect bridgeDefect = defectService.getBaseMapper().selectOne(wrapper);
        //得到桥梁类型
        QueryWrapper<BridgeNormalInfo> wrapper1=new QueryWrapper<BridgeNormalInfo>()
                .eq("bridge_id",id);
        BridgeNormalInfo bridgeNormalInfo = bridgeNormalInfoService.getBaseMapper().selectOne(wrapper1);
        String bridgeType=bridgeNormalInfo.getStructureType();

        double MDP1=bridgeDefect.getThicknessOfDeckPavement(),
                MDP2=bridgeDefect.getExpansionJoint(),
                MDP3=bridgeDefect.getDrainageSystem(),
                MDP4=bridgeDefect.getRailing();
        if(bridgeType.equals("人行天桥")){
            BCIm=(100-MDP1)*THICKNESSOFDECKPAVEMENT_WEIGHT_R+
                    (100-MDP2)*EXPANSIONJOINT_WEIGHT_R+
                    (100-MDP3)*DRAINAGE_SYSTEM_WEIGHT_R+
                    (100-MDP4)*RAILING_WEIGHT_R;
        }else{
            double MDP5=bridgeDefect.getBridgeHead(),
                    MDP6=bridgeDefect.getCarriageway();
            BCIm=(100-MDP1)*THICKNESSOFDECKPAVEMENT_WEIGHT_E+
                    (100-MDP2)*EXPANSIONJOINT_WEIGHT_E+
                    (100-MDP3)*DRAINAGE_SYSTEM_WEIGHT_E+
                    (100-MDP4)*RAILING_WEIGHT_E+
                    (100-MDP5)*BRIDGEHEAD_WEIGHT_E+
                    (100-MDP6)*CARRIAGEWAY_WEIGHT_E;
        }
        return BCIm;
    }

    /**
     * 上部结构BCI计算
     * @param id
     * @return
     */
    @Override
    public double count_superstructure_bci(String id) {
        double BCIs;

        //得到扣分数据
        QueryWrapper<BridgeDefect> wrapper=new QueryWrapper<BridgeDefect>()
                .eq("bridge_id",id);
        BridgeDefect bridgeDefect = defectService.getBaseMapper().selectOne(wrapper);
        //得到桥梁类型
        QueryWrapper<BridgeNormalInfo> wrapper1=new QueryWrapper<BridgeNormalInfo>()
                .eq("bridge_id",id);
        BridgeNormalInfo bridgeNormalInfo = bridgeNormalInfoService.getBaseMapper().selectOne(wrapper1);
        String bridgeType=bridgeNormalInfo.getStructureType();

        int SDP1=bridgeDefect.getGirder(),
                SDP2=bridgeDefect.getHorizontalLinkage();
        if(bridgeType.equals("人行天桥")){
            BCIs=(100-SDP1)*GIRDER_WEIGHT_R+
                    (100-SDP2)*HORIZONTAL_LINKAGE_WEIGHT_R;
        }else {
            BCIs=(100-SDP1)*GIRDER_WEIGHT_E+
                    (100-SDP2)*HORIZONTAL_LINKAGE_WEIGHT_E;
        }
        return BCIs;
    }

    @Override
    public double count_superstructure_bsi(String id) {
        double BSIs;
        QueryWrapper<BridgeDefect> wrapper=new QueryWrapper<BridgeDefect>()
                .eq("bridge_id",id);
        BridgeDefect bridgeDefect = defectService.getBaseMapper().selectOne(wrapper);
        int SDP1=bridgeDefect.getGirder(),
                SDP2=bridgeDefect.getHorizontalLinkage();

        return SDP1-SDP2>=0?(100-SDP2):(100-SDP1);
    }

    /**
     * 下部结构BCI计算
     * @param id
     * @return
     */
    @Override
    public double count_substructure_bci(String id) {
        double BCIx;
        //得到扣分数据
        QueryWrapper<BridgeDefect> wrapper=new QueryWrapper<BridgeDefect>()
                .eq("bridge_id",id);
        BridgeDefect bridgeDefect = defectService.getBaseMapper().selectOne(wrapper);
        //得到桥梁类型
        QueryWrapper<BridgeNormalInfo> wrapper1=new QueryWrapper<BridgeNormalInfo>()
                .eq("bridge_id",id);
        BridgeNormalInfo bridgeNormalInfo = bridgeNormalInfoService.getBaseMapper().selectOne(wrapper1);
        String bridgeType=bridgeNormalInfo.getStructureType();

        int SDP1=bridgeDefect.getPierDimensions(),
                SDP2=bridgeDefect.getPierBody(),
                SDP3=bridgeDefect.getPierBaseElevation(),
                SDP4=bridgeDefect.getPierSupport(),
                SDP5=bridgeDefect.getAbutmentDimensions(),
                SDP6=bridgeDefect.getAbutmentBody(),
                SDP7=bridgeDefect.getAbutmentBaseElevation(),
                SDP8=bridgeDefect.getAbutmentSupport();
        if(bridgeType.equals("人行天桥")){
            BCIx=((100-SDP1)*PIER_DIMENSIONS_WEIGHT_R+
                    (100-SDP2)*PIER_BODY_WEIGHT_R+
                    (100-SDP3)*PIER_BASEELEVATION_WEIGHT_R+
                    (100-SDP4)*PIER_SUPPORT_WEIGHT_R+
                    (100-SDP5)*ABUTMENT_CAP_WEIGHT_R+
                    (100-SDP6)*ABUTMENT_BODY_WEIGHT_R+
                    (100-SDP7)*ABUTMENT_BASEELEVATION_WEIGHT_R+
                    (100-SDP8)*ABUTMENT_SUPPORT_WEIGHT_R)/2;
        }else {
            BCIx=((100-SDP1)*PIER_DIMENSIONS_WEIGHT_E+
                    (100-SDP2)*PIER_BODY_WEIGHT_E+
                    (100-SDP3)*PIER_BASEELEVATION_WEIGHT_E+
                    (100-SDP4)*PIER_SUPPORT_WEIGHT_E+
                    (100-SDP5)*ABUTMENT_CAP_WEIGHT_E+
                    (100-SDP6)*ABUTMENT_BODY_WEIGHT_E+
                    (100-SDP7)*ABUTMENT_BASEELEVATION_WEIGHT_E+
                    (100-SDP8)*ABUTMENT_SUPPORT_WEIGHT_E)/2;
        }
        return BCIx;
    }

    @Override
    public double count_substructure_bsi(String id) {
        double BSIx;
        QueryWrapper<BridgeDefect> wrapper=new QueryWrapper<BridgeDefect>()
                .eq("bridge_id",id);
        BridgeDefect bridgeDefect = defectService.getBaseMapper().selectOne(wrapper);
        int[] SDP=new int[8];
        SDP[1]=bridgeDefect.getPierDimensions();
        SDP[2]=bridgeDefect.getPierBody();
        SDP[3]=bridgeDefect.getPierBaseElevation();
        SDP[4]=bridgeDefect.getPierSupport();
        SDP[5]=bridgeDefect.getAbutmentDimensions();
        SDP[6]=bridgeDefect.getAbutmentBody();
        SDP[7]=bridgeDefect.getAbutmentBaseElevation();
        SDP[0]=bridgeDefect.getAbutmentSupport();
        int min=101;
        for (int i = 0; i < SDP.length; i++) {
            if(SDP[i]<min) min=SDP[i];
        }
        BSIx=(100-min);

        return BSIx;
    }

    /**
     * 整桥 BCI值
     * @param id
     * @return
     */
    @Override
    public double count_bridge_BCI(String id) {
        double BCI=0;
        double BCIm = count_bridge_deck_bci(id); //桥面系BCI
        double BCIs = count_superstructure_bci(id); //上部结构BCI
        double BCIx = count_substructure_bci(id); //下部结构BCI

        /*
        TODO:这个ID到时候从数据库里面查对应的桥梁分类
         */
        QueryWrapper<BridgeNormalInfo> wrapper1=new QueryWrapper<BridgeNormalInfo>()
                .eq("bridge_id",id);
        BridgeNormalInfo bridgeNormalInfo = bridgeNormalInfoService.getBaseMapper().selectOne(wrapper1);
        String bridgeType=bridgeNormalInfo.getStructureType();

        if (bridgeType.equals("人行天桥")){
            BCI=BCIm*BRIDGE_DECK_SYSTEM_WEIGHT_R+
                    BCIs*SUPERSTRUCTURE_WEIGHT_R+
                    BCIx*SUBSTRUCTURE_WEIGHT_R;
        }else {
            if(bridgeType.equals("拱桥")){
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
    public String judge_bci(double BCI) {
        String c="E";
        if(BCI>=90){
            c="A";
        } else if (BCI>=80){
            c="B";
        } else if (BCI>=66) {
            c="C";
        } else if (BCI>=50) {
            c="D";
        }
        return c;
    }

    @Override
    public String judge_bsi(double BSI) {
        String c="E";
        if(BSI>=90){
            c="A";
        } else if (BSI>=80){
            c="B";
        } else if (BSI>=66) {
            c="C";
        } else if (BSI>=50) {
            c="D";
        }
        return c;
    }


    /**
     * 通过桥梁名称查询对应的技术状况
     * @param bridgeName
     * @return
     */
    @Override
    public EvaluationInfo getByName(String bridgeName) {
        BridgeNormalInfo info = b.getInfoByName(bridgeName);
        String id=info.getBridgeId();
        QueryWrapper<EvaluationInfo> wrapper=new QueryWrapper<EvaluationInfo>()
                .eq("bridge_id",id);
        return evaluationInfoService.getBaseMapper().selectOne(wrapper);
    }




}