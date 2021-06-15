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

    public SilovoyTrans(int id,  String mObjectOrPodstancia, String mWork, String mDate, String mTemperature, String pasportType, String pasportZavNumber,
                        String pasportPower, String pasportVoltage, String pasportCurrent, String pasportVoltageKz, String pasportYearOfManufacture,
                        String izolHvR15, String izolHvR60, String izolHvKoef, String izolLvR15, String izolLvR60, String izolLvKoef, String switchOperationPosition,
                        String rpnHvAB1, String rpnHvAB2, String rpnHvAB3, String rpnHvAB4, String rpnHvAB5, String rpnHvAB6, String rpnHvBC1, String rpnHvBC2,
                        String rpnHvBC3, String rpnHvBC4, String rpnHvBC5, String rpnHvBC6, String rpnHvCA1, String rpnHvCA2, String rpnHvCA3, String rpnHvCA4,
                        String rpnHvCA5, String rpnHvCA6, String rpnLvAn, String rpnLvBn, String rpnLvCn, String notes) {
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
        SwitchOperationPosition = switchOperationPosition;
        RpnHvAB1 = rpnHvAB1;
        RpnHvAB2 = rpnHvAB2;
        RpnHvAB3 = rpnHvAB3;
        RpnHvAB4 = rpnHvAB4;
        RpnHvAB5 = rpnHvAB5;
        RpnHvAB6 = rpnHvAB6;
        RpnHvBC1 = rpnHvBC1;
        RpnHvBC2 = rpnHvBC2;
        RpnHvBC3 = rpnHvBC3;
        RpnHvBC4 = rpnHvBC4;
        RpnHvBC5 = rpnHvBC5;
        RpnHvBC6 = rpnHvBC6;
        RpnHvCA1 = rpnHvCA1;
        RpnHvCA2 = rpnHvCA2;
        RpnHvCA3 = rpnHvCA3;
        RpnHvCA4 = rpnHvCA4;
        RpnHvCA5 = rpnHvCA5;
        RpnHvCA6 = rpnHvCA6;
        RpnLvAn = rpnLvAn;
        RpnLvBn = rpnLvBn;
        RpnLvCn = rpnLvCn;
        Notes = notes;
    }

    @Ignore
    public SilovoyTrans( String mObjectOrPodstancia, String mWork, String mDate, String mTemperature, String pasportType, String pasportZavNumber,
                        String pasportPower, String pasportVoltage, String pasportCurrent, String pasportVoltageKz, String pasportYearOfManufacture,
                        String izolHvR15, String izolHvR60, String izolHvKoef, String izolLvR15, String izolLvR60, String izolLvKoef, String switchOperationPosition,
                        String rpnHvAB1, String rpnHvAB2, String rpnHvAB3, String rpnHvAB4, String rpnHvAB5, String rpnHvAB6, String rpnHvBC1, String rpnHvBC2,
                        String rpnHvBC3, String rpnHvBC4, String rpnHvBC5, String rpnHvBC6, String rpnHvCA1, String rpnHvCA2, String rpnHvCA3, String rpnHvCA4,
                        String rpnHvCA5, String rpnHvCA6, String rpnLvAn, String rpnLvBn, String rpnLvCn, String notes) {
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
        SwitchOperationPosition = switchOperationPosition;
        RpnHvAB1 = rpnHvAB1;
        RpnHvAB2 = rpnHvAB2;
        RpnHvAB3 = rpnHvAB3;
        RpnHvAB4 = rpnHvAB4;
        RpnHvAB5 = rpnHvAB5;
        RpnHvAB6 = rpnHvAB6;
        RpnHvBC1 = rpnHvBC1;
        RpnHvBC2 = rpnHvBC2;
        RpnHvBC3 = rpnHvBC3;
        RpnHvBC4 = rpnHvBC4;
        RpnHvBC5 = rpnHvBC5;
        RpnHvBC6 = rpnHvBC6;
        RpnHvCA1 = rpnHvCA1;
        RpnHvCA2 = rpnHvCA2;
        RpnHvCA3 = rpnHvCA3;
        RpnHvCA4 = rpnHvCA4;
        RpnHvCA5 = rpnHvCA5;
        RpnHvCA6 = rpnHvCA6;
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

    public String getmObjectOrPodstancia() {
        return mObjectOrPodstancia;
    }

    public void setmObjectOrPodstancia(String mObjectOrPodstancia) {
        this.mObjectOrPodstancia = mObjectOrPodstancia;
    }

    public String getmWork() {
        return mWork;
    }

    public void setmWork(String mWork) {
        this.mWork = mWork;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmTemperature() {
        return mTemperature;
    }

    public void setmTemperature(String mTemperature) {
        this.mTemperature = mTemperature;
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
