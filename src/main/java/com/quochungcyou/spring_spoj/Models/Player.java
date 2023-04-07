package com.quochungcyou.spring_spoj.Models;

import java.io.Serializable;

public class Player implements Serializable {
    String name;
    String username;
    Integer score;
    Integer rank;
    Integer target;

    public Player(Integer rank, String name, String username, Integer score, Integer target) {
        this.rank = rank;
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
}
