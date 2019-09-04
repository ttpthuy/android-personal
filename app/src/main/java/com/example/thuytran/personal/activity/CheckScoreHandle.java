package com.example.thuytran.personal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.thuytran.personal.R;
import com.example.thuytran.personal.adapter.score.*;
import com.example.thuytran.personal.jsonconvert.PostToServer;
import com.example.thuytran.personal.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CheckScoreHandle extends AppCompatActivity {
    TextView txtViewLevel;
    ListView scoreLV10, scoreLV11, scoreLV12, scoreLVDH;
    Button btnSendScore;
    ArrayList<String> subjects ;
    int idButton ;
    byte sex;
    private LinearLayout[] rowsOfLevel;
    Level10ScoreAdapter scoreAdapter;
    Level11ScoreAdapter scoreAdapter2;
    Level12ScoreAdapter scoreAdapter3;
    LevelDaiHocScoreAdapter scoreAdapter4;
    Job job;
    RecyclerView lv10, lv11, lv12, lvdh;
    Lv10RecyclerAdapter lv10RecyclerAdapter;
    Lv11RecyclerAdapter lv11RecyclerAdapter;
    Lv12RecyclerAdapter lv12RecyclerAdapter;
    LvDhRecyclerAdapter lvdhRecyclerAdapter;
    private ArrayList<QuestionAnswer> questionModels;
    public ArrayList<EditModel> editModelArrayList, editModelArrayList2, editModelArrayList3, editModelArrayList4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_score);

        initElement();
    }
    private ArrayList<EditModel> populateList(int size){

        ArrayList<EditModel> list = new ArrayList<>();
        if(size > 8){
            size = 8;
        }
        for(int i = 0; i < size; i++){
            EditModel editModel = new EditModel();
            editModel.setEditTextValue("");
            list.add(editModel);
        }

        return list;
    }
    public void getData(){
        Intent intent = getIntent();
        idButton = intent.getIntExtra("level", 2131165277 );
        sex = intent.getByteExtra("sex", Byte.MIN_VALUE);
        subjects = (ArrayList<String>) intent.getSerializableExtra("subjects");
        job = (Job) intent.getSerializableExtra("job");
        if(job == null){
            job = new Job();
        }
        Log.i("sex", sex + "");
        Log.i("jobSelectedDSMH", subjects + "");
        Log.i("jobSelectedDSMH1", job + "");

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
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        getData();
        if(subjects.size() < 1){
            subjects.add("Toán");
            subjects.add("Lý");
            subjects.add("Hóa");
            subjects.add("Văn");
            subjects.add("Anh");
            subjects.add("Sinh");
            subjects.add("Sử");
            subjects.add("Địa");
        }

        //set number of layout depend on user choice
        for (LinearLayout horizontalLinearLayout : rowsOfLevel) {
            horizontalLinearLayout.setVisibility(View.GONE);
        }

        for (int row = 0; row < idButton; row++) {
            rowsOfLevel[row].setVisibility(View.VISIBLE);
        }

        editModelArrayList = populateList(subjects.size());
        editModelArrayList2 = populateList(subjects.size());
        editModelArrayList3 = populateList(subjects.size());
        editModelArrayList4 = populateList(subjects.size());

        lv10 = (RecyclerView) findViewById(R.id.lop10View);
        lv11 = (RecyclerView) findViewById(R.id.lop11View);
        lv12 = (RecyclerView) findViewById(R.id.lop12View);
        lvdh = (RecyclerView) findViewById(R.id.daihocView);


        configAdapter();

    }

    private void configAdapter() {
        lv10RecyclerAdapter = new Lv10RecyclerAdapter(CheckScoreHandle.this, editModelArrayList, subjects);
        lv11RecyclerAdapter = new Lv11RecyclerAdapter(CheckScoreHandle.this, editModelArrayList2, subjects);
        lv12RecyclerAdapter = new Lv12RecyclerAdapter(CheckScoreHandle.this, editModelArrayList3, subjects);
        lvdhRecyclerAdapter = new LvDhRecyclerAdapter(CheckScoreHandle.this, editModelArrayList4, subjects);

        lv10.setAdapter(lv10RecyclerAdapter);
        lv11.setAdapter(lv11RecyclerAdapter);
        lv12.setAdapter(lv12RecyclerAdapter);
        lvdh.setAdapter(lvdhRecyclerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CheckScoreHandle.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(CheckScoreHandle.this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(CheckScoreHandle.this);
        linearLayoutManager3.setOrientation(LinearLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(CheckScoreHandle.this);
        linearLayoutManager4.setOrientation(LinearLayoutManager.VERTICAL);

        lv10.setLayoutManager(linearLayoutManager);
        lv11.setLayoutManager(linearLayoutManager2);
        lv12.setLayoutManager(linearLayoutManager3);
        lvdh.setLayoutManager(linearLayoutManager4);


    }

    public void sendScore() throws ExecutionException, InterruptedException, JSONException {
        SchoolScore lop10, lop11, lop12, lop13;
        Intent intent = new Intent(this, MainActivity.class);
        ArrayList<SchoolScore> schoolScores = new ArrayList<>();
        questionModels = new ArrayList<>();
        if( Lv10RecyclerAdapter.isEditTextEmpty() == false){
             lop10 = new SchoolScore("lop10", Lv10RecyclerAdapter.editModelArrayList, job.getGroup() );
             schoolScores.add(lop10);
            Log.i("lop10", lop10 + "");
        }
        if(idButton > 1 && Lv11RecyclerAdapter.isEditTextEmpty() == false){
            lop11 = new SchoolScore("lop11", Lv11RecyclerAdapter.editModelArrayList, job.getGroup() );
            schoolScores.add(lop11);
            Log.i("lop11", lop11 + "");
        }
        if(idButton > 2 && Lv12RecyclerAdapter.isEditTextEmpty() == false){
            lop12 = new SchoolScore("lop12", Lv12RecyclerAdapter.editModelArrayList, job.getGroup() );
            schoolScores.add(lop12);
            Log.i("lop12", lop12 + "");
        }
        if( idButton > 3 && LvDhRecyclerAdapter.isEditTextEmpty() == false){
            lop13 = new SchoolScore("daihoc", LvDhRecyclerAdapter.editModelArrayList, job.getGroup() );
            schoolScores.add(lop13);
            Log.i("lop13", lop13 + "");
        }
        //SQLLite saving
//      scoreSqlLiteHandler.addSchoolScore(new SchoolScore("lop10",1,1,1,1,1));
//      scoreSqlLiteHandler.addSchoolScore(new SchoolScore("lop11",2,2,2,2,2));
//      scoreSqlLiteHandler.addSchoolScore(new SchoolScore("lop12",3,3,3,3,3));
//      Log.i("allll", scoreSqlLiteHandler.getAllSchoolScore() + "");

        //Send to server

        JSONObject jsonObject = new JSONObject();
        Gson gsonBuilder = new GsonBuilder().create();
        if(schoolScores.size() >= 1) {
            jsonObject.put("score", schoolScores);
            jsonObject.put("sex", this.sex);
            Log.i("sexeee", this.sex + "");

            String url = "";
            if(job.getGroup() != null && !job.getGroup().isEmpty()  ){
                url = "http://192.168.42.2:8080/Grquestion2_step2";
                jsonObject.put("jobOfG", job);
                Log.i("duongdan", 111111 + "");
            }else{
                url = "http://192.168.42.2:8080/Grquestion1_step1";
                Log.i("duongdan", 222222222 + "");
            }
            String s = gsonBuilder.toJson(jsonObject);
            RequestBody requestBody = new MultipartBody.Builder()
                    .addFormDataPart("s", s)
                    .setType(MultipartBody.FORM)
                    .build();
            Log.i("duongdan", s );
            PostToServer postToServer = new PostToServer(url, requestBody);

            postToServer.execute();

            String dataJSON = postToServer.get();
            Log.i("miningques", dataJSON);

            JSONArray JHListQuestion = new JSONArray(dataJSON);
            for (int i = 0 ; i < JHListQuestion.length(); i++){
                JSONObject object = JHListQuestion.getJSONObject(i);
//            questionList.add(new Question(object));
                questionModels.add(new QuestionAnswer(new Question(object)));
            }
            intent.putExtra("schoolscore", schoolScores);
            intent.putExtra("JHListQuestion", questionModels);
            if(job.getGroup() != null && !job.getGroup().isEmpty()){
                intent.putExtra("job", job);
            }

            startActivity(intent);
        }else{
            Toast.makeText(this,"Bạn vui lòng nhập điểm nhé", Toast.LENGTH_SHORT).show();
        }

    }
}
