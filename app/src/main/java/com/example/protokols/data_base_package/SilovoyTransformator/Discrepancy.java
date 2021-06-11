package com.example.protokols.data_base_package.SilovoyTransformator;

import java.text.DecimalFormat;

public class Discrepancy {

    public String[] countingDiscrepancy(SilovoyTrans silovoyTrans){

        String[] phaseAB = {
                silovoyTrans.getRpnHvAB1(),
                silovoyTrans.getRpnHvAB2(),
                silovoyTrans.getRpnHvAB3(),
                silovoyTrans.getRpnHvAB4(),
                silovoyTrans.getRpnHvAB5(),
        };
        String[] phaseBC = {
                silovoyTrans.getRpnHvBC1(),
                silovoyTrans.getRpnHvBC2(),
                silovoyTrans.getRpnHvBC3(),
                silovoyTrans.getRpnHvBC4(),
                silovoyTrans.getRpnHvBC5(),
        };
        String[] phaseCA = {
                silovoyTrans.getRpnHvCA1(),
                silovoyTrans.getRpnHvCA2(),
                silovoyTrans.getRpnHvCA3(),
                silovoyTrans.getRpnHvCA4(),
                silovoyTrans.getRpnHvCA5(),
        };

        double[] AB = transformationArr(phaseAB);
        double[] BC = transformationArr(phaseBC);
        double[] CA = transformationArr(phaseCA);

        String[] resultHV = new String[5];


        for (int i = 0; i < 5; i++) {
            double max;
            double min;
            min = AB[i];
            if (AB[i]>=BC[i]){
                min = BC[i];
                if (BC[i]>=CA[i]) min = CA[i];
            }else {
                if (AB[i]>CA[i]) min = CA[i];
            }

            max = AB[i];
            if (AB[i]<=BC[i]){
                max = BC[i];
                if (BC[i]<=CA[i]) max = CA[i];
            }else {
                if (AB[i]<CA[i]) max = CA[i];
            }
            double res = (max-min)/min*100;
            resultHV[i] = String.format ("%.3f",res);
        }
        return resultHV;
    }

    private double[] transformationArr(String[] phase){
        double[] trans = new double[5];
        double d=0;
        String s;
        for (int i = 0; i < 5; i++) {
            if (phase[i]!=null & !phase[i].isEmpty()) {
                d = Double.parseDouble(phase[i]);
                s = String.format("%.3f",d);
                if (s.indexOf(',')!=-1 ) s = s.replace(",",".");
                trans[i] = Double.parseDouble(s);
            } else {
                trans[i]=1;
            }
        }
        return trans;
    }

    public String countingDiscrepancyLV(SilovoyTrans silovoyTrans){
        String resultLV ;
        double max;
        double min;
        double a = Double.parseDouble(silovoyTrans.getRpnLvAn());
        double b = Double.parseDouble(silovoyTrans.getRpnLvBn());
        double c = Double.parseDouble(silovoyTrans.getRpnLvCn());
        min =a;
        if (a>=b){
            min = b;
            if (b>=c) min = c;
        }else {
            if (a>c) min = c;
        }

        max = a;
        if (a<=b){
            max = b;
            if (b<=c) max = c;
        }else {
            if (a<c) max = c;
        }
        double res = (max-min)/min*100;
         resultLV= String.format ("%.3f",res);
         return resultLV;
    }
}
