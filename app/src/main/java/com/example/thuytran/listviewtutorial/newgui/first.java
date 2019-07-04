package com.example.thuytran.listviewtutorial.newgui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.activity.Intro;
import com.example.thuytran.listviewtutorial.activity.MainActivity;
import com.example.thuytran.listviewtutorial.activity.ScoreTable;

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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
