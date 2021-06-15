package com.example.protokols;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.protokols.data_base_package.AppDelegateBd;
import com.example.protokols.data_base_package.FreeForm.FreeForm;
import com.example.protokols.data_base_package.FreeForm.FreeFormDao;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTransDao;

import java.util.List;

public class ClassForViewingListProtocols extends AppCompatActivity {
    private int id;
    private String work, object, date;
    private Toolbar toolbarMain;


    public ClassForViewingListProtocols(int id, String work, String object, String date) {
        this.id = id;
        this.work = work;
        this.object = object;
        this.date = date;
    }



    public String getWork() {
        return work;
    }

    public String getObject() {
        return object;
    }

    public String getDate() {
        return date;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
