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

        String[] result = new String[5];


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
            result[i] = String.format ("%.3f",res);
        }
        return result;
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
}
