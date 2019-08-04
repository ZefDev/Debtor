package com.mandriklab.Debtor.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mandriklab.Debtor.Model.DebtorsModel;
import com.mandriklab.Debtor.Model.Entity.Debtors;
import com.mandriklab.Debtor.Model.Entity.Operation;
import com.mandriklab.Debtor.Model.OperationModel;
import com.mandriklab.Debtor.Presenter.AddOperationPresenter;
import com.mandriklab.Debtor.Presenter.MainPresenter;
import com.mandriklab.Debtor.R;

import java.util.ArrayList;

public class AddOperationActivity extends AppCompatActivity {

    AddOperationPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_debitor);
        Toolbar tn = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(tn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        DebtorsModel debtorsModel = new DebtorsModel(this);
        OperationModel operationModel = new OperationModel(this);
        presenter = new AddOperationPresenter(operationModel,debtorsModel);
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    public void showListDebitor(ArrayList<Debtors> list){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
