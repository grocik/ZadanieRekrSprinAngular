package com.zadanie.zadanierek.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PingController {

    //ping pong
    @GetMapping("/status/ping")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("pong");
    }
}
