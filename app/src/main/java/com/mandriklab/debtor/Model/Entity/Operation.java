package com.mandriklab.Debtor.Model.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Debtors.class,
        parentColumns = "idDebtor",
        childColumns = "idOperation",
        onDelete = CASCADE))

public class Operation {
    @PrimaryKey(autoGenerate = true)
    private int idOperation;

    @ColumnInfo(name = "idDebtorOperation")
    private int idDebtorOperation;

    @ColumnInfo(name = "typeOperation")
    private int typeOperation;  // 0 - i debt, 1 - me debt

    @ColumnInfo(name = "summa")
    private Double summa;

    @ColumnInfo(name = "dateOperation")
    private long dateOperation;

    @ColumnInfo(name = "lastDate")
    private long lastDate;

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public int getIdDebtorOperation() {
        return idDebtorOperation;
    }

    public void setIdDebtorOperation(int idDebtorOperation) {
        this.idDebtorOperation = idDebtorOperation;
    }

    public Double getSumma() {
        return summa;
    }

    public void setSumma(Double summa) {
        this.summa = summa;
    }

    public long getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(long dateOperation) {
        this.dateOperation = dateOperation;
    }

    public long getLastDate() {
        return lastDate;
    }

    public void setLastDate(long lastDate) {
        this.lastDate = lastDate;
    }

    public int getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(int typeOperation) {
        this.typeOperation = typeOperation;
    }



}
