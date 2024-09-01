package com.docker.helloworldimage.service;

import com.docker.helloworldimage.model.HelloWorld;
import com.docker.helloworldimage.model.Technology;
import com.docker.helloworldimage.repository.HelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private HelloWorldRepository repository;

    @Override
    public HelloWorld getMessage(String header) {
        List<com.docker.helloworldimage.entity.HelloWorld> helloWorld = repository.findAll();
        HelloWorld data = new HelloWorld();
        data.setHeader(header);
        List<String> message = helloWorld.stream()
                .map(com.docker.helloworldimage.entity.HelloWorld::getMessage)
                .toList();
        data.setMessage(message);

        return data;
    }

    @Override
    public HelloWorld getMessages(String header, String message) {
        com.docker.helloworldimage.entity.HelloWorld helloWorld = new com.docker.helloworldimage.entity.HelloWorld();
        helloWorld.setMessage(message);
        repository.save(helloWorld);
        return new HelloWorld(header, Collections.singletonList(message));
    }

    @Override
    public Technology getTech(Technology technology) {
        return technology;
    }
}
