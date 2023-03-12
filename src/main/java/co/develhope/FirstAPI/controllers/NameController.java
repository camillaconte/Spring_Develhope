package co.develhope.FirstAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    /**
     * NameController where you map name in order to:
     * reply with your name to a GET request
     * reply with your reversed name (e.g. from John to nhoJ, using StringBuilder) to a POST request
     */

    @GetMapping("/name")
    public String getName(){
        return "SpiderMan";
    }

    @PostMapping("/name")
    public String setReverseName(@RequestParam (required = true) String name){
        StringBuilder str = new StringBuilder(name);
        return ("Hi, my name is " + str.reverse());
    }

    //Example: for input "SuperPippo" output is "Hi, my name is oppiPrepuS"
}
