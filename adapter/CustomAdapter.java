package com.example.anurag_pc.shreyafinalproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anurag_pc.shreyafinalproject.R;
import com.example.anurag_pc.shreyafinalproject.RowItem;

import java.util.List;

/**
 * Created by Anurag-PC on 7/11/2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context context ;
    List<RowItem> rowItems ;

    public CustomAdapter(Context context, List<RowItem> rowItems)
    {

        this.context = context;
        this.rowItems  = rowItems ;

    }



    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

//    private void ViewHolder()
//    {
//
//
//        ImageView shop_pic;
//        TextView shop_name;
//        TextView shop_type;     }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        LayoutInflater mInflater = ( LayoutInflater ) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE );

        if (convertView == null)
        {
            convertView = mInflater.inflate (R.layout.createlistitem, null);
            holder = new ViewHolder ();

            holder.shop_name = ( TextView) convertView.findViewById(R.id.shop_name);

            holder.shop_pic = ( ImageView) convertView.findViewById(R.id.shop_pic);

            holder.shop_type = ( TextView) convertView.findViewById(R.id.shop_type);

            RowItem row_pos = rowItems.get(position);

            holder.shop_pic.setImageResource (row_pos.getshop_pic_id());
            holder.shop_name.setText (row_pos.getshop_name());
            holder.shop_type.setText (row_pos.getshop_type());

        }

            return convertView;
    }

    private class ViewHolder {
        ImageView shop_pic;
        TextView shop_name;
        TextView shop_type;
    }
}

