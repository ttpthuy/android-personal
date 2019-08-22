package com.example.thuytran.listviewtutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.model.Result;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    ListView resultLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        ArrayList<Result> resultArrayList = (ArrayList<Result>) intent.getSerializableExtra("lastResult");
        Log.i("lastResult2", resultArrayList + "");
        resultLV = (ListView) findViewById(R.id.resultLV);
        ArrayList<String> strings = new ArrayList<>();
        for(Result result : resultArrayList){
            strings.add(result.getName() + "\n" + result.getScore() + "\n" + result.getMaleRatio());
        }
        ArrayAdapter<String> resultArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings );
        resultLV.setAdapter(resultArrayAdapter);

    }
}
