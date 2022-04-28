package com.guitarrascustom.util;

public enum EnumTimeOut {

    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    TWELVE(12),
    SIXTEEN(16);


    private final int value;

    EnumTimeOut(int value) {
        this.value = value;
    }

    public int getValue() {

        return value;
    }
}
