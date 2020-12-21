package com.example.eventappdsc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Button AddEventbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        String formname = intent.getStringExtra("FormName");
        String formdesc = intent.getStringExtra("FormDesc");



        int CheckForm = intent.getIntExtra("Check",0);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.favicon,"DSC WOW", "DSC WOW - India's Biggest Code Collaboration"));
        models.add(new Model(R.drawable.kotline, "Android Jams"," Android Study Jams : Intro to kotline and new to programming"));
        models.add(new Model(R.drawable.tcce,"Theory and Mathematics"," Hands on Virtual workshop on Theory and Mathematics"));

        if(CheckForm == 1)
        {
        models.add(new Model(R.drawable.brochure, formname,formdesc));
        }

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0,130,0);

        Integer[] colors_temp = {getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3)};

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() -1) && position < (colors.length - 1)){
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset,colors[position], colors[position+1]));
                }
                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        AddEventbtn = findViewById(R.id.btnAddEvent);

        AddEventbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEventPage.class);
                startActivity(intent);
            }
        });


    }
}