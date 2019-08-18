package com.example.thuytran.listviewtutorial.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.thuytran.listviewtutorial.R;
import com.example.thuytran.listviewtutorial.activity.Jobs;
import com.example.thuytran.listviewtutorial.model.Job;

import java.util.ArrayList;

public class JobAdapter extends BaseAdapter implements Filterable {
    private ArrayList<Job> mOriginalValues; // Original Values
    private ArrayList<Job> mDisplayedValues;    // Values to be displayed
    LayoutInflater inflater;

    private class JobViewHolder {
        LinearLayout llContainer;
        TextView jobName;
    }

    public JobAdapter(Context context, ArrayList<Job> mJobArrayList) {
        this.mOriginalValues = mJobArrayList;
        this.mDisplayedValues = mJobArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDisplayedValues.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        JobViewHolder holder = null;
        Log.i("arrayjob", mDisplayedValues.get(position).getJobName());
        if (convertView == null) {

            holder = new JobViewHolder();
            convertView = inflater.inflate(R.layout.job_item, null);
            holder.llContainer = (LinearLayout) convertView.findViewById(R.id.llContainer);
            holder.jobName = (TextView) convertView.findViewById(R.id.jobName);
            convertView.setTag(holder);
        } else {
            holder = (JobViewHolder) convertView.getTag();
        }
        holder.jobName.setText(mDisplayedValues.get(position).getJobName());
        holder.llContainer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.i("job", mDisplayedValues.get(position).getJobName());
            }
        });


        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                ArrayList<Job> FilteredArrList = new ArrayList<Job>();

                if (mOriginalValues == null) {
                    mOriginalValues = new ArrayList<Job>(mDisplayedValues); // saves the original data in mOriginalValues
                }

                /********
                 *
                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                 *  else does the Filtering and returns FilteredArrList(Filtered)
                 *
                 ********/
                if (constraint == null || constraint.length() == 0) {

                    // set the Original result to return
                    results.count = mOriginalValues.size();
                    results.values = mOriginalValues;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < mOriginalValues.size(); i++) {
                        String data = mOriginalValues.get(i).getJobName();
                        if (data.toLowerCase().startsWith(constraint.toString())) {
                            FilteredArrList.add(new Job(mOriginalValues.get(i).getIdJob(),mOriginalValues.get(i).getJobName(), mOriginalValues.get(i).getJobGroup()));
                        }
                    }
                    // set the Filtered result to return
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                mDisplayedValues = (ArrayList<Job>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }
        };
        return filter;
    }
}
