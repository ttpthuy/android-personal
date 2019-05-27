package com.example.thuytran.listviewtutorial;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScoreAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<String> subjectList;
    ViewHold viewHolder;

    public ScoreAdapter(Context context, int layout, List<String> subjectList) {
        this.context = context;
        this.layout = layout;
        this.subjectList = subjectList;
    }

    public ScoreAdapter() {
        this.subjectList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        TextView textScore = (TextView) convertView.findViewById(R.id.textSubject);
        String sub = subjectList.get(position);
        Log.i("thisSub",sub);
        textScore.setText(sub);

        Log.i("scoreAdater", "score adapter is here");
//        if (convertView == null) {
//            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView =  layoutInflater.inflate(R.layout.score_row, null);
//            viewHolder = new ViewHold();
//            viewHolder.textScore = (TextView) convertView.findViewById(R.id.textSubject);
////            viewHolder.score = (EditText) convertView.findViewById(R.id.score);
//            convertView.setTag(viewHolder);
//        }else{
//            viewHolder = (ViewHold) convertView.getTag();
//        }
//
//        viewHolder.textScore.setText(sub);
        return convertView;

    }
    static class ViewHold {
        TextView textScore;
        EditText score;

    }
}

