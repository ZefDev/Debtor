package com.mandriklab.debtor;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    ArrayList<Persons> personsList;
    private static ClickListener clickListener;

    public RecycleViewAdapter(Context context,ArrayList<Persons> list) {
        this.context = context;
        this.personsList = list;
    }

    @Override
    public int getItemCount() {
        return personsList.size();
    }

    @Override
    public void onClick(final View v) {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Persons person = (Persons) personsList.get(position);
        holder.tvNamePerson.setText(person.getNamePerson());
        holder.tvDate.setText(person.getDate());
        holder.tvDay.setText(person.getDay() + " дн.");
        holder.tvCoast.setText(String.valueOf(person.getCoast()));

        if (person.getImgIndikator()==1){
            holder.imgIndikator.setImageResource(R.drawable.left_pointing_arrow);
        }
        else {
            holder.imgIndikator.setImageResource(R.drawable.red_arrow);
        }
    }


    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout container;
        public AppCompatTextView tvNamePerson,tvDate,tvDay,tvCoast;
        public ImageView imgIndikator,imagePerson;
        public ViewHolder(View itemView) {
            super(itemView);
            container = (RelativeLayout) itemView.findViewById(R.id.containerr);
            imgIndikator = itemView.findViewById(R.id.imgIndikator);
            imagePerson = itemView.findViewById(R.id.imagePerson);
            tvNamePerson = itemView.findViewById(R.id.tvNamePerson);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvDay = itemView.findViewById(R.id.tvDay);
            tvCoast = itemView.findViewById(R.id.tvCoast);

        }
    }
    public void setOnItemClickListener(ClickListener clickListener) {
        RecycleViewAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }
}