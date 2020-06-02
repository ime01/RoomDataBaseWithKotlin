package com.flowz.roomdatabasewithkotlin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Emp_DAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEmp (emp: Emp_Entity)

    @Query("select*from Emp_Entity")
    fun readEmp(): List<Emp_Entity>

}