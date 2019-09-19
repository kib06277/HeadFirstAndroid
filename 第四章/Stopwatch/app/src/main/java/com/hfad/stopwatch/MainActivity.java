package com.hfad.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    //Number of seconds displayed on the stopwatch.
    //顯示秒數
    private int seconds = 0;

    //Is the stopwatch running?
    //判斷時候還在執行
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (wasRunning)
        {
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    //Start the stopwatch running when the Start button is clicked.
    //當 Start 按鈕被點選時，開始計時
    public void onClickStart(View view)
    {
        running = true;
    }

    //Stop the stopwatch running when the Stop button is clicked.
    //當 Stop 按鈕被點選時，停止計時
    public void onClickStop(View view)
    {
        running = false;
    }

    //Reset the stopwatch when the Reset button is clicked.
    //當 Reset 按鈕被點選時，停止計時並歸 0
    public void onClickReset(View view)
    {
        running = false;
        seconds = 0;
    }

    //Sets the number of seconds on the timer.
    private void runTimer()
    {
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                int hours = seconds / 3600;
                int minutes = ( seconds % 3600 ) / 60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running)
                {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
