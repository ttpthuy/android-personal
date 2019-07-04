package com.example.thuytran.listviewtutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.thuytran.listviewtutorial.R;

public class Intro extends AppCompatActivity {
    Button btnTakeATest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        initElement();
        btnTakeATest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtnTakeATest();
            }
        });

    }
   private void initElement(){
        btnTakeATest = (Button) findViewById(R.id.buttonTake);

    }
    private void setBtnTakeATest (){
        Intent intent = new Intent(this, ScoreTable.class);
        startActivity(intent);
    }
}
