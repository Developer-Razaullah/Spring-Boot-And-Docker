package com.docker.helloworldimage.service;

import com.docker.helloworldimage.model.HelloWorld;

public interface HelloWorldService {
    HelloWorld getMessage(String header);
    HelloWorld getMessages(String header, String message);
}
