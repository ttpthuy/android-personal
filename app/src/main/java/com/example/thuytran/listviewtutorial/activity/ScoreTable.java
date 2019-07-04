package com.example.thuytran.listviewtutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import com.example.thuytran.listviewtutorial.R;

public class ScoreTable extends AppCompatActivity {
    RadioGroup radioGroup ;
    int checkId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_table);
        radioGroup = (RadioGroup) findViewById(R.id.radioGr);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.lop10:
                        checkId = 1;
                        break;
                    case R.id.lop11:
                        checkId = 2;
                        break;
                    case R.id.lop12:
                        checkId = 3;
                        break;
                    case R.id.daihoc:
                        checkId = 4;
                        break;
                }

            }
        });
    }
    public void onRadioButtonClicked(View view){
    }
    public void nextToScore(View view ){
        Intent intent = new Intent(this, CheckScoreHandle.class);
        intent.putExtra("level", checkId );
        Log.i("level", checkId + "");
        startActivity(intent);
    }
}
