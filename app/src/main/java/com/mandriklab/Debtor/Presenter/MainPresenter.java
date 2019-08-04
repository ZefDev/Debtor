package com.mandriklab.Debtor.Presenter;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.mandriklab.Debtor.Model.Entity.Operation;
import com.mandriklab.Debtor.Model.OperationModel;
import com.mandriklab.Debtor.Model.OperationWithDebtors;
import com.mandriklab.Debtor.View.MainActivity;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class MainPresenter {
    private MainActivity view;
    private OperationModel operationModel;
    ArrayList<Operation> listOperation;
    private SharedPreferences sPref;


    public MainPresenter(OperationModel model){
        this.operationModel = model;
       // this.listOperation = listOperation;
    }

    public void attachView(MainActivity mainActivity) {
        view = mainActivity;
    }

    public void detachView() {
        view = null;
    }

    public void viewIsReady() {
        listOperation = new ArrayList<>();
        loadOperation();
    }

    public void loadOperation() {
        //view.showProgressBar();
        //loadSitesIsShow();
        operationModel.loadOperation(new OperationModel.LoadOperationCallback() {

            @Override
            public void onLoad(List<OperationWithDebtors> operations) {
                view.showList(operations);
            }
        });
    }

    public void updateOperation(Operation operation) {
        operationModel.updateOperation(operation,new OperationModel.CompleteCallback() {
            @Override
            public void onComplete() {

            }
        });
    }
}
