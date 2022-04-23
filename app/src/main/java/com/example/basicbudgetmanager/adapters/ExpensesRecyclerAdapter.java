package com.example.basicbudgetmanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbudgetmanager.R;
import com.example.basicbudgetmanager.models.Expense;

import java.util.List;

public class ExpensesRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
Context context;
List<Expense> expenseList;


public ExpensesRecyclerAdapter(Context context, List<Expense> expenseList){

   this.context=context;
   this.expenseList=expenseList;


}




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExpensesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_expense,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


    if(holder instanceof ExpensesViewHolder){

        TextView tv_expenseAmount=holder.itemView.findViewById(R.id.item_expenseAmount);
        TextView tv_expenseSource=holder.itemView.findViewById(R.id.item_expenseSource);
        TextView tv_expenseDate=holder.itemView.findViewById(R.id.item_expenseDate);

        tv_expenseAmount.setText(expenseList.get(position).getAmount().toString());
        tv_expenseDate.setText(expenseList.get(position).getDate());
        tv_expenseSource.setText(expenseList.get(position).getSource());

    }



    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }


    class ExpensesViewHolder extends RecyclerView.ViewHolder{


        public ExpensesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
