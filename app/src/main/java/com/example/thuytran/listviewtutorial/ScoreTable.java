package com.example.thuytran.listviewtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ScoreTable extends AppCompatActivity {
    RadioGroup radioGroup ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        radioGroup = (RadioGroup) findViewById(R.id.radioGr);
        setContentView(R.layout.activity_score_table);
    }
    public void onRadioButtonClicked(View view){
        Log.i("radioClcik", view.getId() +"");
    }
    public void nextToScore(View view, int i  ){
        Intent intent = new Intent(this, CheckScoreHandle.class);
        intent.putExtra("level", view.getId() );
        startActivity(intent);
    }
}
