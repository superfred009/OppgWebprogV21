package com.example.demo.springBoot2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorRepository {

    private Logger logger = LoggerFactory.getLogger(MotorRepository.class);

    @Autowired
    private JdbcTemplate db;

    public boolean sjekkBruker (Bruker bruker){
        String sql =  "SELECT COUNT(*) FROM Brukere WHERE brukernavn=? AND passord=?";
        try {
            int antall = db.queryForObject(sql, Integer.class, bruker.getBrukernavn(), bruker.getPassord());
            if (antall>0){
                return true;
            }
            return false;
        } catch (Exception e) {
            logger.error("Feil i sjekkBruker : "+e);
            return false;
        }
    }

    public boolean lagreBileier(MotorEier motorEier) {
        String sql = "INSERT INTO Motoreier(persNr, navn, adresse, kjennetegn, bilmerke, biltype) VALUES(?,?,?,?,?,?)";
        try {
            db.update(sql, motorEier.getPersNr(), motorEier.getNavn(), motorEier.getAdresse(), motorEier.getKjennetegn(), motorEier.getBilmerke(), motorEier.getBiltype());
            return true;
        } catch (Exception e) {
            logger.error("Kunne ikke lagre motorvogn" + e);
            return false;
        }
    }

    public List<MotorEier> hentMotorEiere() {
        String sql = "SELECT * FROM Motoreier";
        try {
            List<MotorEier> alleEiere = db.query(sql, new BeanPropertyRowMapper(MotorEier.class));
            return alleEiere;
        } catch (Exception e) {
            logger.error("Kunne ikke hente motorvogner" + e);
            return null;
        }
    }

    public List<Bil> hentBiler(){
        String sql = "SELECT * FROM Bil";
        try {
            List<Bil> alleBiler = db.query(sql, new BeanPropertyRowMapper(Bil.class));
            return alleBiler;
        } catch (Exception e) {
            logger.error("Kunne ikke hente biler" + e);
            return null;
        }

    }

    public boolean slettAlle() {
        String sql = "DELETE FROM Motoreier";
        try {
            db.update(sql);
            return true;
        } catch (Exception e) {
            logger.error("Kunne ikke slette alle");
            return false;
        }
    }

    public boolean slettEn(String id){
        String sql = "DELETE FROM Motoreier WHERE id=?;";
        try {
            db.update(sql, id);
            return true;
        } catch (Exception e){
            logger.error("Kunne ikke slette en");
            return false;
        }

    }

    public boolean redigerEn(MotorEier motorEier){
        String sql = "UPDATE Motoreier SET persNr = ?, navn = ?, adresse = ?, kjennetegn = ?, bilmerke = ?, biltype = ? WHERE id=?;";
        try {
            db.update(sql, motorEier.getPersNr(), motorEier.getAdresse(), motorEier.getNavn(), motorEier.getKjennetegn(), motorEier.getBilmerke(), motorEier.getBiltype(), motorEier.getId());
            return true;
        } catch (Exception e){
            logger.error("Kunne ikke redigere motorvognen");
            return false;
        }


    }

    public MotorEier hentEnMotorvogn(int id) {
        String sql = "SELECT * FROM Motoreier WHERE id = ?";
        try {
            List<MotorEier> enMotorvogn = db.query(sql, new BeanPropertyRowMapper(MotorEier.class), id);
            return enMotorvogn.get(0);
        } catch (Exception e) {
            logger.error("Kunne ikke hente motorvognen");
            return null;
        }
    }
}