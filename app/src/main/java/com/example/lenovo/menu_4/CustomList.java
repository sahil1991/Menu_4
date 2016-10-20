package com.example.lenovo.menu_4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lenovo on 19-10-2016.
 */
public class CustomList extends ArrayAdapter<String>{
    private String[] names;
    private String[] contact;
    private Activity context;

    public CustomList(Activity context, String[] names, String[] contact) {
        super(context, R.layout.list_layout, names);
        this.context = context;
        this.names = names;
        this.contact = contact;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.Name);
        TextView textViewDesc = (TextView) listViewItem.findViewById(R.id.Contact);


        textViewName.setText(names[position]);
        textViewDesc.setText(contact[position]);

        return  listViewItem;
    }
}
