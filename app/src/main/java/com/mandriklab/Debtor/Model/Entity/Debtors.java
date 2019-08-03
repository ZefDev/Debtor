package com.mandriklab.Debtor.Model.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
@Entity
public class Debtors {
    @PrimaryKey(autoGenerate = true)
    private int idDebtor;

    @ColumnInfo(name = "fullName")
    private String fullName;

    @ColumnInfo(name = "number")
    private String number;

    @ColumnInfo(name = "address")
    private String address;

    public int getIdDebtor() {
        return idDebtor;
    }

    public void setIdDebtor(int idDebtor) {
        this.idDebtor = idDebtor;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

