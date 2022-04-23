package com.example.basicbudgetmanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.basicbudgetmanager.R;

import java.util.List;

public class TransactionTypeSpinnerAdapter extends ArrayAdapter<String> {
    Context context;
    public TransactionTypeSpinnerAdapter(@NonNull Context context, @NonNull List<String> transactionTypeList) {

        super(context, 0, transactionTypeList);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

View mView=convertView;
        mView= LayoutInflater.from(context).inflate(R.layout.item_transaction_type,parent,false);

String item=getItem(position);

        TextView spinnerTextView=mView.findViewById(R.id.tv_spinnerTransaction);
        spinnerTextView.setText(item);
        return mView;
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View mView=convertView;
        mView= LayoutInflater.from(context).inflate(R.layout.item_transaction_type,parent,false);

        String item=getItem(position);

        TextView spinnerTextView=mView.findViewById(R.id.tv_spinnerTransaction);
        spinnerTextView.setText(item);
        return mView;


    }
}
