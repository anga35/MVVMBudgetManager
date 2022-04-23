package com.example.basicbudgetmanager;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.basicbudgetmanager.models.Expense;
import com.example.basicbudgetmanager.models.Income;
import com.example.basicbudgetmanager.room.BudgetRepository;

import java.util.List;

public class BudgetViewModel extends AndroidViewModel {
    private BudgetRepository budgetRepository;
    private LiveData<List<Income>> incomeList;
    private LiveData<List<Expense>> expenseList;


   public BudgetViewModel(Application application){
        super(application);
        budgetRepository=new BudgetRepository(application);
        incomeList=budgetRepository.getIncomeList();
        expenseList=budgetRepository.getExpenseList();


    }

    void insertIncome(Income income){
        budgetRepository.insertIncome(income);
    }
    void insertExpense(Expense expense){
        budgetRepository.insertExpense(expense);
    }
public LiveData<List<Income>> getIncomeList(){
 return incomeList;
}

public LiveData<List<Expense>> getExpenseList(){

        return expenseList;

}


}
