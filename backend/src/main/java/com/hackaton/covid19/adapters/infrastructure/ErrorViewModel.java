package com.hackaton.covid19.adapters.infrastructure;

public class ErrorViewModel {
    private String message;

    public ErrorViewModel(String message) {
        this.message = message;
    }

    public ErrorViewModel() {
    }

    public String getMessage() {
        return message;
    }
}
