package com.example.basicbudgetmanager.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.basicbudgetmanager.models.Expense;
import com.example.basicbudgetmanager.models.Income;

import java.util.List;

public class BudgetRepository{
    private BudgetDAO budgetDao;
    LiveData<List<Income>> incomeList;
    LiveData<List<Expense>> expenseList;

    public BudgetRepository(Application application){
        BudgetRoomDatabase db=BudgetRoomDatabase.getDatabase(application);
        budgetDao=db.budgetDAO();
        incomeList=budgetDao.getIncomes();
        expenseList=budgetDao.getExpense();


    }

    public LiveData<List<Income>> getIncomeList(){
        return incomeList;

    }

    public LiveData<List<Expense>> getExpenseList(){
        return expenseList;

    }


    public void insertIncome(Income income){
        budgetDao.insertIncome(income);
    }
    public void insertExpense(Expense expense){
        budgetDao.insertExpense(expense);

    }



}
