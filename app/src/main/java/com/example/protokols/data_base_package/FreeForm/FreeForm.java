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

    @ColumnInfo(name = "Object")
    public String mObjectOrPodstancia;

    @ColumnInfo(name = "Work")
    public String mWork;

    @ColumnInfo(name = "Date")
    public long mDate;

    @ColumnInfo(name = "Notes")
    public String Notes;

    public FreeForm() {
    }

    public FreeForm(int id, String mObjectOrPodstancia, String mWork, long mDate, String notes) {
        this.id = id;
        this.mObjectOrPodstancia = mObjectOrPodstancia;
        this.mWork = mWork;
        this.mDate = mDate;
        Notes = notes;
    }

    @Ignore
    public FreeForm( String mObjectOrPodstancia, String mWork, long mDate, String notes) {
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

    public long getmDate() {
        return mDate;
    }

    public void setmDate(long mDate) {
        this.mDate = mDate;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
