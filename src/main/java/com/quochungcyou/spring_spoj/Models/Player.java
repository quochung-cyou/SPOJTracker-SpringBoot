package com.quochungcyou.spring_spoj.Models;

import java.io.Serializable;

public class Player implements Serializable {

    String name;
    String username;
    Integer score;

    Integer id;
    Integer target;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    String urlimage;

    public Player(Integer id, String name, String username, Integer score, Integer target) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.score = score;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setRank(Integer id) {
        this.id = id;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
}
