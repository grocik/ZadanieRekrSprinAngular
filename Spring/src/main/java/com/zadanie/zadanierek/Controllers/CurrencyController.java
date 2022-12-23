package com.zadanie.zadanierek.Controllers;

import com.zadanie.zadanierek.Models.Currency.Rate;
import com.zadanie.zadanierek.Models.Currency.Root;
import com.zadanie.zadanierek.Models.CurrencyResponseModel;
import com.zadanie.zadanierek.Models.CurrencyValueModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {
    @PostMapping("/get-current-currency-value-command")
    public ResponseEntity<CurrencyResponseModel> getCurrentCurrencyValue(@RequestBody CurrencyValueModel request){
        String currencyCode = request.getCurrency();

        String url = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";

        RestTemplate restTemplate = new RestTemplate();
        Root[] root = restTemplate.getForObject(url, Root[].class);

        // search for match
        for (Root rooot: root ) {
            for (Rate rate: rooot.getRates()) {
                if (rate.getCode().matches(currencyCode)){
                    return new ResponseEntity<CurrencyResponseModel>(
                            new CurrencyResponseModel(rate.mid),
                            HttpStatus.OK);
                }
            };
        }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }