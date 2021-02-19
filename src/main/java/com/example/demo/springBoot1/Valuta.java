package com.example.demo.springBoot1;

public class Valuta {
    private String name;
    private Double value;

    public Valuta (String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public Valuta(){}

    public Double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
