package com.example.thuytran.personal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.thuytran.personal.R;

public class Welcome extends AppCompatActivity {
    Button btnNext ;
    EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initElement();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p = phone.getText().toString();
                if(isValidNumberFormat(p)) {
                    goToIntro();
                }else{
                    Toast.makeText(getApplicationContext(), "Your phone iss wrong", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    private void initElement(){
        btnNext = (Button) findViewById(R.id.btnNext);
        phone = (EditText) findViewById(R.id.phone);

    }
    private boolean isValidNumberFormat(String s){
       return  !TextUtils.isEmpty(s) &&
                Patterns.PHONE.matcher(s).matches();
    }
    private void goToIntro(){
        Intent intent = new Intent(this, Intro.class);
        startActivity(intent);
    }

}
