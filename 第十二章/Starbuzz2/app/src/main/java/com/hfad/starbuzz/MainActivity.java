package com.hfad.starbuzz;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private SQLiteDatabase db;
    private Cursor favoritesCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create an OnItemClickListener
        //為 list_options ListView 建立 OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> listView, View v, int position, long id)
            {
                if (position == 0)
                {
                    Intent intent = new Intent(MainActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }
            }
        };

        //Add the listener to the list view
        //為物件增加事件
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);

        //Populate the list_favorites ListView from a cursor
        //為 listView 填值
        ListView listFavorites = (ListView)findViewById(R.id.list_favorites);
        try
        {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            db = starbuzzDatabaseHelper.getReadableDatabase();
            favoritesCursor = db.query("DRINK", new String[] { "_id", "NAME"}, "FAVORITE = 1", null, null, null, null);
            CursorAdapter favoriteAdapter = new SimpleCursorAdapter(MainActivity.this, android.R.layout.simple_list_item_1, favoritesCursor, new String[]{"NAME"}, new int[]{android.R.id.text1}, 0);
            listFavorites.setAdapter(favoriteAdapter);
        }
        catch(SQLiteException e)
        {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        //Navigate to DrinkActivity if a drink is clicked
        //如果飲料被點選，就瀏覽側滑頁
        listFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> listView, View v, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this, DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINKNO, (int)id);
                startActivity(intent);
            }
        });
    }

    //Close the cursor and database in the onDestroy() method
    //在 onDestroy() 銷毀時關閉 cursor 與資料庫
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        favoritesCursor.close();
        db.close();
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        try
        {
            StarbuzzDatabaseHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor newCursor = db.query("DRINK", new String[] { "_id", "NAME"}, "FAVORITE = 1", null, null, null, null);
            ListView listFavorites = (ListView)findViewById(R.id.list_favorites);
            CursorAdapter adapter = (CursorAdapter) listFavorites.getAdapter();
            adapter.changeCursor(newCursor);
            favoritesCursor = newCursor;
        }
        catch(SQLiteException e)
        {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
