package com.zadanie.zadanierek.Models.Currency;

import java.util.ArrayList;

public class Root{
    public String table;
    public String no;
    public String effectiveDate;
    public ArrayList<Rate> rates;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }

    public void setRates(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
