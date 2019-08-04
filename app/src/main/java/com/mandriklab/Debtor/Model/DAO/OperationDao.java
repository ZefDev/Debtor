package com.mandriklab.Debtor.Model.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.mandriklab.Debtor.Model.Entity.Operation;
import com.mandriklab.Debtor.Model.OperationWithDebtors;

import java.util.List;

@Dao
public interface OperationDao {
    @Query("SELECT * FROM Operation")
    List<Operation> getAll();

    @Query("SELECT * FROM Operation")
    List<OperationWithDebtors> getOperationWithDebtors();

    @Query("SELECT * FROM Operation WHERE idOperation =:id")
    Operation getById(int id);

    @Query("SELECT * FROM Operation WHERE idOperation IN (:OperationIds)")
    List<Operation> loadAllByIds(int[] OperationIds);

    @Update
    public void updateSite(Operation... operation);

    @Insert
    long[] insertAll(Operation... operation);

    @Delete
    void delete(Operation operation);
}
