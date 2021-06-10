package com.example.protokols.data_base_package.FreeForm;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class FreeForm {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @ColumnInfo(name = "idForDB")
    public int idForDB;

    @ColumnInfo(name = "Object")
    public String mObjectOrPodstancia;

    @ColumnInfo(name = "Work")
    public String mWork;

    @ColumnInfo(name = "Date")
    public String mDate;

    @ColumnInfo(name = "Notes")
    public String Notes;

    public FreeForm() {
    }

    public FreeForm(int id,int idForDB, String mObjectOrPodstancia, String mWork, String mDate, String notes) {
        this.id = id;
        this.idForDB = idForDB;
        this.mObjectOrPodstancia = mObjectOrPodstancia;
        this.mWork = mWork;
        this.mDate = mDate;
        Notes = notes;
    }

    @Ignore
    public FreeForm(int idForDB, String mObjectOrPodstancia, String mWork, String mDate, String notes) {
        this.idForDB = idForDB;
        this.mObjectOrPodstancia = mObjectOrPodstancia;
        this.mWork = mWork;
        this.mDate = mDate;
        Notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdForDB() {
        return idForDB;
    }

    public void setIdForDB(int idForDB) {
        this.idForDB = idForDB;
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

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
