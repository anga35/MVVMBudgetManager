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
BudgetRoomDatabase db;
    public BudgetRepository(Application application){
        this.db=BudgetRoomDatabase.getDatabase(application);
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
        db.databaseWriteExecutor.execute(()->{

            budgetDao.insertIncome(income);


        });

    }
    public void insertExpense(Expense expense){

        db.databaseWriteExecutor.execute(()->{


            budgetDao.insertExpense(expense);

        });


    }



}
