package com.example.basicbudgetmanager.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "income_table")
public class Income {

@PrimaryKey(autoGenerate = true)
public int id;

@NonNull
public String source;

public Integer amount;

@NonNull
public String date;


public Income(@NonNull String source, @NonNull Integer amount,@NonNull String date){
    this.source=source;
    this.amount=amount;
    this.date=date;
}


public String getSource(){
    return this.source;
}

    public Integer getAmount(){

    return this.amount;
}

    public String getDate(){

        return this.date;
    }



    public void setSource( String source){

    this.source=source;
}

    public void setAmount( Integer amount){
    this.amount=amount;

}




}
