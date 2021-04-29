package com.example.demo.springBoot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MotorController {

    @Autowired
    MotorRepository repo;

    @Autowired
    private HttpSession session;


    @PostMapping("/login")
    public boolean login(Bruker bruker){
        if(repo.sjekkBruker(bruker)){
            session.setAttribute("Innlogget", bruker);
            return true;
        }
        return false;
    }

    @GetMapping("/validate")
    public boolean validateUser() {
        return session.getAttribute("Innlogget")!=null;
    }

    @GetMapping("/innlogget")
    public boolean hentInnlogget (HttpServletResponse res) throws IOException {
        if(session.getAttribute("Innlogget")!=null){
            return true;
        }
        res.sendError(HttpStatus.NOT_FOUND.value());
        return false;
    }

    private boolean valider(MotorEier motorvogn) {
        boolean valid = true;

        if (!motorvogn.getPersNr().matches("[0-9]{11}")) {
            valid = false;
        } else if (!motorvogn.getNavn().toUpperCase().matches("[A-ZÆØÅ\\-. ]{3,30}")) {
            valid = false;
        } else if (!motorvogn.getAdresse().toUpperCase().matches("[A-ZÆØÅ,0-9\\-. ]{3,40}")) {
            valid = false;
        } else if (!motorvogn.getKjennetegn().toUpperCase().matches("[A-Z]{2}[1-9][0-9]{4}")) {
            valid = false;
        }
        return valid;
    }

    @PostMapping("/logout")
    public void logout() {
        session.removeAttribute("Innlogget");
    }

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
        if ((session.getAttribute("Innlogget") == null)) {
            res.sendError(403, "Du må logge inn for å laste opp motorvogn");
            return;
        }
        boolean ok = valider(innEier) && repo.lagreBileier(innEier);
        if (!ok) {
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Det skjedde en feil, prøv igjen senere eller kontroller inputene");
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
        if ((session.getAttribute("Innlogget") == null)) {
            res.sendError(403, "Du må logge inn for å laste opp motorvogn");
            return;
        }
        boolean ok = repo.slettAlle();
        if(!ok){
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Det skjedde en feil, prøv igjen senere");
        }
    }

    @GetMapping("/slettEn")
    public void slettEn(String id, HttpServletResponse res) throws IOException {
        if ((session.getAttribute("Innlogget") == null)) {
            res.sendError(403, "Du må logge inn for å laste opp motorvogn");
            return;
        }
        boolean ok = repo.slettEn(id);
        if(!ok) {
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Det skjedde en feil, prøv igjen senere");
        }
    }

    @PostMapping("/redigerEn")
    public void redigerEn(MotorEier innEier, HttpServletResponse res) throws IOException{
        if ((session.getAttribute("Innlogget") == null)) {
            res.sendError(403, "Du må logge inn for å laste opp motorvogn");
            return;
        }
        boolean ok = valider(innEier) && repo.redigerEn(innEier);
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
