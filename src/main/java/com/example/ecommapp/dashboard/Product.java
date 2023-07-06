package com.example.ecommapp.dashboard;

public class Product {
    private String name;
    private String details;
    private double priceUnit;

    public Product(String name, String details, double priceUnit) {
        this.name = name;
        this.details = details;
        this.priceUnit = priceUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }
}
