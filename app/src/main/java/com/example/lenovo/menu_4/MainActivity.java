package com.example.lenovo.menu_4;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final boolean TODO = false;
    String names[] = {"Sahil", "Dhruv", "Pawan", "Ashok"};
    String contact[] = {"8115038882", "9978456321", "7856903412", "9915223004"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomList customList = new CustomList(this, names, contact);

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(customList);


        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String number;
        number = (String) listView.getItemAtPosition((info.position));

        if (item.getTitle() == "Call") {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + number));


                               startActivity(callIntent);





               }
        else if(item.getTitle()=="SMS"){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
        }else{
            return false;
        }
        return true;
    }
}
