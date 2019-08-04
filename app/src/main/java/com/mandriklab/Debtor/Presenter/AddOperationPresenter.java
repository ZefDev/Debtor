package com.mandriklab.Debtor.Presenter;

import android.content.SharedPreferences;

import com.mandriklab.Debtor.Model.DebtorsModel;
import com.mandriklab.Debtor.Model.Entity.Debtors;
import com.mandriklab.Debtor.Model.Entity.Operation;
import com.mandriklab.Debtor.Model.OperationModel;
import com.mandriklab.Debtor.View.AddOperationActivity;

import java.util.ArrayList;
import java.util.List;

public class AddOperationPresenter {
    private AddOperationActivity view;
    private OperationModel operationModel;
    private DebtorsModel debtorsModel;
    private SharedPreferences sPref;


    public AddOperationPresenter(OperationModel model,DebtorsModel debtorsModel){
        this.operationModel = model;
        this.debtorsModel = debtorsModel;
        // this.listOperation = listOperation;
    }

    public void attachView(AddOperationActivity activity) {
        view = activity;
    }

    public void detachView() {
        view = null;
    }

    public void viewIsReady() {
        //listOperation = new ArrayList<>();
        //loadOperation();
    }

    public void loadListDebitor(){
        debtorsModel.loadDebtors(new DebtorsModel.LoadDebtorsCallback(){
            @Override
            public void onLoad(List<Debtors> debtors) {
                ArrayList<Debtors> list = new ArrayList<>();
                for (int i=0;i<debtors.size();i++){
                    list.add(debtors.get(i));
                }
                view.showListDebitor(list);
            }
        });
    }

    public void addOperation(Operation operation) {
      /*  operationModel.addOperation(operation,new OperationModel.CompleteCallback() {

            @Override
            public void onComplete() {

            }
        });*/
    }
}
