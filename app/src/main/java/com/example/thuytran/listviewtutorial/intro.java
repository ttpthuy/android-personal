package com.example.thuytran.listviewtutorial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class intro extends AppCompatActivity {
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
        Intent intent = new Intent(this, check_score.class);
        startActivity(intent);
    }
}
