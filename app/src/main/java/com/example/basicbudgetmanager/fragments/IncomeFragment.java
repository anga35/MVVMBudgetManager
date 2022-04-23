package com.example.basicbudgetmanager.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basicbudgetmanager.BudgetViewModel;
import com.example.basicbudgetmanager.R;
import com.example.basicbudgetmanager.adapters.IncomeRecyclerAdapter;
import com.example.basicbudgetmanager.models.Expense;
import com.example.basicbudgetmanager.models.Income;

import java.util.List;


public class IncomeFragment extends Fragment {

Context mContext;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    mContext=context;
    }

    public IncomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_income, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv_Income=view.findViewById(R.id.tv_income);
        TextView tv_noIncome=view.findViewById(R.id.tv_no_income);
        RecyclerView rv_Income=view.findViewById(R.id.rv_income);
        rv_Income.setLayoutManager(new LinearLayoutManager(mContext));
        BudgetViewModel budgetViewModel= new ViewModelProvider(requireActivity()).get(BudgetViewModel.class);
        budgetViewModel.getIncomeList().observe((LifecycleOwner) mContext, new Observer<List<Income>>() {
            @Override
            public void onChanged(List<Income> incomes) {
if(!incomes.isEmpty()){

Integer sum=0;
    for (Income income : incomes) {
sum=sum+income.amount;
    }
    tv_Income.setText("$" +sum.toString());

    tv_noIncome.setVisibility(View.GONE);
    rv_Income.setVisibility(View.VISIBLE);


    rv_Income.setAdapter(new IncomeRecyclerAdapter(mContext,incomes));

}

else{
    tv_Income.setText("$0");
    rv_Income.setVisibility(View.GONE);
tv_noIncome.setVisibility(View.VISIBLE);

}


            }
        });


    }
}