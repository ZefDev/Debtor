package com.mandriklab.Debtor.Model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.mandriklab.Debtor.Model.Entity.Debtors;
import com.mandriklab.Debtor.Model.Entity.Operation;

import java.util.List;

public class OperationWithDebtors {
    @Embedded
    public Operation operation;

    @Relation(parentColumn = "id", entityColumn = "idDebtorOperation")
    public Debtors debtors;
}
