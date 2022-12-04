package ru.netology;

import java.util.SplittableRandom;

public class Smartphone extends Product{


    private String vendor;

    public String getVendor() {
        return vendor;
    }

    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.vendor = vendor;

    }


}
