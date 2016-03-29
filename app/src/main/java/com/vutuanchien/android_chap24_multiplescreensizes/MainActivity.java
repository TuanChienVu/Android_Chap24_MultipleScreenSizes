package com.vutuanchien.android_chap24_multiplescreensizes;

import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createView();
        Toast.makeText(MainActivity.this, "Xoay Màn Hình", Toast.LENGTH_SHORT).show();
    }

    private void createView() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        MenuFragment menuFragment = new MenuFragment();
        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            DetailsFragment detailFragment = new DetailsFragment();
            Bundle args = new Bundle();
            args.putInt("ID", 0);
            detailFragment.setArguments(args);
            ft.add(R.id.flDetail, detailFragment, "DETAIL");
        }
        ft.add(R.id.flMenu, menuFragment, "MENU").disallowAddToBackStack();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
