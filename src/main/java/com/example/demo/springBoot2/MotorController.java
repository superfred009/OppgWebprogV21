package com.example.demo.springBoot2;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MotorController {

    public final List<MotorEier> alleEiere = new ArrayList<>();

    @PostMapping("/lagre")
    public void lagreEier(MotorEier innEier) {
        alleEiere.add(innEier);
    }

    @GetMapping("/hent")
    public List<MotorEier> hent() {
        return alleEiere;
    }

    @PostMapping("/slett")
    public void slette() {
        alleEiere.clear();
    }
}
