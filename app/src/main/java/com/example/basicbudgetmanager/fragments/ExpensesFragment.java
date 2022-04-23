package com.example.basicbudgetmanager.fragments;

import android.content.Context;
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
import com.example.basicbudgetmanager.models.Expense;

import java.util.List;

public class ExpensesFragment extends Fragment {
Context mContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    mContext=context;
    }

    public ExpensesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expenses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv_expense=view.findViewById(R.id.tv_expense);
        BudgetViewModel budgetViewModel= new ViewModelProvider(this).get(BudgetViewModel.class);
        budgetViewModel.getExpenseList().observe((LifecycleOwner) mContext, new Observer<List<Expense>>() {
            @Override
            public void onChanged(List<Expense> expenses) {

                tv_expense.setText(expenses.get(0).getSource());
            }
        });

    }
}