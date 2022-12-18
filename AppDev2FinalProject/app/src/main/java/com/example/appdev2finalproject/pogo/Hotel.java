package com.example.appdev2finalproject.pogo;

import java.io.Serializable;
import java.util.HashMap;

public class Hotel implements Serializable {

    String name;
    String hotelDesc;
    int price;
    int img;

    public Hotel(String name, String hotelDesc, int price, int img) {
        this.name = name;
        this.hotelDesc = hotelDesc;
        this.price = price;
        this.img = img;
    }
}
