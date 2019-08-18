package com.example.thuytran.listviewtutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.thuytran.listviewtutorial.R;

public class ScoreTable extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    RadioGroup radioGroup, sexGroup ;
    int checkId;
    RadioButton nam, nu;
    byte gioitinh = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_table);
        radioGroup = (RadioGroup) findViewById(R.id.radioGr);
        sexGroup = (RadioGroup) findViewById(R.id.sexGroup);
        sexGroup.setOnCheckedChangeListener(this);
        nam = (RadioButton) findViewById(R.id.nam);
        nu = (RadioButton) findViewById(R.id.nu);
//        nam.setOnClickListener(this);
//        nu.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);

    }

    public void onRadioButtonClicked(View view){
    }
    public void nextToScore(View view ){
        Intent intent = new Intent(this, CheckScoreHandle.class);
        intent.putExtra("level", checkId );
        intent.putExtra("sex", gioitinh);
        Log.i("level", checkId + "");
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nam:
                gioitinh = 0;
                break;
            case R.id.nu:
                gioitinh = 1;
                break;

        }
    }

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
            case R.id.nam:
                gioitinh = 0;
                break;
            case R.id.nu:
                gioitinh = 1;
                break;
        }
    }
}
