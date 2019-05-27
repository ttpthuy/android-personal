package com.example.thuytran.listviewtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Question> questionList ;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            try {
                getData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        myAdapter = new MyAdapter(this, R.layout.activity_row_list_view, questionList);
        listView.setAdapter(myAdapter);


    }

    private void getData() throws ExecutionException, InterruptedException, JSONException, IOException {
        listView = (ListView) findViewById(R.id.list_item);
        questionList = new ArrayList<>();
        String url = "http://10.0.3.2:8080/hello";
        DownloadJSON downloadJSON = new DownloadJSON(url);
        Log.i("question2",  "hihih");
        downloadJSON.execute();
        String dataJSON = downloadJSON.get();
        JSONArray jsonArrayDanhSachSanPham = new JSONArray(dataJSON);
//        List<Question> questions = new ArrayList<>();
        for (int i = 0 ; i < jsonArrayDanhSachSanPham.length(); i++){
            JSONObject object = jsonArrayDanhSachSanPham.getJSONObject(i);
            questionList.add(new Question(object));
        }
        Log.i("questionListing", questionList + "");
        Collections.shuffle(questionList);
    }




}
