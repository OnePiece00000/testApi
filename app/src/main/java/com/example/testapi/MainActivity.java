package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(this,WebActivity.class);
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.example.testapi","com.example.activiy.WebActivity");
        intent.setComponent(componentName);
        startActivity(intent);


    }
}