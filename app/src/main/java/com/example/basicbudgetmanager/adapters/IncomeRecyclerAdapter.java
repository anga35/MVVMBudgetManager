package com.example.basicbudgetmanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbudgetmanager.R;
import com.example.basicbudgetmanager.models.Income;

import java.util.List;

public class IncomeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Income> incomeList;
    private Context context;
    public IncomeRecyclerAdapter(Context context, List<Income> incomeList){

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

        if(holder instanceof IncomeViewHolder){

           TextView tv_incomeAmount=holder.itemView.findViewById(R.id.item_incomeAmount);
           TextView tv_incomeSource=holder.itemView.findViewById(R.id.item_incomeSource);
           TextView tv_incomeDate=holder.itemView.findViewById(R.id.item_incomeDate);

            tv_incomeAmount.setText(incomeList.get(position).amount.toString());
            tv_incomeSource.setText(incomeList.get(position).source);
            tv_incomeDate.setText(incomeList.get(position).date);

        }


    }

    @Override
    public int getItemCount() {
        return incomeList.size();
    }

    class IncomeViewHolder extends RecyclerView.ViewHolder{

        public IncomeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
