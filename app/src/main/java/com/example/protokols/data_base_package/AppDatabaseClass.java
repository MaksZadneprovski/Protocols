package com.example.protokols.data_base_package;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTransDao;


@Database(entities = {SilovoyTrans.class}, version = 1)
public abstract class AppDatabaseClass extends RoomDatabase {
    public abstract SilovoyTransDao getSilovoyTransTableDao();
}
