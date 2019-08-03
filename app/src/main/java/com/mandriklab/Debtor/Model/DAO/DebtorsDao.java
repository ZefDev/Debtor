package com.mandriklab.Debtor.Model.DAO;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.mandriklab.Debtor.Model.Entity.Debtors;
import java.util.List;

@Dao
public interface DebtorsDao {
    @Query("SELECT * FROM Debtors")
    List<Debtors> getAll();

    @Query("SELECT * FROM Debtors WHERE idDebtor =:id")
    Debtors getById(int id);

    @Query("SELECT * FROM Debtors WHERE idDebtor IN (:userIds)")
    List<Debtors> loadAllByIds(int[] userIds);

    @Update
    public void updateSite(Debtors... debtors);

    @Insert
    long[] insertAll(Debtors... debtors);

    @Delete
    void delete(Debtors debtors);
}