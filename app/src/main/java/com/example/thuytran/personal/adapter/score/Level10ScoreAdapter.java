package com.example.thuytran.personal.adapter.score;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.example.thuytran.personal.R;
import com.example.thuytran.personal.model.EditModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Parsania Hardik on 03-Jan-17.
 */
public class Level10ScoreAdapter extends BaseAdapter {

    private Context context;
    public static ArrayList<EditModel> editModelArrayList;
    List<EditModel> editModels = new ArrayList<>();
    ArrayList<String> subjects ;
    public Level10ScoreAdapter(Context context, ArrayList<EditModel> editModelArrayList, ArrayList<String> subjects) {
        this.context = context;
        this.editModelArrayList = editModelArrayList;
        this.subjects = subjects;
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
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.score_row, null, true);
            holder.textView = (TextView) convertView.findViewById(R.id.textSubject);
            holder.editText = (EditText) convertView.findViewById(R.id.scoreET);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.textView.setText(this.subjects.get(position));

        holder.editText.setText("");

        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editModelArrayList.get(position).setEditTextValue(holder.editText.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!holder.editText.getText().toString().isEmpty()) {
                    int number = Integer.parseInt(holder.editText.getText().toString());
                }
//                editModelArrayList.get(position).setEditTextValue(holder.editText.getText().toString());
            }
        });
        return convertView;
    }
    public static boolean isEditTextEmpty(){
        if( editModelArrayList == null || editModelArrayList.isEmpty() )
            return true;
        for (EditModel editModel: editModelArrayList ) {
            if(editModel.getEditTextValue().matches("")){
                return true;
            }

        }
        return false;
    }

    private class ViewHolder {
        protected TextView textView;
        protected EditText editText;

    }

}