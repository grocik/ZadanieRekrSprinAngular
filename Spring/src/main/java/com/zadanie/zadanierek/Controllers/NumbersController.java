package com.zadanie.zadanierek.Controllers;
import com.zadanie.zadanierek.Models.NumbersModel;
import com.zadanie.zadanierek.Models.SortedNumbersResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController
public class NumbersController {

    @PostMapping("/numbers/sort-command")
    public ResponseEntity<SortedNumbersResponseModel> sortNumbers(@RequestBody NumbersModel request) {
        List<Integer> numbers = request.getNumbers();
        String order = request.getOrder();

        // jeżeli order null
        if (!"ASC".equals(order) && !"DESC".equals(order)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // sortowanie
        if ("ASC".equals(order)) {
            numbers.sort(Comparator.naturalOrder());
        } else {
            numbers.sort(Comparator.reverseOrder());
        }
        System.out.println(numbers);
        // Zwracamy posortowane liczby
        return new ResponseEntity<SortedNumbersResponseModel>(
                new SortedNumbersResponseModel(numbers),HttpStatus.OK);

    }
}
