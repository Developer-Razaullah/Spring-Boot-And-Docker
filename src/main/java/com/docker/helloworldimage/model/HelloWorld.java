package com.docker.helloworldimage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorld {
    private String header;
    private List<String> message;
}
