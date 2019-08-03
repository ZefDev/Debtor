package com.mandriklab.Debtor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends PagerAdapter {
    private List<Models> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Models> models, Context context) {
        this.models = models;
        this.context = context;
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
        arr.add(new Persons(1,1,"","Сергей Должник","19.07.2019","8",11435.49));
        arr.add(new Persons(2,1,"","Юра Должник","19.07.2019","9",1143.49));
        arr.add(new Persons(3,1,"","Женя Должник","19.07.2019","1",11235.49));
        arr.add(new Persons(4,1,"","Антон Должник","19.07.2019","4",9999.49));
        arr.add(new Persons(5,1,"","ЮрГар Должник","19.07.2019","3",11496.49));
        arr.add(new Persons(6,1,"","Сергей Должник","19.07.2019","5",15435.49));

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
