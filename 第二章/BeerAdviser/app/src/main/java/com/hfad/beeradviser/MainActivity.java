package com.hfad.beeradviser;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Call when the button gets clicked
    //當按鈕被點擊時被呼叫
    public void onClickFindBeer(View view)
    {
        //Get a reference to the TextView
        //取得指向 TextView  的參考
        TextView brands = (TextView) findViewById(R.id.brands);

        //Get a reference to the Spinner
        //取得指向 Spinner 的參考
        Spinner color = (Spinner) findViewById(R.id.color);

        //Get the selected item in the Spinner
        //取得在 Spinner 被點選的項目
        String beerType = String.valueOf(color.getSelectedItem());

        //Get recommendations from the BeerExpert class
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList)
        {
            brandsFormatted.append(brand).append('\n');
        }

        //Display the beers
        //展示被點選的項目
        brands.setText(brandsFormatted);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
