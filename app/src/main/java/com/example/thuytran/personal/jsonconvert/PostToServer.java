package com.example.thuytran.personal.jsonconvert;

import android.os.AsyncTask;
import okhttp3.*;

import java.io.IOException;

public class PostToServer extends AsyncTask<String, Void, String> {
    String duongdan;
    RequestBody requestBody;
    OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public PostToServer(String duongdan) {
        this.duongdan = duongdan;
    }

    public PostToServer(String duongdan, RequestBody requestBody) {
        this.duongdan = duongdan;
        this.requestBody = requestBody;
    }

    @Override
    protected String doInBackground(String... strings) {
        Request request = new Request.Builder()
                .url(duongdan)
                .post(requestBody)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
