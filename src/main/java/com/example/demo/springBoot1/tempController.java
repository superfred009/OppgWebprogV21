package com.example.demo.springBoot1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tempController {

    private final Integer[] tempArray = new Integer[]{-3,-2,2,7,12,16,18,17,12,7,3,-2};

    @GetMapping("/hentTemp")
    public int hentTemp(String innMaaned) {

        int utTemp;

        switch (innMaaned.toLowerCase()) {
            case "januar" : utTemp = tempArray[0];
                break;
            case "februar" : utTemp = tempArray[1];
                break;
            case "mars" : utTemp = tempArray[2];
                break;
            case "april" : utTemp = tempArray[3];
                break;
            case "mai" : utTemp = tempArray[4];
                break;
            case "juni" : utTemp = tempArray[5];
                break;
            case "juli" : utTemp = tempArray[6];
                break;
            case "august" : utTemp = tempArray[7];
                break;
            case "september" : utTemp = tempArray[8];
                break;
            case "oktober" : utTemp = tempArray[9];
                break;
            case "november" : utTemp = tempArray[10];
                break;
            case "desember" : utTemp = tempArray[11];
                break;
            default : utTemp = 0;
        }
        return utTemp;
    }
}
