package com.example.protokols.data_base_package.SilovoyTransformator;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SilovoyTransDao {
    @Query("SELECT * FROM SilovoyTrans")
    List<SilovoyTrans> getAll();

    @Query("SELECT * FROM SilovoyTrans WHERE id = :id")
    SilovoyTrans getSilovoyTransTableById(int id);

    @Query("DELETE FROM SilovoyTrans WHERE id = :id")
    int deleteSilovoyTransbyID(int id);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSilovoyTransList(List<SilovoyTrans> silovoyTransList);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertSilovoyTrans(SilovoyTrans silovoyTrans);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateSilovoyTransList (List<SilovoyTrans> silovoyTransList);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateSilovoyTrans (SilovoyTrans silovoyTransList);

    @Delete
    void deleteSilovoyTransList(List<SilovoyTrans> silovoyTransList);

    @Delete
    void deleteSilovoyTrans(SilovoyTrans silovoyTrans);
}
