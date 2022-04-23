package com.example.basicbudgetmanager.models;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "expense_table")
public class Expense {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    String source;

    int amount;


    public Expense(@NonNull String source, @NonNull int amount){
        this.source=source;
        this.amount=amount;

    }


   public String getSource(){
        return this.source;
    }

   public int getAmount(){

        return this.amount;
    }


    public void setSource( String source){

        this.source=source;
    }

    public  void setAmount( int amount){
        this.amount=amount;

    }

}
