package com.example.thuytran.listviewtutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.adapter.SchoolScoreAdapter;
import com.example.thuytran.listviewtutorial.adapter.ScoreAdapter;
import com.example.thuytran.listviewtutorial.jsonconvert.DownloadJSON;
import com.example.thuytran.listviewtutorial.jsonconvert.PostToServer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CheckScoreHandle extends AppCompatActivity {
    TextView txtViewLevel;
    ListView scoreLV10, scoreLV11, scoreLV12, scoreLVDH;
    Button btnSendScore;
    List<String> subjects;
    int idButton ;
    private LinearLayout[] rowsOfLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_score);
        Intent intent = getIntent();
        idButton = intent.getIntExtra("level", 2131165277 );
        initElement();
        ArrayAdapter<String> scoreAdapter = new ArrayAdapter<String>(this, R.layout.score_row, R.id.textSubject, subjects);
//        ScoreAdapter scoreAdapter = new ScoreAdapter(this, R.layout.score_row, subjects);
//        SchoolScoreAdapter scoreAdapter = new SchoolScoreAdapter(this, subjects);
        scoreLV10.setAdapter(scoreAdapter);
        scoreLV11.setAdapter(scoreAdapter);
        scoreLV12.setAdapter(scoreAdapter);
        scoreLVDH.setAdapter(scoreAdapter);
        Log.i("checkScore", "checkScore");
        Log.i("listSub", subjects + "");

    }
    public void getData(){
        subjects.add("Toán");
        subjects.add("Lý");
        subjects.add("Hóa");
        subjects.add("Văn");
        subjects.add("Anh");

    }
    public void initElement() {
        rowsOfLevel = new LinearLayout[4];
        rowsOfLevel[0] = (LinearLayout) findViewById(R.id.firstLayout);
        rowsOfLevel[1] = (LinearLayout) findViewById(R.id.secondLayout);
        rowsOfLevel[2] = (LinearLayout) findViewById(R.id.thirdLayout);
        rowsOfLevel[3] = (LinearLayout) findViewById(R.id.fourthLayout);
        scoreLV10 = (ListView) findViewById(R.id.scoreLV10);
        scoreLV11 = (ListView) findViewById(R.id.scoreLV11);
        scoreLV12 = (ListView) findViewById(R.id.scoreLV12);
        scoreLVDH = (ListView) findViewById(R.id.scoreLVDH);
        btnSendScore = (Button) findViewById(R.id.btnSendScore);
        subjects = new ArrayList<>();
        btnSendScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                try {
                    sendScore();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        getData();
        for (LinearLayout horizontalLinearLayout : rowsOfLevel) {
            horizontalLinearLayout.setVisibility(View.GONE);
        }

        for (int row = 0; row < idButton; row++) {
            rowsOfLevel[row].setVisibility(View.VISIBLE);

        }
    }
    public void sendScore() throws ExecutionException, InterruptedException {
//        DownloadJSON downloadJSON = new DownloadJSON("http://10.0.3.2:8080/demo");

//        String dataJSON = downloadJSON.get();
//        Log.i("demo1", dataJSON);
        List<HashMap<String, HashMap<String, String>>> attrs = new ArrayList<>();
        String dataJSON = "";
        HashMap<String, String> lop10 = new HashMap<>();
        lop10.put("toan", "10");
        lop10.put("ly", "1");
        lop10.put("hoa", "5");
        lop10.put("van", "2");
        lop10.put("anh", "1");

        HashMap<String,HashMap<String, String>> json = new HashMap<>();
        json.put("lop10", lop10);

        attrs.add(json);

        Gson gsonBuilder = new GsonBuilder().create();

        String jsonFromJavaArrayList = gsonBuilder.toJson(json);

        System.out.println(jsonFromJavaArrayList);
        Log.i("tojson", jsonFromJavaArrayList);

        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("s",jsonFromJavaArrayList)
                .setType(MultipartBody.FORM)
                .build();
        PostToServer postToServer = new PostToServer("http://10.0.3.2:8080/demo", requestBody);
        postToServer.execute();
//        downloadJSON.execute();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}
