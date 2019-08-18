package com.example.thuytran.listviewtutorial.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.model.EditModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Parsania Hardik on 03-Jan-17.
 */
public class Level11ScoreAdapter extends BaseAdapter {

    private Context context;
    public static ArrayList<EditModel> editModelArrayList;
    List<EditModel> editModels = new ArrayList<>();
    private String [] arr = {"Toan", "Ly","Hoa","Van","Anh", "Sinh", "Sử", "Địa"};
    public Level11ScoreAdapter(Context context, ArrayList<EditModel> editModelArrayList) {
        this.context = context;
        this.editModelArrayList = editModelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return editModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return editModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.score_row, null, true);

            holder.editText = (EditText) convertView.findViewById(R.id.scoreET);
            holder.textView = (TextView) convertView.findViewById(R.id.textSubject);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.textView.setText(arr[position]);

        holder.editText.setText("");

        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editModelArrayList.get(position).setEditTextValue(holder.editText.getText().toString());
                Log.i("========", editModelArrayList.get(position).getEditTextValue());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return convertView;
    }

    private class ViewHolder {
        protected TextView textView;
        protected EditText editText;

    }

}