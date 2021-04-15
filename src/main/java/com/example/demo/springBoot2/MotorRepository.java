package com.example.demo.springBoot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreBileier(MotorEier motorEier) {
        String sql = "INSERT INTO Motoreier(persNr, navn, adresse, kjennetegn, bilmerke, biltype) VALUES(?,?,?,?,?,?)";
        db.update(sql, motorEier.getPersNr(), motorEier.getNavn(), motorEier.getAdresse(), motorEier.getKjennetegn(), motorEier.getBilmerke(), motorEier.getBiltype());
    }

    public List<MotorEier> hentMotorEiere() {
        String sql = "SELECT * FROM Motoreier";
        List<MotorEier> alleEiere = db.query(sql, new BeanPropertyRowMapper(MotorEier.class));
        return alleEiere;
    }

    public List<Bil> hentBiler(){
        String sql = "SELECT * FROM Bil";
        List<Bil> alleBiler = db.query(sql, new BeanPropertyRowMapper(Bil.class));
        return alleBiler;
    }

    public void slettAlle() {
        String sql = "DELETE FROM Motoreier";
        db.update(sql);
    }

    public void slettEn(String id){
        String sql = "DELETE FROM Motoreier WHERE id=?;";
        db.update(sql, id);
    }

    public void redigerEn(MotorEier motorEier){
        String sql = "UPDATE Motoreier SET persNr = ?, navn = ?, adresse = ?, kjennetegn = ?, bilmerke = ?, biltype = ? WHERE id=?;";
        db.update(sql, motorEier.getPersNr(), motorEier.getAdresse(), motorEier.getNavn(), motorEier.getKjennetegn(), motorEier.getBilmerke(), motorEier.getBiltype());
    }
}