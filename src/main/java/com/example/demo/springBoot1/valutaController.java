package com.example.demo.springBoot1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class valutaController {

    ArrayList<Valuta> valutaArray = new ArrayList<Valuta>();

    @GetMapping("/load")
    public void start(){
        Valuta eur = new Valuta("EUR", 10.25);
        Valuta usd = new Valuta("USD", 8.48);
        Valuta pkr = new Valuta("PKR", 0.05);
        valutaArray.add(eur);
        valutaArray.add(usd);
        valutaArray.add(pkr);
    }

    @GetMapping("/calc")
    public Double calculate(Valuta valuta){
        for(Valuta v : valutaArray){
            if(valuta.getName().equalsIgnoreCase(v.getName())){
                return valuta.getValue()*v.getValue();
            }
        }
        return null;
    }
}