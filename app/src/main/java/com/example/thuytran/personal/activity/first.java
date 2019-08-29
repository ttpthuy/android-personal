package com.example.thuytran.personal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.thuytran.personal.R;

public class first extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    public void toIntro(View view){
        Intent intent = new Intent(this, Intro.class);
        startActivity(intent);

    }
    public void toScore(View view){
        Intent intent = new Intent(this, ScoreTable.class);
        startActivity(intent);
    }
    public void doTest(View view){
        Intent intent = new Intent(this, ScoreTable.class);
        startActivity(intent);
    }
    public void isFit(View view){
        Intent intent = new Intent(this, Jobs.class);
        startActivity(intent);
    }

}
