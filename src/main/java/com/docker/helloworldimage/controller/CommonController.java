package com.docker.helloworldimage.controller;

import com.docker.helloworldimage.model.HelloWorld;
import com.docker.helloworldimage.model.Technology;
import com.docker.helloworldimage.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CommonController {

    @Autowired
    private CommonService service;

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

    @PostMapping("/add/tech")
    public ResponseEntity<?> addTech(@RequestBody Technology tech) {
        if (tech.getId() <= 0 || tech.getName() == null || tech.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid technology data provided. May be Id or name is null");
        }
        Technology addedTech = service.getTech(tech);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedTech);
    }

}
