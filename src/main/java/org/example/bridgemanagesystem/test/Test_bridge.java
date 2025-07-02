package org.example.bridgemanagesystem.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Test_bridge {
    int id;
    int h;                          //桥面系的评价要素
    int a;                          //桥面系的评价要素的总数
    int[] MDPh=new int[5];          //桥面系第 h 类要素中损坏的综合扣分值
    int wh;                         //桥面系第 h 类要素的权重
    int[][] DPhi=new int[5][5];     //桥面系第 h 类要素中第 i 项损坏的扣分值
    int[][] whi=new int[5][5];      //桥面系第 h 类要素中第 i 项损坏的权重
    int[][] uhi=new int[5][5];      //桥面系第 h 类要素中第 i 项损坏的扣分占所有的比例
}
