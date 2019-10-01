package com.hfad.starbuzz;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DrinkActivity extends AppCompatActivity
{
    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        //Get the drink from the intent
        //從 intent 取得飲料號碼
        int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);

        //Create a cursor
        //建立 cursor
        try
        {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query ("DRINK", new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"}, "_id = ?", new String[] {Integer.toString(drinkNo)}, null, null,null);

            //Move to the first record in the Cursor
            //移動到 cursor 第一筆紀錄
            if (cursor.moveToFirst())
            {
                //Get the drink details from the cursor
                //從 cursor 取得飲料細節
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                boolean isFavorite = (cursor.getInt(3) == 1);

                //Populate the drink name
                //填上飲料名稱
                TextView name = (TextView)findViewById(R.id.name);
                name.setText(nameText);

                //Populate the drink description
                //填上飲料描述
                TextView description = (TextView)findViewById(R.id.description);
                description.setText(descriptionText);

                //Populate the drink image
                //填入飲料圖像
                ImageView photo = (ImageView)findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);

                //Populate the favorite checkbox
                //填入最愛的飲料選項
                CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
                favorite.setChecked(isFavorite);
            }
            cursor.close();
            db.close();
        }
        catch(SQLiteException e)
        {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    //Update the database when the checkbox is clicked
    //當 checkbox 被點選時，更新資料庫
    public void onFavoriteClicked(View view)
    {
        int drinkNo = (Integer)getIntent().getExtras().get("drinkNo");
        new UpdateDrinkTask().execute(drinkNo);
    }

    //Inner class to update the drink.
    private class UpdateDrinkTask extends AsyncTask<Integer, Void, Boolean>
    {
        ContentValues drinkValues;
        protected void onPreExecute()
        {
            CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
            drinkValues = new ContentValues();
            drinkValues.put("FAVORITE", favorite.isChecked());
        }

        protected Boolean doInBackground(Integer... drinks)
        {
            int drinkNo = drinks[0];
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(DrinkActivity.this);
            try
            {
                SQLiteDatabase db = starbuzzDatabaseHelper.getWritableDatabase();
                db.update("DRINK", drinkValues, "_id = ?", new String[] {Integer.toString(drinkNo)});
                db.close();
                return true;
            }
            catch(SQLiteException e)
            {
                return false;
            }
        }

        protected void onPostExecute(Boolean success)
        {
            if (!success)
            {
                Toast toast = Toast.makeText(DrinkActivity.this, "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
