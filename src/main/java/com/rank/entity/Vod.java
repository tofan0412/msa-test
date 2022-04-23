package com.rank.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
public class Vod {

    @Column(name = "vod_id")
    @GeneratedValue
    @Id
    private Long id;

    private String title;

    private String director;

    private Date playdate;

    private int price;

    private String thumbnailUrl;

    private String info;

    private Date createdTime;

}
