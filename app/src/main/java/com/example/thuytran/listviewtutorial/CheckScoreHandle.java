package com.example.thuytran.listviewtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class CheckScoreHandle extends AppCompatActivity {

    ListView listViewScore;
    Button btnSendScore;
    List<String> subjects;
    int idButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_score);

        initElement();
        getData();
        Log.i("checkScore", "checkScore");
        Log.i("listSub", subjects + "");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.score_row, R.id.textSubject, subjects);
        listViewScore.setAdapter(arrayAdapter);
    }
    public void getData(){
        subjects.add("Toán");
        subjects.add("Lý");
        subjects.add("Hóa");
        subjects.add("Văn");
        subjects.add("Anh");

    }
    public void initElement() {
        Intent intent = getIntent();
        idButton = intent.getIntExtra("level", 2131165277 );
        Log.i("radioClcik2", idButton + "");
        listViewScore = (ListView) findViewById(R.id.scoreLV);
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
    }
    public void sendScore() throws ExecutionException, InterruptedException {
        DownloadJSON downloadJSON = new DownloadJSON("http://10.0.3.2:8080/demo");

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

        String jsonFromJavaArrayList = gsonBuilder.toJson(attrs);

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
