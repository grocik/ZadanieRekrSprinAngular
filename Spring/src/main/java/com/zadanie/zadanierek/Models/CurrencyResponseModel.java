package com.zadanie.zadanierek.Models;

public class CurrencyResponseModel {
    private double value;

    public CurrencyResponseModel(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
