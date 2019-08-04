package com.mandriklab.Debtor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mandriklab.Debtor.Model.Entity.Debtors;
import com.mandriklab.Debtor.Model.Entity.Operation;
import com.mandriklab.Debtor.Model.OperationWithDebtors;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PagerAdapters extends PagerAdapter {
    private List<ModelCard> models;
    private LayoutInflater layoutInflater;
    private Context context;
    private List<OperationWithDebtors> listOperation;

    public PagerAdapters(List<ModelCard> models, Context context, List<OperationWithDebtors> listOperation) {
        this.models = models;
        this.context = context;
        this.listOperation = listOperation;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = layoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item,container,false);

        RecyclerView listView;

        listView = view.findViewById(R.id.dynamic);
        ArrayList<Persons> arr = new ArrayList<>();
        //Распределение всех долгов
        for (int i=0;i<listOperation.size();i++){
            Debtors deb =  listOperation.get(i).debtors.get(0);
            Operation operation = listOperation.get(i).operation;

            int imgIndikator = 0;

            long day = (operation.getLastDate() - System.currentTimeMillis())/86400000;

            String date = new SimpleDateFormat("dd.MM.yyyy").format(operation.getLastDate());
            if (operation.getSumma()>0){
                imgIndikator = 1;
            }
            //operation.getLastDate();
            if (position==0 && operation.getSumma()>0) {
                arr.add(new Persons(deb.getIdDebtor(),
                                imgIndikator,
                                "",
                                deb.getFullName(),
                                date,
                                day + "",
                                operation.getSumma()
                        )
                );
            }
            else if(position==1 && operation.getSumma()<0)  {
                arr.add(new Persons(deb.getIdDebtor(),
                                imgIndikator,
                                "",
                                deb.getFullName(),
                                date,
                                day + "",
                                operation.getSumma()
                        )
                );
            }
        }
        // сдесь тип загрузиться адаптер
        listView.setAdapter(null);
        listView.setLayoutManager(new GridLayoutManager(context, 1));
        RecycleViewAdapter adapter = new RecycleViewAdapter(context,arr);
        listView.setAdapter(adapter);
        container.addView(view,0);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
