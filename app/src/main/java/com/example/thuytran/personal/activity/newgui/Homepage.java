package com.example.thuytran.personal.activity.newgui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.thuytran.personal.R;
import com.example.thuytran.personal.activity.Jobs;

public class Homepage extends AppCompatActivity implements View.OnClickListener {
    Button gioithieu, tuvanchonnghanh, xacdinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        initElement();
    }

    private void initElement() {
        gioithieu = (Button) findViewById(R.id.thongtintuvan);
        tuvanchonnghanh = (Button) findViewById(R.id.tuvanchonnghanh);
        xacdinh = (Button) findViewById(R.id.xacdinhnghanhnghe);
        gioithieu.setOnClickListener(this);
        tuvanchonnghanh.setOnClickListener(this);
        xacdinh.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.thongtintuvan:
                Log.i("levelActivity", "Thong tin tu van");
                break;
            case R.id.tuvanchonnghanh:
                Intent intent = new Intent(Homepage.this, Level.class);
                startActivity(intent);
                break;
            case R.id.xacdinhnghanhnghe:
                Intent intent2 = new Intent(Homepage.this, Jobs.class);
                startActivity(intent2);
                Log.i("levelActivity", "Xac dinh nghanh nghe");
                break;

        }
    }
}
