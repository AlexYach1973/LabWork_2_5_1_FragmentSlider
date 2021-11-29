package com.example.android.labwork_2_5_1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyAdapter(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        // устанавливаем адаптер
        viewPager.setAdapter(adapter);
        // выводим второй экран
        viewPager.setCurrentItem(0);

        // Tabs
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        // Title for Fragment


    }



    public static class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();

                default:
                    return new Fragment1();
            }
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String title = null;
            switch (position) {
                case 0:
                    title = "Jerry";
                    break;
                case 1:
                    title = "Tom";
                    break;
                case 2:
                    title = "TEXT";
                    break;
            }
            return title;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}