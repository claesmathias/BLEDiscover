/*
 * Copyright (C) 2013 Mathias Claes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.claesinc.blediscover;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * LazyAdapter class
 *
 * @author claesmathias@gmail.com (Mathias Claes)
 */
public class LazyAdapter extends BaseAdapter{

    private static LayoutInflater mInflater = null;
    private Activity mActivity;
    private ArrayList<HashMap<String, String>> mData;

    public LazyAdapter(Activity activity, ArrayList data) {
        this.mActivity = activity;
        mData = data;
        mInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return mData.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int viewPosition, View convertView, ViewGroup viewParent) {

        View view = convertView;
        if(convertView==null)
            view = mInflater.inflate(R.layout.device_list, null);

        TextView title = (TextView)view.findViewById(R.id.title); // title
        TextView artist = (TextView)view.findViewById(R.id.artist); // artist name
        TextView duration = (TextView)view.findViewById(R.id.duration); // duration

        HashMap<String, String> song = new HashMap();
        song = mData.get(viewPosition);

        // Setting all values in listview
        title.setText("All the single ladies");
        artist.setText("Beyonce");
        duration.setText("5");

        return view;
    }
}
