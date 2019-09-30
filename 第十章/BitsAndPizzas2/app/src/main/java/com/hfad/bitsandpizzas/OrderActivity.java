package com.hfad.bitsandpizzas;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
