package com.example.dit;

import java.util.*;

public class Shop {

    private double latitude;
    private double longitude;
    public String name;
    private double radius;
    // This is used to search the shops in O(1) time complexity and log(n) worst case
    public static Map<String, Shop> allShops =  new HashMap<String, Shop>();

    public Shop(double latitude, double longitude, String name, double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.radius = radius;
    }
//    every shop have a name and radius of delivery i.e Use Case 2
    public static Shop createShop(String name, double latitude, double longitude, double radius){
        Shop shop = new Shop(latitude,longitude,name,radius);
        allShops.put(name,shop);
        return shop;
    }

    public static Shop searchShop(String name){
        return allShops.get(name);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", name='" + name + '\'' +
                ", radius=" + radius +
                '}';
    }
}
