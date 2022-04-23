package com.example.basicbudgetmanager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.basicbudgetmanager.models.Expense;
import com.example.basicbudgetmanager.models.Income;

import java.util.List;

@Dao
public interface BudgetDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertIncome(Income income);

    @Query("SELECT * from income_table ORDER BY id ASC")
    LiveData<List<Income>> getIncomes();

    @Delete
    void deleteIncome(Income income);

    @Delete
    void deleteExpense(Expense expense);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertExpense(Expense expense);

    @Query("SELECT * FROM expense_table ORDER BY id DESC")
    LiveData<List<Expense>> getExpense();


    @Query("DELETE FROM expense_table")
    void deleteAllExpense();


    @Query("DELETE FROM income_table")
    void deleteAllIncome();

}
