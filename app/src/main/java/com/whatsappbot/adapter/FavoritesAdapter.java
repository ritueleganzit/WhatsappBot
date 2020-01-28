package com.whatsappbot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.whatsappbot.R;
import com.whatsappbot.model.Contacts;

import java.util.ArrayList;


public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.MyViewHolder>
{
    Context context;
    ArrayList<Contacts> arrayList;
    ArrayList<Contacts> selectedarray=new ArrayList<>();

    public FavoritesAdapter(ArrayList<Contacts> arrayList, Context context) {
        this.context = context;
        this.arrayList= arrayList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_fav,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Contacts contacts=arrayList.get(position);
        holder.name.setText(contacts.getName());
        holder.number.setText(contacts.getNumber());


holder.checkBox.setTag(position);
holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
contacts.setSelected(true);
                }
                else
                {
                    contacts.setSelected(false);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

TextView name, number;
CheckBox checkBox;
        public MyViewHolder(View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            checkBox=itemView.findViewById(R.id.checkbox);
            number=itemView.findViewById(R.id.number);

        }
    }
}
