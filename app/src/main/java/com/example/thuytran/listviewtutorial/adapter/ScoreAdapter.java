package com.example.thuytran.listviewtutorial.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.example.thuytran.listviewtutorial.R;

import java.util.ArrayList;
import java.util.List;

public class ScoreAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<String> subjectList;
    ViewHold viewHold;

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
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
             viewHold = new ViewHold();
            viewHold.textSubject = (TextView) convertView.findViewById(R.id.textSubject);
            viewHold.score = (EditText) convertView.findViewById(R.id.scoreET);

            Log.i("scoreET", subjectList.get(position) + "  " + viewHold.score.getText());
            convertView.setTag(viewHold);
        }else{
            Log.i("else", "ewwwwww");
            viewHold = (ViewHold) convertView.getTag();
        }
        viewHold.textSubject.setText(subjectList.get(position));
        return convertView;

    }
    static class ViewHold {
        TextView textSubject;
        EditText score;

    }
}

