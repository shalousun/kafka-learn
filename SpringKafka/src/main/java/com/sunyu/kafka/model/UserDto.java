package com.sunyu.kafka.model;

import java.io.Serializable;

/**
 * Created by yu on 2017/6/17.
 */
public class UserDto implements Serializable{

    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
