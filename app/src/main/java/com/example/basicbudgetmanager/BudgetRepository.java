package com.example.basicbudgetmanager;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.basicbudgetmanager.models.Expense;
import com.example.basicbudgetmanager.models.Income;

import java.util.List;

public class BudgetRepository{
    private BudgetDAO budgetDao;
    LiveData<List<Income>> incomeList;
    LiveData<List<Expense>> expenseList;

    BudgetRepository(Application application){
        BudgetRoomDatabase db=BudgetRoomDatabase.getDatabase(application);
        budgetDao=db.budgetDAO();
        incomeList=budgetDao.getIncomes();
        expenseList=budgetDao.getExpense();


    }

    LiveData<List<Income>> getIncomeList(){
        return incomeList;

    }

    LiveData<List<Expense>> getExpenseList(){
        return expenseList;

    }


    void insertIncome(Income income){
        budgetDao.insertIncome(income);
    }
    void insertExpense(Expense expense){
        budgetDao.insertExpense(expense);

    }



}
