package com.example.thuytran.personal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.thuytran.personal.R;
import com.example.thuytran.personal.activity.newgui.Homepage;
import com.example.thuytran.personal.adapter.ResultAdapter;
import com.example.thuytran.personal.model.Result;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    ListView resultLV;
    ArrayList<Result> resultArrayList;
    TextView tv, noFit;
    ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getResult();
    }


    private void getResult() {
        Intent intent = getIntent();
        resultArrayList = (ArrayList<Result>) intent.getSerializableExtra("lastResult");
        Log.i("lastResult2", resultArrayList + "");
        resultLV = (ListView) findViewById(R.id.resultLV);
        ResultAdapter resultArrayAdapter = new ResultAdapter(this, resultArrayList);
        resultLV.setAdapter(resultArrayAdapter);

    }
    public void backToMain(View view){
        Intent intent = new Intent(ResultActivity.this, Homepage.class);
        startActivity(intent);
    }

}
