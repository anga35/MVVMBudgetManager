package com.example.basicbudgetmanager.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.basicbudgetmanager.fragments.ExpensesFragment;
import com.example.basicbudgetmanager.fragments.HomeFragment;
import com.example.basicbudgetmanager.fragments.IncomeFragment;

public class PagerFragmentAdapter extends FragmentStateAdapter {

    public PagerFragmentAdapter(FragmentManager fragmentManager, Lifecycle lifecycle){

        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();

            case 1:
                return new IncomeFragment();

            case 2:
                return new ExpensesFragment();


            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }


    @Override
    public int getItemCount() {
        return 3;
    }
}
