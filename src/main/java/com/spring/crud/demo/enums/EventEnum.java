package com.spring.crud.demo.enums;

public enum EventEnum {

    BEGIN_GAME("begin-game"),
    GOAL("goal"),
    INTERVAL("interval"),
    ADD_TIME("add-time"),
    REPLACEMENT("replacement"),
    WARNING("warning"),
    END_GAME("end-game");

    private String description;

    EventEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}