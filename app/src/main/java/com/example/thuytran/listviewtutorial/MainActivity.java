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
        myAdapter = new MyAdapter(this,R.layout.activity_row_list_view,questionList);
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

        List<Map.Entry<Integer, Question>> listMap = new ArrayList<Map.Entry<Integer, Question>>();
//        Map<String, Object> questionMap = toMap(jsonArrayDanhSachSanPham);
        for (int i = 0 ; i < jsonArrayDanhSachSanPham.length(); i++){
            listMap.add((Map.Entry<Integer, Question>) jsonArrayDanhSachSanPham.get(i));
        }
        Log.i("questionListing", listMap + "");
        questionList.addAll(listMap)
    }

    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }
    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
}
