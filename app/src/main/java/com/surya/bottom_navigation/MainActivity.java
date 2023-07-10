package com.surya.bottom_navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.surya.bottom_navigation.databinding.ActivityMainBinding;
import com.surya.bottom_navigation.fragments.fragment_home;
import com.surya.bottom_navigation.fragments.fragment_library;
import com.surya.bottom_navigation.fragments.fragment_shorts;
import com.surya.bottom_navigation.fragments.fragment_subscriptions;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new fragment_home());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new fragment_home());
                    break;

                case R.id.shorts:
                    replaceFragment(new fragment_shorts());
                    break;

                case R.id.subscriptions:
                    replaceFragment(new fragment_subscriptions());
                    break;

                case R.id.library:
                    replaceFragment(new fragment_library());
                    break;
            }

            return true;

        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}