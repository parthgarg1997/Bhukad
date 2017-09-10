package com.example.parth.bhukad;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static Database_handler database_handler;
    ArrayList<String> food_names;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        database_handler=new Database_handler(this,null,null,1);

    }

    @Override
    protected void onPostResume() {

        super.onPostResume();
        food_names=database_handler.queryToArrayList();
         listView=(ListView)findViewById(R.id.food_list_view);
        ListAdapter adapter=new custom_list_view_brain(this,food_names);
        listView.setAdapter(adapter);
        listView.setBackgroundColor(Color.BLUE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout layout =(RelativeLayout)findViewById(R.id.content_main);
        switch (item.getItemId()){
            case R.id.add_menu:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i=new Intent(this,adders.class);
                startActivity(i);
                return true;
            case R.id.delete_menu:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent j=new Intent(this,delete.class);
                startActivity(j);
                return true;
            case R.id.displayer:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent k=new Intent(this,show_total_food.class);
                startActivity(k);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void Adder_function(View view) {
        ArrayList<Integer> store_update;
        store_update=custom_list_view_brain.store_data;
        database_handler.update_database(store_update,food_names);
        onPostResume();
    }
    public void Cleaner_function(View view)
    {
        onPostResume();
    }
}
