package com.example.thuytran.listviewtutorial.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.adapter.MyAdapter;
import com.example.thuytran.listviewtutorial.jsonconvert.DownloadJSON;
import com.example.thuytran.listviewtutorial.model.Question;
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
    RadioGroup radioGroup;
    Button getAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initElement();
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
    private void initElement(){
        radioGroup = (RadioGroup) findViewById(R.id.checkScroreRadio);
        listView = (ListView) findViewById(R.id.list_item);
        questionList = new ArrayList<>();
        listView.setOnItemClickListener(onItemClickListener);
        getAns = (Button) findViewById(R.id.getAns);
        getAns.setOnClickListener(getAnsClickItem);

    }
    private View.OnClickListener getAnsClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i("ans", Arrays.toString(myAdapter.getAns()));
        }
    };



    private void getData() throws ExecutionException, InterruptedException, JSONException, IOException {
        String url = "http://10.0.3.2:8080/hello";
        DownloadJSON downloadJSON = new DownloadJSON(url);
        Log.i("question2",  "hihih");
        downloadJSON.execute();
        String dataJSON = downloadJSON.get();
        JSONArray jsonArrayDanhSachSanPham = new JSONArray(dataJSON);
        for (int i = 0 ; i < jsonArrayDanhSachSanPham.length(); i++){
            JSONObject object = jsonArrayDanhSachSanPham.getJSONObject(i);
            questionList.add(new Question(object));
        }
        Log.i("questionListing", questionList + "");
        Collections.shuffle(questionList);

//        questionList.add(new Question("01","01", "Like ME"));
//        questionList.add(new Question("02","01", "Like Him"));
//        questionList.add(new Question("03","01", "Like\ ME"));
//        questionList.add(new Question("04","01", "Like ME"));
//        questionList.add(new Question("05","01", "Like ME"));
//        questionList.add(new Question("06","01", "Like ME"));
//        questionList.add(new Question("07","01", "Like ME"));

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
       Map<Integer, Integer> map = new HashMap<>();
       Log.i("parent", view.getParent().getParent().getParent() + "");
        switch(view.getId()) {
            case R.id.ans1:
                if (checked)
                    Log.i("checked", 1 + "");
//                    map.put(listView.getCheckedItemPosition(), 1);
                    break;
            case R.id.ans2:
                if (checked)
                    Log.i("checked", 2 + "");
                    break;
            case R.id.ans3:
                if (checked)
                    Log.i("checked", 3 + "");
                    break;
            case R.id.ans4:
                if (checked)
                    Log.i("checked", 4 + "");
                    break;
            case R.id.ans5:
                if (checked)
                    Log.i("checked", 5 + "");
                    break;
        }





//        final Map<String, String> map = new HashMap<>();
//        Log.i("shuffled",questionList + "");
//        radioGroup = findViewById(R.id.checkScroreRadio);
//        Log.i("count",  radioGroup.getChildCount()+"");
//        ListView parentRow = (ListView) vieww.getParent();
//        final int position = parentRow.getPositionForView((View)vieww.getParent());
//        Log.i("position", position + "");
//        boolean checked = ((RadioButton) vieww).isChecked();

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                boolean checked = ((RadioButton) vieww).isChecked();
//                switch(vieww.getId()) {
//
//                    case R.id.ans1:
//                        Log.i("check", checked + "");
//                        if (checked) {
//                            Log.i("position", position + "");
//                            Log.i("checked", checked + "");
//                            Log.i("clicked", 1 + "");
//                        }
//                        return ;
//                    case R.id.ans2:
//                        Log.i("check", checked + "");
//                        if (checked) {
//                            Log.i("position", position + "");
//                            Log.i("checked", checked + "");
//                            Log.i("clicked", 2 + "");
//                        }
//                        break;
//                    case R.id.ans3:
//                        Log.i("check", checked + "");
//                        if (checked) {
//                            Log.i("position", position + "");
//                            Log.i("checked", checked + "");
//                            Log.i("clicked", 3 + "");
//                        }
//                        break;
//                    case R.id.ans4:
//                        Log.i("check", checked + "");
//                        if (checked) {
//                            Log.i("position", position + "");
//                            Log.i("clicked", 4 + "");
//                            Log.i("checked", checked + "");
//                        }
//                        break;
//                    case R.id.ans5:
//                        if (checked) {
//                            Log.i("position", position + "");
//                            Log.i("checked", checked + "");
//                            Log.i("clicked", 5 + "");
//                        }
//                        break;
//                }
//            }
//        });

    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                long arg3) {
            // TODO Auto-generated method stub
            //do your job here, position is the item position in ListView
        }
    };

}
