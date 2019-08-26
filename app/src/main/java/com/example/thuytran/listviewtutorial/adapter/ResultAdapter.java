package com.example.thuytran.listviewtutorial.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.model.Result;

import java.util.List;

public class ResultAdapter extends BaseAdapter {
    private Context context;
    private List<Result> results;
    LayoutInflater layoutInflater;
    public ResultAdapter(Context context, List<Result> results) {
        this.context = context;
        this.results = results;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int position) {
        return results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(results.get(position).getId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ResultHolder resultHolder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.result_row, null);
             resultHolder = new ResultHolder();
            resultHolder.tv = convertView.findViewById(R.id.tv);
            resultHolder.noFit = convertView.findViewById(R.id.noFit);
            resultHolder.mProgress = convertView.findViewById(R.id.circularProgressbar);
            resultHolder.result = convertView.findViewById(R.id.resultTV);
            convertView.setTag(resultHolder);
        }else {
            resultHolder = (ResultHolder) convertView.getTag();
        }
        Result result = results.get(position);
        String score = String.valueOf(Math.round(result.getScore() * 10));
        score = score.substring(0,2);
        result.setScore(Integer.parseInt(score));
        resultHolder.noFit.setVisibility(View.INVISIBLE);
        if(result.getScore() < 0){
            resultHolder.noFit.setVisibility(View.VISIBLE);
            result.setScore(-result.getScore());
        }
        resultHolder.tv.setText(result.getScore() + "%");
        resultHolder.result.setText(result.getName() + "\n" + result.getScore());
        resultHolder.mProgress.setProgress((int)result.getScore());
        return convertView;
    }
    private class ResultHolder{
        TextView tv, noFit, result;
        ProgressBar mProgress;


    }
}
