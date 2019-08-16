package com.example.thuytran.listviewtutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.adapter.*;
import com.example.thuytran.listviewtutorial.jsonconvert.DownloadJSON;
import com.example.thuytran.listviewtutorial.model.EditModel;
import com.example.thuytran.listviewtutorial.model.SchoolScore;
import com.example.thuytran.listviewtutorial.sqllite.ScoreSqlLiteHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CheckScoreHandle extends AppCompatActivity {
    TextView txtViewLevel;
    ListView scoreLV10, scoreLV11, scoreLV12, scoreLVDH;
    Button btnSendScore;
    List<String> subjects;
    int idButton ;
    private LinearLayout[] rowsOfLevel;
    Level10ScoreAdapter scoreAdapter;
    Level11ScoreAdapter scoreAdapter2;
    Level12ScoreAdapter scoreAdapter3;
    LevelDaiHocScoreAdapter scoreAdapter4;
    ScoreSqlLiteHandler scoreSqlLiteHandler;
    public ArrayList<EditModel> editModelArrayList, editModelArrayList2, editModelArrayList3, editModelArrayList4;
    private RecyclerView lop10View, lop11View, lop12View, daihocView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_score);
        Intent intent = getIntent();
        idButton = intent.getIntExtra("level", 2131165277 );
        initElement();

//        scoreSqlLiteHandler = new ScoreSqlLiteHandler(CheckScoreHandle.this);

    }
    private ArrayList<EditModel> populateList(){

        ArrayList<EditModel> list = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            EditModel editModel = new EditModel();
            editModel.setEditTextValue(String.valueOf(i));
            list.add(editModel);
        }

        return list;
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

        //set number of layout depend on user choice
        for (LinearLayout horizontalLinearLayout : rowsOfLevel) {
            horizontalLinearLayout.setVisibility(View.GONE);
        }

        for (int row = 0; row < idButton; row++) {
            rowsOfLevel[row].setVisibility(View.VISIBLE);
        }

        //set adapter for listview
        scoreLV10 = (ListView) findViewById(R.id.scoreLV10);
        scoreLV11 = (ListView) findViewById(R.id.scoreLV11);
        scoreLV12 = (ListView) findViewById(R.id.scoreLV12);
        scoreLVDH = (ListView) findViewById(R.id.scoreLVDH);
        editModelArrayList = populateList();
        editModelArrayList2 = populateList();
        editModelArrayList3 = populateList();
        editModelArrayList4 = populateList();
        scoreAdapter = new Level10ScoreAdapter(CheckScoreHandle.this, editModelArrayList);
        scoreAdapter2 = new Level11ScoreAdapter(CheckScoreHandle.this, editModelArrayList2);
        scoreAdapter3 = new Level12ScoreAdapter(CheckScoreHandle.this, editModelArrayList3);
        scoreAdapter4 = new LevelDaiHocScoreAdapter(CheckScoreHandle.this, editModelArrayList3);
        configAdapter();

    }

    private void configAdapter() {
        scoreLV10.setAdapter(scoreAdapter);
        scoreLV11.setAdapter(scoreAdapter2);
        scoreLV12.setAdapter(scoreAdapter3);
        scoreLVDH.setAdapter(scoreAdapter);

    }

    public void sendScore() throws ExecutionException, InterruptedException {
        SchoolScore lop10, lop11, lop12, lop13;
        Intent intent = new Intent(this, MainActivity.class);
        ArrayList<SchoolScore> schoolScores = new ArrayList<>();
        if( Level10ScoreAdapter.editModelArrayList.size() > 1){
             lop10 = new SchoolScore("lop10", Level10ScoreAdapter.editModelArrayList );
             schoolScores.add(lop10);
            Log.i("lop10", lop10 + "");
        }
        if(idButton > 1 && Level11ScoreAdapter.editModelArrayList.size() > 1){
            lop11 = new SchoolScore("lop11", Level11ScoreAdapter.editModelArrayList );
            schoolScores.add(lop11);
            Log.i("lop11", lop11 + "");
        }
        if(idButton > 2 && Level12ScoreAdapter.editModelArrayList.size() > 1){
            lop12 = new SchoolScore("lop12", Level12ScoreAdapter.editModelArrayList );
            schoolScores.add(lop12);
            Log.i("lop12", lop12 + "");
        }
        if( idButton > 3 && LevelDaiHocScoreAdapter.editModelArrayList.size() > 1){
            lop13 = new SchoolScore("daihoc", LevelDaiHocScoreAdapter.editModelArrayList );
            schoolScores.add(lop13);
            Log.i("lop13", lop13 + "");
        }
        //SQLLite saving
//      scoreSqlLiteHandler.addSchoolScore(new SchoolScore("lop10",1,1,1,1,1));
//      scoreSqlLiteHandler.addSchoolScore(new SchoolScore("lop11",2,2,2,2,2));
//      scoreSqlLiteHandler.addSchoolScore(new SchoolScore("lop12",3,3,3,3,3));
//      Log.i("allll", scoreSqlLiteHandler.getAllSchoolScore() + "");

        //Send to server
//        DownloadJSON downloadJSON = new DownloadJSON("http://10.0.3.2:8080/demo");
//        String dataJSON = downloadJSON.get();
//        Log.i("demo1", dataJSON);

//        List<HashMap<String, HashMap<String, String>>> attrs = new ArrayList<>();
//        String dataJSON = "";
//        HashMap<String, String> lop10 = new HashMap<>();
//        lop10.put("toan", "10");
//        lop10.put("ly", "1");
//        lop10.put("hoa", "5");
//        lop10.put("van", "2");
//        lop10.put("anh", "1");
//
//        HashMap<String,HashMap<String, String>> json = new HashMap<>();
//        json.put("lop10", lop10);
//
//        attrs.add(json);
//
//        Gson gsonBuilder = new GsonBuilder().create();
//
//        String jsonFromJavaArrayList = gsonBuilder.toJson(json);
//
//        System.out.println(jsonFromJavaArrayList);
//        Log.i("tojson", jsonFromJavaArrayList);
//
//        RequestBody requestBody = new MultipartBody.Builder()
//                .addFormDataPart("s",jsonFromJavaArrayList)
//                .setType(MultipartBody.FORM)
//                .build();
//        PostToServer postToServer = new PostToServer("http://10.0.3.2:8080/demo", requestBody);
//        postToServer.execute();
////        downloadJSON.execute();

        intent.putExtra("schoolscore", schoolScores);
        startActivity(intent);

    }
}
