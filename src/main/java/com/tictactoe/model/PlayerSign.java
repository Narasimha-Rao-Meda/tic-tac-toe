package com.tictactoe.model;

public abstract class PlayerSign {
    private final String name;
    private final SignType signType;

    public PlayerSign(SignType signType, String name) {
        this.signType = signType;
        this.name = name;
    }

    public SignType getSignType() {
        return this.signType;
    }

    public String getName() {
        return this.name;
    }
}
