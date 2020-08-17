package com.example.search;

public enum Type {
    ALL("all"),
    ANY("any"),
    NONE("none");

    private String name;

    Type(String name) {
        this.name = name;
    }
}
