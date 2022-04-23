package com.example.basicbudgetmanager.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basicbudgetmanager.BudgetViewModel;
import com.example.basicbudgetmanager.R;
import com.example.basicbudgetmanager.activities.AddTransactionActivity;
import com.example.basicbudgetmanager.models.Expense;
import com.example.basicbudgetmanager.models.Income;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class HomeFragment extends Fragment {
    Context mContext;
    Integer incomeSum = 0;
    Integer expenseSum = 0;
 TextView tv_totalFunds;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv_totalIncome = view.findViewById(R.id.tv_total_income);
        TextView tv_totalExpense = view.findViewById(R.id.tv_total_expenses);
      tv_totalFunds = view.findViewById(R.id.tv_funds_left);

        BudgetViewModel budgetViewModel = new ViewModelProvider(requireActivity()).get(BudgetViewModel.class);
        budgetViewModel.getIncomeList().observe((LifecycleOwner) mContext, new Observer<List<Income>>() {
            @Override
            public void onChanged(List<Income> incomeList) {

                if (!incomeList.isEmpty()) {
                    for (Income income : incomeList) {
                        incomeSum = incomeSum + income.amount;
                    }
                    tv_totalIncome.setText("$"+incomeSum.toString());

                }
                else {

                    tv_totalIncome.setText("$0");
                }
                getFundsLeft();

            }
        });

        budgetViewModel.getExpenseList().observe((LifecycleOwner) mContext, new Observer<List<Expense>>() {
            @Override
            public void onChanged(List<Expense> expenseList) {

                if(!expenseList.isEmpty()){
                    for (Expense expense : expenseList) {

                        expenseSum = expenseSum + expense.getAmount();


                    }
                    tv_totalExpense.setText("$"+expenseSum.toString());

                }
                else{
                    tv_totalExpense.setText("$0");
                }
                getFundsLeft();

            }
        });


        FloatingActionButton fabAddTransaction = view.findViewById(R.id.fab_add_transaction);
        fabAddTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddTransactionActivity.class);
                startActivity(intent);

            }
        });

    }


    void getFundsLeft(){
        Integer fundsLeft=incomeSum-expenseSum;
        tv_totalFunds.setText("$"+fundsLeft.toString());

    }

}