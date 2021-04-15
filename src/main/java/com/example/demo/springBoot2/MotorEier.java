package com.example.demo.springBoot2;

public class MotorEier {
    private String id;
    private String persNr;
    private String navn;
    private String adresse;
    private String kjennetegn;
    private String bilmerke;
    private String biltype;

    public MotorEier (String id, String persNr, String navn, String adresse, String kjennetegn, String bilmerke, String biltype) {
        this.id = id;
        this.persNr = persNr;
        this.navn = navn;
        this.adresse = adresse;
        this.kjennetegn = kjennetegn;
        this.bilmerke = bilmerke;
        this.biltype = biltype;
    }

    public MotorEier(){

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getPersNr() {
        return persNr;
    }
    public void setPersNr(String persNr) {
        this.persNr = persNr;
    }

    public String getKjennetegn() {
        return kjennetegn;
    }
    public void setKjennetegn(String kjennetegn) {
        this.kjennetegn = kjennetegn;
    }

    public String getBilmerke() {
        return bilmerke;
    }
    public void setBilmerke(String bilmerke) {
        this.bilmerke = bilmerke;
    }

    public String getBiltype() {
        return biltype;
    }
    public void setBiltype(String biltype) {
        this.biltype = biltype;
    }
}
