package com.example.protokols.data_base_package.FreeForm;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

@Dao
public interface FreeFormDao {
    @Query("SELECT * FROM FreeForm")
    List<FreeForm> getAll();

    @Query("SELECT * FROM FreeForm WHERE id = :id")
    FreeForm getFreeFormById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFreeFormList(List<FreeForm> freeFormList);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertFreeForm(FreeForm freeForm);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateFreeFormList (List<FreeForm> freeFormList);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateFreeForm (FreeForm freeFormList);

    @Delete
    void deleteFreeFormList(List<FreeForm> freeFormList);

    @Delete
    void deleteFreeForm(FreeForm freeForm);
}
