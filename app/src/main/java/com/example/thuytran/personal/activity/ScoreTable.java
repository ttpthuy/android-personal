package com.example.thuytran.personal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.thuytran.personal.R;
import com.example.thuytran.personal.model.Job;

import java.util.ArrayList;

public class ScoreTable extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    RadioGroup radioGroup, sexGroup ;
    int checkId;
    RadioButton nam, nu;
    byte gioitinh = 0;
    Job job;
    ArrayList<String> subjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_table);
        initialize();


       Log.i("jobSelected", job + "");

    }
    public void initialize(){
        radioGroup = (RadioGroup) findViewById(R.id.radioGr);
        sexGroup = (RadioGroup) findViewById(R.id.sexGroup);
        sexGroup.setOnCheckedChangeListener(this);
        nam = (RadioButton) findViewById(R.id.nam);
        nu = (RadioButton) findViewById(R.id.nu);
        radioGroup.setOnCheckedChangeListener(this);
        try {
            Intent intent = getIntent();
           subjects = new ArrayList<String>();
             job = (Job) intent.getSerializableExtra("jobSelected");
            if(job != null){
                String jobGroup = job.getGroup();
                switch (jobGroup.toLowerCase()){
                    case "xh":
                        subjects.add("Toán");
                        subjects.add("Văn");
                        subjects.add("Anh");
                        subjects.add("Sử");
                        subjects.add("Địa");
                        break;
                    case "tn":
                        subjects.add("Toán");
                        subjects.add("Lý");
                        subjects.add("Hóa");
                        subjects.add("Sinh");
                        subjects.add("Anh");
                        break;
                    default:
                        subjects.add("Toán");
                        subjects.add("Lý");
                        subjects.add("Hóa");
                        subjects.add("Văn");
                        subjects.add("Anh");
                        subjects.add("Sinh");
                        subjects.add("Sử");
                        subjects.add("Địa");
                        break;
                }

            }
        }catch (NullPointerException e){
            Log.i("Exception", e.toString());
        }


    }

    public void onRadioButtonClicked(View view){
    }
    public void nextToScore(View view ){
        Intent intent = new Intent(this, CheckScoreHandle.class);
        intent.putExtra("level", checkId );
        intent.putExtra("sex", gioitinh);
        intent.putExtra("subjects", subjects );
        intent.putExtra("job", job);
        Log.i("subjectsssss", subjects + "");
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
