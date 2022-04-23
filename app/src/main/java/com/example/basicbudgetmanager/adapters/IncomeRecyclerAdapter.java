package com.example.basicbudgetmanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbudgetmanager.R;
import com.example.basicbudgetmanager.models.Income;

import java.util.List;

public class IncomeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Income> incomeList;
    private Context context;
    IncomeRecyclerAdapter(Context context,List<Income> incomeList){

        this.context=context;
        this.incomeList=incomeList;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IncomeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_income,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class IncomeViewHolder extends RecyclerView.ViewHolder{

        public IncomeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
