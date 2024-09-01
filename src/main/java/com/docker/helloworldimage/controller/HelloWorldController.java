package com.docker.helloworldimage.controller;

import com.docker.helloworldimage.model.HelloWorld;
import com.docker.helloworldimage.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    @Autowired
    private HelloWorldService service;

    @GetMapping("message")
    public String getMessage() {
        return "Hello World";
    }

    @GetMapping("/list/message")
    public ResponseEntity<HelloWorld> addMessage(@RequestParam("X-Request-Id") String header) {
        return new ResponseEntity<>(service.getMessage(header), HttpStatus.OK);
    }

    @PostMapping("/add/message")
    public ResponseEntity<HelloWorld> add(@RequestParam("X-Request-Id") String header, @RequestParam("data") String message) {
        return new ResponseEntity<>(service.getMessages(header,message), HttpStatus.CREATED);
    }
}
