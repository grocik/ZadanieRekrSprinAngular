package com.zadanie.zadanierek.Models;

import java.util.List;

public class SortedNumbersResponseModel {
    private List<Integer> numbers;

    public SortedNumbersResponseModel(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
