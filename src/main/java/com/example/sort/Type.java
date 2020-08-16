package com.example.sort;

public enum Type {
    ALL("all"),
    ANY("any"),
    NONE("none");

    private String name;

    Type(String name) {
        this.name = name;
    }
}
