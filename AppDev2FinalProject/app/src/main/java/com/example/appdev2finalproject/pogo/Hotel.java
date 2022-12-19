package com.example.appdev2finalproject.pogo;

import java.io.Serializable;
import java.util.HashMap;

public class Hotel implements Serializable {

    public String name;
    public String hotelDesc;
    public int price;
//    int img;

    public Hotel(String name, String hotelDesc, int price) {
        this.name = name;
        this.hotelDesc = hotelDesc;
        this.price = price;
    }
}
