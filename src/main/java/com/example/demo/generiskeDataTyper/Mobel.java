package com.example.demo.generiskeDataTyper;

public class Mobel {
    private String navn;
    private String type;
    private double vekt;
    private double pris;
    private int nummer;

    public Mobel(String navn, String type, double vekt, double pris, int nummer) {
        this.navn = navn;
        this.type = type;
        this.vekt = vekt;
        this.pris = pris;
        this.nummer = nummer;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVekt(double vekt) {
        this.vekt = vekt;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getNavn() {
        return navn;
    }

    public String getType() {
        return type;
    }

    public double getVekt() {
        return vekt;
    }

    public double getPris() {
        return pris;
    }

    public int getNummer() {
        return nummer;
    }

    @Override
    public String toString(){
        return "blabla";
    }
}
