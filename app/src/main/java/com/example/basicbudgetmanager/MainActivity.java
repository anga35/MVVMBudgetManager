package com.example.basicbudgetmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.basicbudgetmanager.adapters.PagerFragmentAdapter;
import com.example.basicbudgetmanager.models.Expense;
import com.example.basicbudgetmanager.models.Income;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private BudgetViewModel budgetViewModel;
public List<Income> incomeList;
public List<Expense> expenseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        budgetViewModel= new ViewModelProvider(this).get(BudgetViewModel.class);
//        budgetViewModel.getExpenseList().observe(this, new Observer<List<Expense>>() {
//            @Override
//            public void onChanged(List<Expense> expenses) {
//                expenseList=expenses;
//
//            }
//        });
//
//        budgetViewModel.getIncomeList().observe(this, new Observer<List<Income>>() {
//            @Override
//            public void onChanged(List<Income> incomes) {
//                incomeList=incomes;
//            }
//        });


        ViewPager2 vp_main = findViewById(R.id.vp_main);

        vp_main.setAdapter(new PagerFragmentAdapter(getSupportFragmentManager(), getLifecycle()));
        vp_main.setUserInputEnabled(false);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_menu:
                        vp_main.setCurrentItem(0);

                        return true;
                    case R.id.income_menu:
                        vp_main.setCurrentItem(1);

                        return true;
                    case R.id.expenses_menu:
                        vp_main.setCurrentItem(2);

                        return true;
                }
                return false;
            }
        });





    }
}