package com.example.demo.springBoot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Start implements CommandLineRunner {
    @Autowired
    MotorRepository repo;

    @Override
    public void run(String[] args) throws Exception {
        Bruker admin = new Bruker("Admin", "AdminPassord123");
        repo.lagreBruker(admin);
    }
}
