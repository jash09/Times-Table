package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesListView;
    public void generateTimesTable(int timesTableNumber){

        ArrayList<String> timesTableContent= new ArrayList<String>();

        for(int j=1;j<=10;j++){

            timesTableContent.add(Integer.toString(j * timesTableNumber));


        }
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);

        timesTablesListView.setAdapter(arrayAdapter);



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SeekBar timesTablesSeekBar= findViewById(R.id.seekBar2);

        timesTablesListView = findViewById(R.id.timesTablesListView);

        timesTablesSeekBar.setMax(20);
        timesTablesSeekBar.setProgress(10);
        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timesTableNumber;
                if(progress<min){

                    timesTableNumber=min;
                    timesTablesSeekBar.setProgress(min);
                }else{

                    timesTableNumber = progress;
                }

                Log.i("Seekbar",Integer.toString(timesTableNumber));

                generateTimesTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
