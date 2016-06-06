/*
 * The MainActivity to hold fragments.
 * @author DrunkPiano
 * @version 1.0
 * Modifying History:
 * Modifier: DrunkPiano, June 5th 2016, fixed to accord it with the standard coding disciplines.
 */

package com.drunkpiano.allaboutthejune;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(Color.parseColor("#14000000"));

            //setStatusBarColor在v21/styles.xml中设置了（其实无需设置,因为可以沿用5.0以下配色）
            getWindow().setNavigationBarColor(Color.parseColor("#C33A29"));
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_main, new MainFragment())
                .commit();
    }
}
