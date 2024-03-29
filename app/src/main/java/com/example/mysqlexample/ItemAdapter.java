package com.example.mysqlexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mysqlexample.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    Map<String, Double> map;
    List<String> names;
    List<Double> prices;

    public ItemAdapter(Context c, Map m) {
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        map =m;
        names = new ArrayList<String>(map.keySet());
        prices = new ArrayList<Double>(map.values());

    }

    @Override
    public int getCount() {
        return map.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.item_layout, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView priceTextView = v.findViewById(R.id.priceTextView);

        nameTextView.setText(names.get(position));
        priceTextView.setText("$" + prices.get(position).toString());

        return v;

    }
}
