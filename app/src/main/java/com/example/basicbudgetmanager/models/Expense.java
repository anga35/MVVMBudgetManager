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

    @NonNull
    String date;


    public Expense(@NonNull String source, @NonNull int amount,@NonNull String date){
        this.source=source;
        this.amount=amount;
        this.date=date;
    }


   public String getSource(){
        return this.source;
    }

   public int getAmount(){

        return this.amount;
    }

    public String getDate(){

        return this.date;
    }


    public void setSource( String source){

        this.source=source;
    }

    public  void setAmount( int amount){
        this.amount=amount;

    }

}
