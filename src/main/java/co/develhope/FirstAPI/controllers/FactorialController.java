package co.develhope.FirstAPI.controllers;

import co.develhope.FirstAPI.Tools.MathTools;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {
    /**
     * a FactorialController where you map factorial in order to:
     * reply with the factorial of the n path variable passed with the GET request
     */

    @GetMapping("/factorial/{n}")
    public int getFactorial(@PathVariable int n){
        return MathTools.factorial(n);
    }

}
