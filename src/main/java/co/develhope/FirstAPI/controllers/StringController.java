package co.develhope.FirstAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

    /**
     * a StringController that:
     * is mapped on strings
     * returns the concatenation of 2 strings (the first is mandatory, the second is not) params
     * handle the case where the second string is null (we want to return just the first string)
     */

    @GetMapping("/strings")
    public String concatStrings(@RequestParam String firstString,
                                @RequestParam (required = false) String secondString){
        if (secondString == null){
            return firstString;
        } else {
            return (firstString + " " + secondString);
        }
    }

}
