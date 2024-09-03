package com.docker.helloworldimage.service;

import com.docker.helloworldimage.model.HelloWorld;
import com.docker.helloworldimage.model.Technology;

public interface CommonService {
    HelloWorld getMessage(String header);
    HelloWorld getMessages(String header, String message);
    Technology getTech(Technology technology);

    HelloWorld getData(int id);
}
