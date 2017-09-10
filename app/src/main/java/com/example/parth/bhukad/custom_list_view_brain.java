package com.example.parth.bhukad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.data;

/**
 * Created by Parth on 1/11/2017.
 */

public class custom_list_view_brain extends ArrayAdapter<String> {
    public static ArrayList<Integer> store_data;
    public custom_list_view_brain(Context context, ArrayList<String> food_name) {
        super(context,R.layout.cusomt_list_view,food_name);
         store_data=new ArrayList<Integer>();
        for(int i=0;i<getCount();i++)
            store_data.add(0);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater Parth_inflate = LayoutInflater.from(getContext());
        View custom_view=Parth_inflate.inflate(R.layout.cusomt_list_view,parent,false);


         final TextView no_items_display=(TextView) custom_view.findViewById(R.id.quantity_shower);
        TextView Item_name=(TextView)custom_view.findViewById(R.id.food_name_shower);
        Button Add_button=(Button)custom_view.findViewById(R.id.button4);
        Button Subtract_button=(Button)custom_view.findViewById(R.id.button5);


        String food_name=getItem(position);
        Item_name.setText(food_name);
        no_items_display.setText(""+store_data.get(position));
        final int[] no_items = {store_data.get(position)};
        Add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no_items[0]++;
                no_items_display.setText(""+ no_items[0]);
                store_data.set(position,no_items[0]);
            }
        });

        Subtract_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(no_items[0] >0)
                    no_items[0]--;
                no_items_display.setText(""+ no_items[0]);
                store_data.set(position,no_items[0]);
            }
        });
        return custom_view;
    }
    public ArrayList<Integer> return_update()
    {
        return store_data;
    }


}
