package com.example.thuytran.listviewtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class  check_score extends AppCompatActivity {

    ListView listViewScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_score);
        listViewScore = (ListView) findViewById(R.id.scoreLV);
        List<String> subjects = new ArrayList<>();
        subjects.add("Toán");
        subjects.add("Lý");
        subjects.add("Hóa");
        subjects.add("Văn");
        subjects.add("Anh");
        Log.i("checkScore", "checkScore");
        Log.i("listSub", subjects + "");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.score_row, R.id.textSubject, subjects);

//        listViewScore.setAdapter(scoreAdapter);
        listViewScore.setAdapter(arrayAdapter);
    }
    public void getData(){


    }
}
