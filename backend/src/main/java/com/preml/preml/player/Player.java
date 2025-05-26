package com.preml.preml.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_statistics")
public class Player {

    @Id
    @Column(name = "name", unique = true)
    private String name;
    private String country;
    private String position;
    private Integer age;
    @Column(name = "matchesplayed")
    private Integer mp;
    private Integer starts;
    @Column(name = "minplayed")

    private Double min;
    private Double goals;
    private Double assists;
    @Column(name = "penscored")

    private Double penaltyKicks;
    @Column(name = "yellowcards")

    private Double yellowCards;
    @Column(name = "redcards")

    private Double redCards;
    @Column(name = "expectedgoals")

    private Double expectedGoals;
    @Column(name = "expectedassists")

    private Double expectedAssists;
    private String team;


    public Player(String name, String country, String position, Integer age, Integer mp, Integer starts, Double min, Double goals, Double assists, Double penaltyKicks, Double yellowCards, Double redCards, Double expectedGoals, Double expectedAssists, String team) {
        this.name = name;
        this.country = country;
        this.position = position;
        this.age = age;
        this.mp = mp;
        this.starts = starts;
        this.min = min;
        this.goals = goals;
        this.assists = assists;
        this.penaltyKicks = penaltyKicks;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.expectedGoals = expectedGoals;
        this.expectedAssists = expectedAssists;
        this.team = team;
    }

    public Player() {

    }
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getGoals() {
        return goals;
    }

    public void setGoals(Double goals) {
        this.goals = goals;
    }

    public Double getAssists() {
        return assists;
    }

    public void setAssists(Double assists) {
        this.assists = assists;
    }

    public Double getPenaltyKicks() {
        return penaltyKicks;
    }

    public void setPenaltyKicks(Double penaltyKicks) {
        this.penaltyKicks = penaltyKicks;
    }

    public Double getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Double yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Double getRedCards() {
        return redCards;
    }

    public void setRedCards(Double redCards) {
        this.redCards = redCards;
    }

    public Double getExpectedGoals() {
        return expectedGoals;
    }

    public void setExpectedGoals(Double expectedGoals) {
        this.expectedGoals = expectedGoals;
    }

    public Double getExpectedAssists() {
        return expectedAssists;
    }

    public void setExpectedAssists(Double expectedAssists) {
        this.expectedAssists = expectedAssists;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
