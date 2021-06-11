package com.example.protokols.data_base_package.SilovoyTransformator;

public class CountingDiscrepancy {

    private double[] countingDiscrepancy(SilovoyTrans silovoyTrans){

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

        double[] result = new double[5];


        for (int i = 0; i < 4; i++) {
            double max;
            double min;
            min = AB[i];
            if (AB[i]>BC[i]){
                min = BC[i];
                if (BC[i]>CA[i]) min = CA[i];
            }else {
                if (AB[i]>CA[i]) min = CA[i];
            }

            max = AB[i];
            if (AB[i]<BC[i]){
                max = BC[i];
                if (BC[i]<CA[i]) max = CA[i];
            }else {
                if (AB[i]<CA[i]) max = CA[i];
            }

            result[i] = (max-min)/min;
        }
        return result;
    }

    private double[] transformationArr(String[] phase){
        double[] trans = new double[5];
        for (int i = 0; i < 4; i++) {
            trans[i] = Double.parseDouble(phase[i]);
        }
        return trans;
    }
}
