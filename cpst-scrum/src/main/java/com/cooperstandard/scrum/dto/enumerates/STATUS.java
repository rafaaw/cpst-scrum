package com.cooperstandard.scrum.dto.enumerates;

public enum STATUS {

    OPENED(0), CLOSED(1);

    private int value;

    STATUS(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
