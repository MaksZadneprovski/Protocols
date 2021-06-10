package com.example.protokols.data_base_package;

import android.app.Application;

import androidx.room.Room;

public class AppDelegateBd extends Application {

    private AppDatabaseClass appDatabaseClass;
    @Override
    public void onCreate() {
        super.onCreate();

        appDatabaseClass = Room.databaseBuilder(getApplicationContext(), AppDatabaseClass.class, "protokols_db8")
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabaseClass getAppDatabaseClass() {
        return appDatabaseClass;
    }

}
