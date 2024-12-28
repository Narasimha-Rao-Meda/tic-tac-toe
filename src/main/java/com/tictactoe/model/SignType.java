package com.tictactoe.model;

public enum SignType {
    CROSS("X"),
    ROUND("O");

    private final String value;
    SignType(String value) {
        this.value = value;
    }

}
