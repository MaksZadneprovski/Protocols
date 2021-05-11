package com.example.protokols.data_base_package.SilovoyTransformator;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class SilovoyTrans {
    // Table
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @ColumnInfo(name = "Object")
    public String mObjectOrPodstancia;

    @ColumnInfo(name = "Work")
    public String mWork;

    @ColumnInfo(name = "Date")
    public String mDate;

    @ColumnInfo(name = "Temperature")
    public String mTemperature;

    @ColumnInfo(name = "PasportType")
    public String PasportType;

    @ColumnInfo(name = "PasportZavNumber")
    public String PasportZavNumber;

    @ColumnInfo(name = "PasportPower")
    public String PasportPower;

    @ColumnInfo(name = "PasportVoltage")
    public String PasportVoltage;

    @ColumnInfo(name = "PasportCurrent")
    public String PasportCurrent;

    @ColumnInfo(name = "PasportVoltageKz")
    public String PasportVoltageKz;

    @ColumnInfo(name = "PasportYearOfManufacture")
    public String PasportYearOfManufacture;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @ColumnInfo(name = "IzolHvR15")
    public String IzolHvR15;

    @ColumnInfo(name = "IzolHvR60")
    public String IzolHvR60;

    @ColumnInfo(name = "IzolHvKoef")
    public String IzolHvKoef;

    @ColumnInfo(name = "IzolLvR15")
    public String IzolLvR15;

    @ColumnInfo(name = "IzolLvR60")
    public String IzolLvR60;

    @ColumnInfo(name = "IzolLvKoef")
    public String IzolLvKoef;

    @ColumnInfo(name = "UnitsDCresistance")
    public String UnitsDCresistance;

    @ColumnInfo(name = "QuantityRpn")
    public String QuantityRpn;

    @ColumnInfo(name = "SwitchOperationPosition")
    public String SwitchOperationPosition;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @ColumnInfo(name = "RpnHvAB1")
    public String RpnHvAB1;

    @ColumnInfo(name = "RpnHvAB2")
    public String RpnHvAB2;

    @ColumnInfo(name = "RpnHvAB3")
    public String RpnHvAB3;

    @ColumnInfo(name = "RpnHvAB4")
    public String RpnHvAB4;

    @ColumnInfo(name = "RpnHvAB5")
    public String RpnHvAB5;

    @ColumnInfo(name = "RpnHvAB6")
    public String RpnHvAB6;

    @ColumnInfo(name = "RpnHvAB7")
    public String RpnHvAB7;

    @ColumnInfo(name = "RpnHvAB8")
    public String RpnHvAB8;

    @ColumnInfo(name = "RpnHvAB9")
    public String RpnHvAB9;

    @ColumnInfo(name = "RpnHvAB10")
    public String RpnHvAB10;

    @ColumnInfo(name = "RpnHvAB11")
    public String RpnHvAB11;

    @ColumnInfo(name = "RpnHvAB12")
    public String RpnHvAB12;

    @ColumnInfo(name = "RpnHvAB13")
    public String RpnHvAB13;

    @ColumnInfo(name = "RpnHvAB14")
    public String RpnHvAB14;

    @ColumnInfo(name = "RpnHvAB15")
    public String RpnHvAB15;

    @ColumnInfo(name = "RpnHvAB16")
    public String RpnHvAB16;

    @ColumnInfo(name = "RpnHvAB17")
    public String RpnHvAB17;

    @ColumnInfo(name = "RpnHvAB18")
    public String RpnHvAB18;

    @ColumnInfo(name = "RpnHvAB19")
    public String RpnHvAB19;

    @ColumnInfo(name = "RpnHvAB20")
    public String RpnHvAB20;

    @ColumnInfo(name = "RpnHvAB21")
    public String RpnHvAB21;

    @ColumnInfo(name = "RpnHvAB22")
    public String RpnHvAB22;

    @ColumnInfo(name = "RpnHvAB23")
    public String RpnHvAB23;

    @ColumnInfo(name = "RpnHvAB24")
    public String RpnHvAB24;

    @ColumnInfo(name = "RpnHvAB25")
    public String RpnHvAB25;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @ColumnInfo(name = "RpnHvBC1")
    public String RpnHvBC1;

    @ColumnInfo(name = "RpnHvBC2")
    public String RpnHvBC2;

    @ColumnInfo(name = "RpnHvBC3")
    public String RpnHvBC3;

    @ColumnInfo(name = "RpnHvBC4")
    public String RpnHvBC4;

    @ColumnInfo(name = "RpnHvBC5")
    public String RpnHvBC5;

    @ColumnInfo(name = "RpnHvBC6")
    public String RpnHvBC6;

    @ColumnInfo(name = "RpnHvBC7")
    public String RpnHvBC7;

    @ColumnInfo(name = "RpnHvBC8")
    public String RpnHvBC8;

    @ColumnInfo(name = "RpnHvBC9")
    public String RpnHvBC9;

    @ColumnInfo(name = "RpnHvBC10")
    public String RpnHvBC10;

    @ColumnInfo(name = "RpnHvBC11")
    public String RpnHvBC11;

    @ColumnInfo(name = "RpnHvBC12")
    public String RpnHvBC12;

    @ColumnInfo(name = "RpnHvBC13")
    public String RpnHvBC13;

    @ColumnInfo(name = "RpnHvBC14")
    public String RpnHvBC14;

    @ColumnInfo(name = "RpnHvBC15")
    public String RpnHvBC15;

    @ColumnInfo(name = "RpnHvBC16")
    public String RpnHvBC16;

    @ColumnInfo(name = "RpnHvBC17")
    public String RpnHvBC17;

    @ColumnInfo(name = "RpnHvBC18")
    public String RpnHvBC18;

    @ColumnInfo(name = "RpnHvBC19")
    public String RpnHvBC19;

    @ColumnInfo(name = "RpnHvBC20")
    public String RpnHvBC20;

    @ColumnInfo(name = "RpnHvBC21")
    public String RpnHvBC21;

    @ColumnInfo(name = "RpnHvBC22")
    public String RpnHvBC22;

    @ColumnInfo(name = "RpnHvBC23")
    public String RpnHvBC23;

    @ColumnInfo(name = "RpnHvBC24")
    public String RpnHvBC24;

    @ColumnInfo(name = "RpnHvBC25")
    public String RpnHvBC25;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @ColumnInfo(name = "RpnHvCA1")
    public String RpnHvCA1;

    @ColumnInfo(name = "RpnHvCA2")
    public String RpnHvCA2;

    @ColumnInfo(name = "RpnHvCA3")
    public String RpnHvCA3;

    @ColumnInfo(name = "RpnHvCA4")
    public String RpnHvCA4;

    @ColumnInfo(name = "RpnHvCA5")
    public String RpnHvCA5;

    @ColumnInfo(name = "RpnHvCA6")
    public String RpnHvCA6;

    @ColumnInfo(name = "RpnHvCA7")
    public String RpnHvCA7;

    @ColumnInfo(name = "RpnHvCA8")
    public String RpnHvCA8;

    @ColumnInfo(name = "RpnHvCA9")
    public String RpnHvCA9;

    @ColumnInfo(name = "RpnHvCA10")
    public String RpnHvCA10;

    @ColumnInfo(name = "RpnHvCA11")
    public String RpnHvCA11;

    @ColumnInfo(name = "RpnHvCA12")
    public String RpnHvCA12;

    @ColumnInfo(name = "RpnHvCA13")
    public String RpnHvCA13;

    @ColumnInfo(name = "RpnHvCA14")
    public String RpnHvCA14;

    @ColumnInfo(name = "RpnHvCA15")
    public String RpnHvCA15;

    @ColumnInfo(name = "RpnHvCA16")
    public String RpnHvCA16;

    @ColumnInfo(name = "RpnHvCA17")
    public String RpnHvCA17;

    @ColumnInfo(name = "RpnHvCA18")
    public String RpnHvCA18;

    @ColumnInfo(name = "RpnHvCA19")
    public String RpnHvCA19;

    @ColumnInfo(name = "RpnHvCA20")
    public String RpnHvCA20;

    @ColumnInfo(name = "RpnHvCA21")
    public String RpnHvCA21;

    @ColumnInfo(name = "RpnHvCA22")
    public String RpnHvCA22;

    @ColumnInfo(name = "RpnHvCA23")
    public String RpnHvCA23;

    @ColumnInfo(name = "RpnHvCA24")
    public String RpnHvCA24;

    @ColumnInfo(name = "RpnHvCA25")
    public String RpnHvCA25;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @ColumnInfo(name = "WindingConnectionDiagramLv")
    public String WindingConnectionDiagramLv;

    @ColumnInfo(name = "RpnLvAn")
    public String RpnLvAn;

    @ColumnInfo(name = "RpnLvBn")
    public String RpnLvBn;

    @ColumnInfo(name = "RpnLvCn")
    public String RpnLvCn;

    @ColumnInfo(name = "Notes")
    public String Notes;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////


    public SilovoyTrans() {
    }

    public SilovoyTrans(int id, String mObjectOrPodstancia, String mWork, String mDate, String mTemperature, String pasportType,
                        String pasportZavNumber, String pasportPower, String pasportVoltage, String pasportCurrent, String pasportVoltageKz,
                        String pasportYearOfManufacture, String izolHvR15, String izolHvR60, String izolHvKoef, String izolLvR15, String izolLvR60,
                        String izolLvKoef, String unitsDCresistance, String quantityRpn, String switchOperationPosition, String rpnHvAB1,
                        String rpnHvAB2, String rpnHvAB3, String rpnHvAB4, String rpnHvAB5, String rpnHvAB6, String rpnHvAB7, String rpnHvAB8, String rpnHvAB9,
                        String rpnHvAB10, String rpnHvAB11, String rpnHvAB12, String rpnHvAB13, String rpnHvAB14, String rpnHvAB15, String rpnHvAB16,
                        String rpnHvAB17, String rpnHvAB18, String rpnHvAB19, String rpnHvAB20, String rpnHvAB21, String rpnHvAB22, String rpnHvAB23,
                        String rpnHvAB24, String rpnHvAB25, String rpnHvBC1, String rpnHvBC2, String rpnHvBC3, String rpnHvBC4, String rpnHvBC5, String rpnHvBC6,
                        String rpnHvBC7, String rpnHvBC8, String rpnHvBC9, String rpnHvBC10, String rpnHvBC11, String rpnHvBC12, String rpnHvBC13, String rpnHvBC14,
                        String rpnHvBC15, String rpnHvBC16, String rpnHvBC17, String rpnHvBC18, String rpnHvBC19, String rpnHvBC20, String rpnHvBC21,
                        String rpnHvBC22, String rpnHvBC23, String rpnHvBC24, String rpnHvBC25, String rpnHvCA1, String rpnHvCA2, String rpnHvCA3, String rpnHvCA4,
                        String rpnHvCA5, String rpnHvCA6, String rpnHvCA7, String rpnHvCA8, String rpnHvCA9, String rpnHvCA10, String rpnHvCA11, String rpnHvCA12,
                        String rpnHvCA13, String rpnHvCA14, String rpnHvCA15, String rpnHvCA16, String rpnHvCA17, String rpnHvCA18, String rpnHvCA19, String rpnHvCA20,
                        String rpnHvCA21, String rpnHvCA22, String rpnHvCA23, String rpnHvCA24, String rpnHvCA25, String windingConnectionDiagramLv, String rpnLvAn,
                        String rpnLvBn, String rpnLvCn, String notes) {
        this.id = id;
        this.mObjectOrPodstancia = mObjectOrPodstancia;
        this.mWork = mWork;
        this.mDate = mDate;
        this.mTemperature = mTemperature;
        PasportType = pasportType;
        PasportZavNumber = pasportZavNumber;
        PasportPower = pasportPower;
        PasportVoltage = pasportVoltage;
        PasportCurrent = pasportCurrent;
        PasportVoltageKz = pasportVoltageKz;
        PasportYearOfManufacture = pasportYearOfManufacture;
        IzolHvR15 = izolHvR15;
        IzolHvR60 = izolHvR60;
        IzolHvKoef = izolHvKoef;
        IzolLvR15 = izolLvR15;
        IzolLvR60 = izolLvR60;
        IzolLvKoef = izolLvKoef;
        UnitsDCresistance = unitsDCresistance;
        QuantityRpn = quantityRpn;
        SwitchOperationPosition = switchOperationPosition;
        RpnHvAB1 = rpnHvAB1;
        RpnHvAB2 = rpnHvAB2;
        RpnHvAB3 = rpnHvAB3;
        RpnHvAB4 = rpnHvAB4;
        RpnHvAB5 = rpnHvAB5;
        RpnHvAB6 = rpnHvAB6;
        RpnHvAB7 = rpnHvAB7;
        RpnHvAB8 = rpnHvAB8;
        RpnHvAB9 = rpnHvAB9;
        RpnHvAB10 = rpnHvAB10;
        RpnHvAB11 = rpnHvAB11;
        RpnHvAB12 = rpnHvAB12;
        RpnHvAB13 = rpnHvAB13;
        RpnHvAB14 = rpnHvAB14;
        RpnHvAB15 = rpnHvAB15;
        RpnHvAB16 = rpnHvAB16;
        RpnHvAB17 = rpnHvAB17;
        RpnHvAB18 = rpnHvAB18;
        RpnHvAB19 = rpnHvAB19;
        RpnHvAB20 = rpnHvAB20;
        RpnHvAB21 = rpnHvAB21;
        RpnHvAB22 = rpnHvAB22;
        RpnHvAB23 = rpnHvAB23;
        RpnHvAB24 = rpnHvAB24;
        RpnHvAB25 = rpnHvAB25;
        RpnHvBC1 = rpnHvBC1;
        RpnHvBC2 = rpnHvBC2;
        RpnHvBC3 = rpnHvBC3;
        RpnHvBC4 = rpnHvBC4;
        RpnHvBC5 = rpnHvBC5;
        RpnHvBC6 = rpnHvBC6;
        RpnHvBC7 = rpnHvBC7;
        RpnHvBC8 = rpnHvBC8;
        RpnHvBC9 = rpnHvBC9;
        RpnHvBC10 = rpnHvBC10;
        RpnHvBC11 = rpnHvBC11;
        RpnHvBC12 = rpnHvBC12;
        RpnHvBC13 = rpnHvBC13;
        RpnHvBC14 = rpnHvBC14;
        RpnHvBC15 = rpnHvBC15;
        RpnHvBC16 = rpnHvBC16;
        RpnHvBC17 = rpnHvBC17;
        RpnHvBC18 = rpnHvBC18;
        RpnHvBC19 = rpnHvBC19;
        RpnHvBC20 = rpnHvBC20;
        RpnHvBC21 = rpnHvBC21;
        RpnHvBC22 = rpnHvBC22;
        RpnHvBC23 = rpnHvBC23;
        RpnHvBC24 = rpnHvBC24;
        RpnHvBC25 = rpnHvBC25;
        RpnHvCA1 = rpnHvCA1;
        RpnHvCA2 = rpnHvCA2;
        RpnHvCA3 = rpnHvCA3;
        RpnHvCA4 = rpnHvCA4;
        RpnHvCA5 = rpnHvCA5;
        RpnHvCA6 = rpnHvCA6;
        RpnHvCA7 = rpnHvCA7;
        RpnHvCA8 = rpnHvCA8;
        RpnHvCA9 = rpnHvCA9;
        RpnHvCA10 = rpnHvCA10;
        RpnHvCA11 = rpnHvCA11;
        RpnHvCA12 = rpnHvCA12;
        RpnHvCA13 = rpnHvCA13;
        RpnHvCA14 = rpnHvCA14;
        RpnHvCA15 = rpnHvCA15;
        RpnHvCA16 = rpnHvCA16;
        RpnHvCA17 = rpnHvCA17;
        RpnHvCA18 = rpnHvCA18;
        RpnHvCA19 = rpnHvCA19;
        RpnHvCA20 = rpnHvCA20;
        RpnHvCA21 = rpnHvCA21;
        RpnHvCA22 = rpnHvCA22;
        RpnHvCA23 = rpnHvCA23;
        RpnHvCA24 = rpnHvCA24;
        RpnHvCA25 = rpnHvCA25;
        WindingConnectionDiagramLv = windingConnectionDiagramLv;
        RpnLvAn = rpnLvAn;
        RpnLvBn = rpnLvBn;
        RpnLvCn = rpnLvCn;
        Notes = notes;
    }

    @Ignore
    public SilovoyTrans( String mObjectOrPodstancia, String mWork, String mDate, String mTemperature, String pasportType,
                         String pasportZavNumber, String pasportPower, String pasportVoltage, String pasportCurrent, String pasportVoltageKz,
                         String pasportYearOfManufacture, String izolHvR15, String izolHvR60, String izolHvKoef, String izolLvR15, String izolLvR60,
                         String izolLvKoef, String unitsDCresistance, String quantityRpn, String switchOperationPosition, String rpnHvAB1,
                         String rpnHvAB2, String rpnHvAB3, String rpnHvAB4, String rpnHvAB5, String rpnHvAB6, String rpnHvAB7, String rpnHvAB8, String rpnHvAB9,
                         String rpnHvAB10, String rpnHvAB11, String rpnHvAB12, String rpnHvAB13, String rpnHvAB14, String rpnHvAB15, String rpnHvAB16,
                         String rpnHvAB17, String rpnHvAB18, String rpnHvAB19, String rpnHvAB20, String rpnHvAB21, String rpnHvAB22, String rpnHvAB23,
                         String rpnHvAB24, String rpnHvAB25, String rpnHvBC1, String rpnHvBC2, String rpnHvBC3, String rpnHvBC4, String rpnHvBC5, String rpnHvBC6,
                         String rpnHvBC7, String rpnHvBC8, String rpnHvBC9, String rpnHvBC10, String rpnHvBC11, String rpnHvBC12, String rpnHvBC13, String rpnHvBC14,
                         String rpnHvBC15, String rpnHvBC16, String rpnHvBC17, String rpnHvBC18, String rpnHvBC19, String rpnHvBC20, String rpnHvBC21,
                         String rpnHvBC22, String rpnHvBC23, String rpnHvBC24, String rpnHvBC25, String rpnHvCA1, String rpnHvCA2, String rpnHvCA3, String rpnHvCA4,
                         String rpnHvCA5, String rpnHvCA6, String rpnHvCA7, String rpnHvCA8, String rpnHvCA9, String rpnHvCA10, String rpnHvCA11, String rpnHvCA12,
                         String rpnHvCA13, String rpnHvCA14, String rpnHvCA15, String rpnHvCA16, String rpnHvCA17, String rpnHvCA18, String rpnHvCA19, String rpnHvCA20,
                         String rpnHvCA21, String rpnHvCA22, String rpnHvCA23, String rpnHvCA24, String rpnHvCA25, String windingConnectionDiagramLv, String rpnLvAn,
                         String rpnLvBn, String rpnLvCn, String notes) {
        this.mObjectOrPodstancia = mObjectOrPodstancia;
        this.mWork = mWork;
        this.mDate = mDate;
        this.mTemperature = mTemperature;
        PasportType = pasportType;
        PasportZavNumber = pasportZavNumber;
        PasportPower = pasportPower;
        PasportVoltage = pasportVoltage;
        PasportCurrent = pasportCurrent;
        PasportVoltageKz = pasportVoltageKz;
        PasportYearOfManufacture = pasportYearOfManufacture;
        IzolHvR15 = izolHvR15;
        IzolHvR60 = izolHvR60;
        IzolHvKoef = izolHvKoef;
        IzolLvR15 = izolLvR15;
        IzolLvR60 = izolLvR60;
        IzolLvKoef = izolLvKoef;
        UnitsDCresistance = unitsDCresistance;
        QuantityRpn = quantityRpn;
        SwitchOperationPosition = switchOperationPosition;
        RpnHvAB1 = rpnHvAB1;
        RpnHvAB2 = rpnHvAB2;
        RpnHvAB3 = rpnHvAB3;
        RpnHvAB4 = rpnHvAB4;
        RpnHvAB5 = rpnHvAB5;
        RpnHvAB6 = rpnHvAB6;
        RpnHvAB7 = rpnHvAB7;
        RpnHvAB8 = rpnHvAB8;
        RpnHvAB9 = rpnHvAB9;
        RpnHvAB10 = rpnHvAB10;
        RpnHvAB11 = rpnHvAB11;
        RpnHvAB12 = rpnHvAB12;
        RpnHvAB13 = rpnHvAB13;
        RpnHvAB14 = rpnHvAB14;
        RpnHvAB15 = rpnHvAB15;
        RpnHvAB16 = rpnHvAB16;
        RpnHvAB17 = rpnHvAB17;
        RpnHvAB18 = rpnHvAB18;
        RpnHvAB19 = rpnHvAB19;
        RpnHvAB20 = rpnHvAB20;
        RpnHvAB21 = rpnHvAB21;
        RpnHvAB22 = rpnHvAB22;
        RpnHvAB23 = rpnHvAB23;
        RpnHvAB24 = rpnHvAB24;
        RpnHvAB25 = rpnHvAB25;
        RpnHvBC1 = rpnHvBC1;
        RpnHvBC2 = rpnHvBC2;
        RpnHvBC3 = rpnHvBC3;
        RpnHvBC4 = rpnHvBC4;
        RpnHvBC5 = rpnHvBC5;
        RpnHvBC6 = rpnHvBC6;
        RpnHvBC7 = rpnHvBC7;
        RpnHvBC8 = rpnHvBC8;
        RpnHvBC9 = rpnHvBC9;
        RpnHvBC10 = rpnHvBC10;
        RpnHvBC11 = rpnHvBC11;
        RpnHvBC12 = rpnHvBC12;
        RpnHvBC13 = rpnHvBC13;
        RpnHvBC14 = rpnHvBC14;
        RpnHvBC15 = rpnHvBC15;
        RpnHvBC16 = rpnHvBC16;
        RpnHvBC17 = rpnHvBC17;
        RpnHvBC18 = rpnHvBC18;
        RpnHvBC19 = rpnHvBC19;
        RpnHvBC20 = rpnHvBC20;
        RpnHvBC21 = rpnHvBC21;
        RpnHvBC22 = rpnHvBC22;
        RpnHvBC23 = rpnHvBC23;
        RpnHvBC24 = rpnHvBC24;
        RpnHvBC25 = rpnHvBC25;
        RpnHvCA1 = rpnHvCA1;
        RpnHvCA2 = rpnHvCA2;
        RpnHvCA3 = rpnHvCA3;
        RpnHvCA4 = rpnHvCA4;
        RpnHvCA5 = rpnHvCA5;
        RpnHvCA6 = rpnHvCA6;
        RpnHvCA7 = rpnHvCA7;
        RpnHvCA8 = rpnHvCA8;
        RpnHvCA9 = rpnHvCA9;
        RpnHvCA10 = rpnHvCA10;
        RpnHvCA11 = rpnHvCA11;
        RpnHvCA12 = rpnHvCA12;
        RpnHvCA13 = rpnHvCA13;
        RpnHvCA14 = rpnHvCA14;
        RpnHvCA15 = rpnHvCA15;
        RpnHvCA16 = rpnHvCA16;
        RpnHvCA17 = rpnHvCA17;
        RpnHvCA18 = rpnHvCA18;
        RpnHvCA19 = rpnHvCA19;
        RpnHvCA20 = rpnHvCA20;
        RpnHvCA21 = rpnHvCA21;
        RpnHvCA22 = rpnHvCA22;
        RpnHvCA23 = rpnHvCA23;
        RpnHvCA24 = rpnHvCA24;
        RpnHvCA25 = rpnHvCA25;
        WindingConnectionDiagramLv = windingConnectionDiagramLv;
        RpnLvAn = rpnLvAn;
        RpnLvBn = rpnLvBn;
        RpnLvCn = rpnLvCn;
        Notes = notes;
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObject() {
        return mObjectOrPodstancia;
    }

    public void setObject(String objectOrPodstancia) {
        mObjectOrPodstancia = objectOrPodstancia;
    }

    public String getWork() {
        return mWork;
    }

    public void setWork(String Work) {
        mWork = Work;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getTemperature() {
        return mTemperature;
    }

    public void setTemperature(String temperature) {
        mTemperature = temperature;
    }

    public String getPasportType() {
        return PasportType;
    }

    public void setPasportType(String pasportType) {
        PasportType = pasportType;
    }

    public String getPasportZavNumber() {
        return PasportZavNumber;
    }

    public void setPasportZavNumber(String pasportZavNumber) {
        PasportZavNumber = pasportZavNumber;
    }

    public String getPasportPower() {
        return PasportPower;
    }

    public void setPasportPower(String pasportPower) {
        PasportPower = pasportPower;
    }

    public String getPasportVoltage() {
        return PasportVoltage;
    }

    public void setPasportVoltage(String pasportVoltage) {
        PasportVoltage = pasportVoltage;
    }

    public String getPasportCurrent() {
        return PasportCurrent;
    }

    public void setPasportCurrent(String pasportCurrent) {
        PasportCurrent = pasportCurrent;
    }

    public String getPasportVoltageKz() {
        return PasportVoltageKz;
    }

    public void setPasportVoltageKz(String pasportVoltageKz) {
        PasportVoltageKz = pasportVoltageKz;
    }

    public String getPasportYearOfManufacture() {
        return PasportYearOfManufacture;
    }

    public void setPasportYearOfManufacture(String pasportYearOfManufacture) {
        PasportYearOfManufacture = pasportYearOfManufacture;
    }

    public String getIzolHvR15() {
        return IzolHvR15;
    }

    public void setIzolHvR15(String izolHvR15) {
        IzolHvR15 = izolHvR15;
    }

    public String getIzolHvR60() {
        return IzolHvR60;
    }

    public void setIzolHvR60(String izolHvR60) {
        IzolHvR60 = izolHvR60;
    }

    public String getIzolHvKoef() {
        return IzolHvKoef;
    }

    public void setIzolHvKoef(String izolHvKoef) {
        IzolHvKoef = izolHvKoef;
    }

    public String getIzolLvR15() {
        return IzolLvR15;
    }

    public void setIzolLvR15(String izolLvR15) {
        IzolLvR15 = izolLvR15;
    }

    public String getIzolLvR60() {
        return IzolLvR60;
    }

    public void setIzolLvR60(String izolLvR60) {
        IzolLvR60 = izolLvR60;
    }

    public String getIzolLvKoef() {
        return IzolLvKoef;
    }

    public void setIzolLvKoef(String izolLvKoef) {
        IzolLvKoef = izolLvKoef;
    }

    public String getUnitsDCresistance() {
        return UnitsDCresistance;
    }

    public void setUnitsDCresistance(String unitsDCresistance) {
        UnitsDCresistance = unitsDCresistance;
    }

    public String getQuantityRpn() {
        return QuantityRpn;
    }

    public void setQuantityRpn(String quantityRpn) {
        QuantityRpn = quantityRpn;
    }

    public String getSwitchOperationPosition() {
        return SwitchOperationPosition;
    }

    public void setSwitchOperationPosition(String switchOperationPosition) {
        SwitchOperationPosition = switchOperationPosition;
    }

    public String getRpnHvAB1() {
        return RpnHvAB1;
    }

    public void setRpnHvAB1(String rpnHvAB1) {
        RpnHvAB1 = rpnHvAB1;
    }

    public String getRpnHvAB2() {
        return RpnHvAB2;
    }

    public void setRpnHvAB2(String rpnHvAB2) {
        RpnHvAB2 = rpnHvAB2;
    }

    public String getRpnHvAB3() {
        return RpnHvAB3;
    }

    public void setRpnHvAB3(String rpnHvAB3) {
        RpnHvAB3 = rpnHvAB3;
    }

    public String getRpnHvAB4() {
        return RpnHvAB4;
    }

    public void setRpnHvAB4(String rpnHvAB4) {
        RpnHvAB4 = rpnHvAB4;
    }

    public String getRpnHvAB5() {
        return RpnHvAB5;
    }

    public void setRpnHvAB5(String rpnHvAB5) {
        RpnHvAB5 = rpnHvAB5;
    }

    public String getRpnHvAB6() {
        return RpnHvAB6;
    }

    public void setRpnHvAB6(String rpnHvAB6) {
        RpnHvAB6 = rpnHvAB6;
    }

    public String getRpnHvAB7() {
        return RpnHvAB7;
    }

    public void setRpnHvAB7(String rpnHvAB7) {
        RpnHvAB7 = rpnHvAB7;
    }

    public String getRpnHvAB8() {
        return RpnHvAB8;
    }

    public void setRpnHvAB8(String rpnHvAB8) {
        RpnHvAB8 = rpnHvAB8;
    }

    public String getRpnHvAB9() {
        return RpnHvAB9;
    }

    public void setRpnHvAB9(String rpnHvAB9) {
        RpnHvAB9 = rpnHvAB9;
    }

    public String getRpnHvAB10() {
        return RpnHvAB10;
    }

    public void setRpnHvAB10(String rpnHvAB10) {
        RpnHvAB10 = rpnHvAB10;
    }

    public String getRpnHvAB11() {
        return RpnHvAB11;
    }

    public void setRpnHvAB11(String rpnHvAB11) {
        RpnHvAB11 = rpnHvAB11;
    }

    public String getRpnHvAB12() {
        return RpnHvAB12;
    }

    public void setRpnHvAB12(String rpnHvAB12) {
        RpnHvAB12 = rpnHvAB12;
    }

    public String getRpnHvAB13() {
        return RpnHvAB13;
    }

    public void setRpnHvAB13(String rpnHvAB13) {
        RpnHvAB13 = rpnHvAB13;
    }

    public String getRpnHvAB14() {
        return RpnHvAB14;
    }

    public void setRpnHvAB14(String rpnHvAB14) {
        RpnHvAB14 = rpnHvAB14;
    }

    public String getRpnHvAB15() {
        return RpnHvAB15;
    }

    public void setRpnHvAB15(String rpnHvAB15) {
        RpnHvAB15 = rpnHvAB15;
    }

    public String getRpnHvAB16() {
        return RpnHvAB16;
    }

    public void setRpnHvAB16(String rpnHvAB16) {
        RpnHvAB16 = rpnHvAB16;
    }

    public String getRpnHvAB17() {
        return RpnHvAB17;
    }

    public void setRpnHvAB17(String rpnHvAB17) {
        RpnHvAB17 = rpnHvAB17;
    }

    public String getRpnHvAB18() {
        return RpnHvAB18;
    }

    public void setRpnHvAB18(String rpnHvAB18) {
        RpnHvAB18 = rpnHvAB18;
    }

    public String getRpnHvAB19() {
        return RpnHvAB19;
    }

    public void setRpnHvAB19(String rpnHvAB19) {
        RpnHvAB19 = rpnHvAB19;
    }

    public String getRpnHvAB20() {
        return RpnHvAB20;
    }

    public void setRpnHvAB20(String rpnHvAB20) {
        RpnHvAB20 = rpnHvAB20;
    }

    public String getRpnHvAB21() {
        return RpnHvAB21;
    }

    public void setRpnHvAB21(String rpnHvAB21) {
        RpnHvAB21 = rpnHvAB21;
    }

    public String getRpnHvAB22() {
        return RpnHvAB22;
    }

    public void setRpnHvAB22(String rpnHvAB22) {
        RpnHvAB22 = rpnHvAB22;
    }

    public String getRpnHvAB23() {
        return RpnHvAB23;
    }

    public void setRpnHvAB23(String rpnHvAB23) {
        RpnHvAB23 = rpnHvAB23;
    }

    public String getRpnHvAB24() {
        return RpnHvAB24;
    }

    public void setRpnHvAB24(String rpnHvAB24) {
        RpnHvAB24 = rpnHvAB24;
    }

    public String getRpnHvAB25() {
        return RpnHvAB25;
    }

    public void setRpnHvAB25(String rpnHvAB25) {
        RpnHvAB25 = rpnHvAB25;
    }

    public String getRpnHvBC1() {
        return RpnHvBC1;
    }

    public void setRpnHvBC1(String rpnHvBC1) {
        RpnHvBC1 = rpnHvBC1;
    }

    public String getRpnHvBC2() {
        return RpnHvBC2;
    }

    public void setRpnHvBC2(String rpnHvBC2) {
        RpnHvBC2 = rpnHvBC2;
    }

    public String getRpnHvBC3() {
        return RpnHvBC3;
    }

    public void setRpnHvBC3(String rpnHvBC3) {
        RpnHvBC3 = rpnHvBC3;
    }

    public String getRpnHvBC4() {
        return RpnHvBC4;
    }

    public void setRpnHvBC4(String rpnHvBC4) {
        RpnHvBC4 = rpnHvBC4;
    }

    public String getRpnHvBC5() {
        return RpnHvBC5;
    }

    public void setRpnHvBC5(String rpnHvBC5) {
        RpnHvBC5 = rpnHvBC5;
    }

    public String getRpnHvBC6() {
        return RpnHvBC6;
    }

    public void setRpnHvBC6(String rpnHvBC6) {
        RpnHvBC6 = rpnHvBC6;
    }

    public String getRpnHvBC7() {
        return RpnHvBC7;
    }

    public void setRpnHvBC7(String rpnHvBC7) {
        RpnHvBC7 = rpnHvBC7;
    }

    public String getRpnHvBC8() {
        return RpnHvBC8;
    }

    public void setRpnHvBC8(String rpnHvBC8) {
        RpnHvBC8 = rpnHvBC8;
    }

    public String getRpnHvBC9() {
        return RpnHvBC9;
    }

    public void setRpnHvBC9(String rpnHvBC9) {
        RpnHvBC9 = rpnHvBC9;
    }

    public String getRpnHvBC10() {
        return RpnHvBC10;
    }

    public void setRpnHvBC10(String rpnHvBC10) {
        RpnHvBC10 = rpnHvBC10;
    }

    public String getRpnHvBC11() {
        return RpnHvBC11;
    }

    public void setRpnHvBC11(String rpnHvBC11) {
        RpnHvBC11 = rpnHvBC11;
    }

    public String getRpnHvBC12() {
        return RpnHvBC12;
    }

    public void setRpnHvBC12(String rpnHvBC12) {
        RpnHvBC12 = rpnHvBC12;
    }

    public String getRpnHvBC13() {
        return RpnHvBC13;
    }

    public void setRpnHvBC13(String rpnHvBC13) {
        RpnHvBC13 = rpnHvBC13;
    }

    public String getRpnHvBC14() {
        return RpnHvBC14;
    }

    public void setRpnHvBC14(String rpnHvBC14) {
        RpnHvBC14 = rpnHvBC14;
    }

    public String getRpnHvBC15() {
        return RpnHvBC15;
    }

    public void setRpnHvBC15(String rpnHvBC15) {
        RpnHvBC15 = rpnHvBC15;
    }

    public String getRpnHvBC16() {
        return RpnHvBC16;
    }

    public void setRpnHvBC16(String rpnHvBC16) {
        RpnHvBC16 = rpnHvBC16;
    }

    public String getRpnHvBC17() {
        return RpnHvBC17;
    }

    public void setRpnHvBC17(String rpnHvBC17) {
        RpnHvBC17 = rpnHvBC17;
    }

    public String getRpnHvBC18() {
        return RpnHvBC18;
    }

    public void setRpnHvBC18(String rpnHvBC18) {
        RpnHvBC18 = rpnHvBC18;
    }

    public String getRpnHvBC19() {
        return RpnHvBC19;
    }

    public void setRpnHvBC19(String rpnHvBC19) {
        RpnHvBC19 = rpnHvBC19;
    }

    public String getRpnHvBC20() {
        return RpnHvBC20;
    }

    public void setRpnHvBC20(String rpnHvBC20) {
        RpnHvBC20 = rpnHvBC20;
    }

    public String getRpnHvBC21() {
        return RpnHvBC21;
    }

    public void setRpnHvBC21(String rpnHvBC21) {
        RpnHvBC21 = rpnHvBC21;
    }

    public String getRpnHvBC22() {
        return RpnHvBC22;
    }

    public void setRpnHvBC22(String rpnHvBC22) {
        RpnHvBC22 = rpnHvBC22;
    }

    public String getRpnHvBC23() {
        return RpnHvBC23;
    }

    public void setRpnHvBC23(String rpnHvBC23) {
        RpnHvBC23 = rpnHvBC23;
    }

    public String getRpnHvBC24() {
        return RpnHvBC24;
    }

    public void setRpnHvBC24(String rpnHvBC24) {
        RpnHvBC24 = rpnHvBC24;
    }

    public String getRpnHvBC25() {
        return RpnHvBC25;
    }

    public void setRpnHvBC25(String rpnHvBC25) {
        RpnHvBC25 = rpnHvBC25;
    }

    public String getRpnHvCA1() {
        return RpnHvCA1;
    }

    public void setRpnHvCA1(String rpnHvCA1) {
        RpnHvCA1 = rpnHvCA1;
    }

    public String getRpnHvCA2() {
        return RpnHvCA2;
    }

    public void setRpnHvCA2(String rpnHvCA2) {
        RpnHvCA2 = rpnHvCA2;
    }

    public String getRpnHvCA3() {
        return RpnHvCA3;
    }

    public void setRpnHvCA3(String rpnHvCA3) {
        RpnHvCA3 = rpnHvCA3;
    }

    public String getRpnHvCA4() {
        return RpnHvCA4;
    }

    public void setRpnHvCA4(String rpnHvCA4) {
        RpnHvCA4 = rpnHvCA4;
    }

    public String getRpnHvCA5() {
        return RpnHvCA5;
    }

    public void setRpnHvCA5(String rpnHvCA5) {
        RpnHvCA5 = rpnHvCA5;
    }

    public String getRpnHvCA6() {
        return RpnHvCA6;
    }

    public void setRpnHvCA6(String rpnHvCA6) {
        RpnHvCA6 = rpnHvCA6;
    }

    public String getRpnHvCA7() {
        return RpnHvCA7;
    }

    public void setRpnHvCA7(String rpnHvCA7) {
        RpnHvCA7 = rpnHvCA7;
    }

    public String getRpnHvCA8() {
        return RpnHvCA8;
    }

    public void setRpnHvCA8(String rpnHvCA8) {
        RpnHvCA8 = rpnHvCA8;
    }

    public String getRpnHvCA9() {
        return RpnHvCA9;
    }

    public void setRpnHvCA9(String rpnHvCA9) {
        RpnHvCA9 = rpnHvCA9;
    }

    public String getRpnHvCA10() {
        return RpnHvCA10;
    }

    public void setRpnHvCA10(String rpnHvCA10) {
        RpnHvCA10 = rpnHvCA10;
    }

    public String getRpnHvCA11() {
        return RpnHvCA11;
    }

    public void setRpnHvCA11(String rpnHvCA11) {
        RpnHvCA11 = rpnHvCA11;
    }

    public String getRpnHvCA12() {
        return RpnHvCA12;
    }

    public void setRpnHvCA12(String rpnHvCA12) {
        RpnHvCA12 = rpnHvCA12;
    }

    public String getRpnHvCA13() {
        return RpnHvCA13;
    }

    public void setRpnHvCA13(String rpnHvCA13) {
        RpnHvCA13 = rpnHvCA13;
    }

    public String getRpnHvCA14() {
        return RpnHvCA14;
    }

    public void setRpnHvCA14(String rpnHvCA14) {
        RpnHvCA14 = rpnHvCA14;
    }

    public String getRpnHvCA15() {
        return RpnHvCA15;
    }

    public void setRpnHvCA15(String rpnHvCA15) {
        RpnHvCA15 = rpnHvCA15;
    }

    public String getRpnHvCA16() {
        return RpnHvCA16;
    }

    public void setRpnHvCA16(String rpnHvCA16) {
        RpnHvCA16 = rpnHvCA16;
    }

    public String getRpnHvCA17() {
        return RpnHvCA17;
    }

    public void setRpnHvCA17(String rpnHvCA17) {
        RpnHvCA17 = rpnHvCA17;
    }

    public String getRpnHvCA18() {
        return RpnHvCA18;
    }

    public void setRpnHvCA18(String rpnHvCA18) {
        RpnHvCA18 = rpnHvCA18;
    }

    public String getRpnHvCA19() {
        return RpnHvCA19;
    }

    public void setRpnHvCA19(String rpnHvCA19) {
        RpnHvCA19 = rpnHvCA19;
    }

    public String getRpnHvCA20() {
        return RpnHvCA20;
    }

    public void setRpnHvCA20(String rpnHvCA20) {
        RpnHvCA20 = rpnHvCA20;
    }

    public String getRpnHvCA21() {
        return RpnHvCA21;
    }

    public void setRpnHvCA21(String rpnHvCA21) {
        RpnHvCA21 = rpnHvCA21;
    }

    public String getRpnHvCA22() {
        return RpnHvCA22;
    }

    public void setRpnHvCA22(String rpnHvCA22) {
        RpnHvCA22 = rpnHvCA22;
    }

    public String getRpnHvCA23() {
        return RpnHvCA23;
    }

    public void setRpnHvCA23(String rpnHvCA23) {
        RpnHvCA23 = rpnHvCA23;
    }

    public String getRpnHvCA24() {
        return RpnHvCA24;
    }

    public void setRpnHvCA24(String rpnHvCA24) {
        RpnHvCA24 = rpnHvCA24;
    }

    public String getRpnHvCA25() {
        return RpnHvCA25;
    }

    public void setRpnHvCA25(String rpnHvCA25) {
        RpnHvCA25 = rpnHvCA25;
    }

    public String getWindingConnectionDiagramLv() {
        return WindingConnectionDiagramLv;
    }

    public void setWindingConnectionDiagramLv(String windingConnectionDiagramLv) {
        WindingConnectionDiagramLv = windingConnectionDiagramLv;
    }

    public String getRpnLvAn() {
        return RpnLvAn;
    }

    public void setRpnLvAn(String rpnLvAn) {
        RpnLvAn = rpnLvAn;
    }

    public String getRpnLvBn() {
        return RpnLvBn;
    }

    public void setRpnLvBn(String rpnLvBn) {
        RpnLvBn = rpnLvBn;
    }

    public String getRpnLvCn() {
        return RpnLvCn;
    }

    public void setRpnLvCn(String rpnLvCn) {
        RpnLvCn = rpnLvCn;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

}
