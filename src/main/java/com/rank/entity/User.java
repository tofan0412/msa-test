package com.rank.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
public class User {

    private Long id;

    private String name;

    private Date birth;

    private String gender;

    private Date createdTime;

    public User(Long id, String name, Date birth, String gender) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
    }
}
