package com.example.mini_mart_android.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mini_mart_android.Fragment.AccountFragment;
import com.example.mini_mart_android.Fragment.CartFragment;
import com.example.mini_mart_android.Fragment.NotificationFragment;
import com.example.mini_mart_android.Fragment.ProductFragment;
import com.example.mini_mart_android.Fragment.PromotionFragment;

public class MainAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 5;

    public MainAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ProductFragment();
            case 1:
                return new PromotionFragment();
            case 2:
                return new CartFragment();
            case 3:
                return new NotificationFragment();
            case 4:
                return new AccountFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}