package com.power.bootlaunch.model.yml;

import lombok.Data;

import java.util.List;

@Data
public class Child {
    private String name;
    private Integer age;
    private List<Friend> friends;
}