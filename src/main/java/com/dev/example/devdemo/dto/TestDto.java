package com.dev.example.devdemo.dto;

public class TestDto {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    private TestDto() {
//        throw new IllegalStateException();
//    }

    public static class AddTestParam {
        private String id;
        private String name;
    }

}