package com.example.basicbudgetmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.basicbudgetmanager.R;
import com.example.basicbudgetmanager.adapters.TransactionTypeSpinnerAdapter;
import com.example.basicbudgetmanager.models.Income;
import com.example.basicbudgetmanager.room.BudgetRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AddTransactionActivity extends AppCompatActivity {
    String transactionType="Income";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        Button btnAddTransaction=findViewById(R.id.btn_addTransaction);
        EditText addSource=findViewById(R.id.et_add_source);
        EditText addAmount=findViewById(R.id.et_add_amount);
List<String> transactionItems=new ArrayList<>();
transactionItems.add("Income");
transactionItems.add("Expense");
Context mContext=this;
        Spinner spinnerTransaction=findViewById(R.id.spinner_transactions);
        TransactionTypeSpinnerAdapter transactionAdapter=new TransactionTypeSpinnerAdapter(this,transactionItems);
        transactionAdapter.setDropDownViewResource(R.layout.item_transaction_type);
        spinnerTransaction.setAdapter(transactionAdapter);
        BudgetRepository budgetRepository= new BudgetRepository(getApplication());

        spinnerTransaction.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

String item = (String)adapterView.getSelectedItem();
switch (item){
    case "Income":
        transactionType =item;
        break;
    case "Expense":
        transactionType=item;
        break;
    default:
        break;
}


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnAddTransaction.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(transactionType=="Income"){
                    String timeNow= new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                    if(addAmount.getText().toString().isEmpty() || addSource.getText().toString().isEmpty()){
                       Toast.makeText(mContext,"Check your input and try again",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        budgetRepository.insertIncome(new Income(addSource.getText().toString(),
                                Integer.parseInt(addAmount.getText().toString()),timeNow));
                    }
                }
                if(transactionType=="Expense"){

                }
            }
        });

    }
}