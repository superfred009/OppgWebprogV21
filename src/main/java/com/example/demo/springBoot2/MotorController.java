package com.example.demo.springBoot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MotorController {

    @Autowired
    MotorRepository repo;

    public final List<Bil> bilRegister = new ArrayList<>();


    @GetMapping("/hentBiler")
    public List<Bil> hentBiler() {
        return repo.hentBiler();
    }

    @PostMapping("/lagre")
    public void lagreEier(MotorEier innEier) {
        repo.lagreBileier(innEier);
    }

    @GetMapping("/hent")
    public List<MotorEier> hentEiere() {
        return repo.hentMotorEiere();
    }

    @PostMapping("/slett")
    public void slette() {
        repo.slettAlle();
    }

    @GetMapping("/slettEn")
    public void slettEn(String id){
        repo.slettEn(id);
    }

    @PostMapping("/redigerEn")
    public void redigerEn(MotorEier innEier){
        repo.redigerEn(innEier);
    }

    @GetMapping("/hentEn")
    public MotorEier hentEnMotorvogn(int id) {
        return repo.hentEnMotorvogn(id);
    }

}
