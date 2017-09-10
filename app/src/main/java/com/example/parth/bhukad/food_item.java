package com.example.parth.bhukad;

/**
 * Created by Parth on 1/10/2017.
 */

public class food_item {
    int _id;
    String _foodName;
    int _Total_Quantity;

    public food_item(String _foodName, int _Total_Quantity) {
        this._foodName = _foodName;
        this._Total_Quantity = _Total_Quantity;
    }

    public int get_id() {
        return _id;
    }

    public int get_Total_Quantity() {
        return _Total_Quantity;
    }

    public String get_foodName() {
        return _foodName;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_Total_Quantity(int _Total_Quantity) {
        this._Total_Quantity = _Total_Quantity;
    }

    public void set_foodName(String _foodName) {
        this._foodName = _foodName;
    }
}
