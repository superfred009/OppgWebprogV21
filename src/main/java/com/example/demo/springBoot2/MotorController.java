package com.example.demo.springBoot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MotorController {

    @Autowired
    MotorRepository repo;

    @GetMapping("/hentBiler")
    public List<Bil> hentBiler(HttpServletResponse res) throws IOException {
        List<Bil> biler = repo.hentBiler();
        if (biler == null) {
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Det skjedde en feil, prøv igjen senere");
        }
        return biler;
    }

    @PostMapping("/lagre")
    public void lagreEier(MotorEier innEier, HttpServletResponse res) throws IOException {
        boolean ok = repo.lagreBileier(innEier);
        if (!ok) {
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Det skjedde en feil, prøv igjen senere");
        }
    }

    @GetMapping("/hent")
    public List<MotorEier> hentEiere(HttpServletResponse res) throws IOException {
        List<MotorEier> motoreiere = repo.hentMotorEiere();
        if (motoreiere == null) {
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Det skjedde en feil, prøv igjen senere");
        }
        return motoreiere;
    }

    @PostMapping("/slett")
    public void slette(HttpServletResponse res) throws IOException {
        boolean ok = repo.slettAlle();
        if(!ok){
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Det skjedde en feil, prøv igjen senere");
        }
    }

    @GetMapping("/slettEn")
    public void slettEn(String id, HttpServletResponse res) throws IOException {
        boolean ok = repo.slettEn(id);
        if(!ok) {
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Det skjedde en feil, prøv igjen senere");
        }
    }

    @PostMapping("/redigerEn")
    public void redigerEn(MotorEier innEier, HttpServletResponse res) throws IOException{
        boolean ok = repo.redigerEn(innEier);
        if (!ok) {
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Det skjedde en feil, prøv igjen senere");
        }

    }

    @GetMapping("/hentEn")
    public MotorEier hentEnMotorvogn(int id, HttpServletResponse res) throws IOException {
        MotorEier enEier = repo.hentEnMotorvogn(id);
        if (enEier == null) {
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Det skjedde en feil, prøv igjen senere");
        }
        return enEier;
    }

}
