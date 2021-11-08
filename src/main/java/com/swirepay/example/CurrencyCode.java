package com.swirepay.example;

public enum CurrencyCode {

    USD(1), INR(2), CAD (41), QAR(179);

    private int value;

    CurrencyCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
