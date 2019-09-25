package com.hfad.workout;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.Fragment;

public class WorkoutDetailFragment extends Fragment
{
    private long workoutId;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //呼叫上次操作的資料
        if (savedInstanceState != null)
        {
            workoutId = savedInstanceState.getLong("workoutId");
        }
        else
        {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction(); //開始 FragmentTransaction 交易
            StopwatchFragment stopwatchFragment = new StopwatchFragment(); //建立 StopwatchFragment
            ft.replace(R.id.stopwatch_container, stopwatchFragment); //交易切換
            ft.addToBackStack(null); //返回堆疊為 null
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //交易模式
            ft.commit(); //確定設定
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        View view = getView();
        if (view != null)
        {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) workoutId]; title.setText(workout.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putLong("workoutId", workoutId);
    }

    public void setWorkout(long id)
    {
        this.workoutId = id;
    }
}
