package co.develhope.FirstAPI.controllers;

import co.develhope.FirstAPI.DTOs.CarDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    /**
     * Ex Primi Passi - First API - 05
     * write a Spring Boot application with the necessary dependencies that has:
     * has a DTO called CarDTO with the following properties:
     * a string id (mandatory)
     * a string modelName (mandatory)
     * a double price
     * a CarController that:
     * is mapped on cars
     * on a GET request returns a new Car as response
     * on a POST request prints the Car body in console and returns an HTTP Created success message to the user
     * takes care of the request body validation
     */

    List<CarDTO> carsList = new ArrayList<>();

    @GetMapping
    public CarDTO getNewCar(@Valid @RequestBody CarDTO car){
        return car;
    }

    @PostMapping("/create-car")
    @ResponseBody
    public String createCar(@RequestParam String id, @RequestParam String modelName,
                          @RequestParam (required = false) double price){
        CarDTO newCar = new CarDTO(id, modelName, price);
        carsList.add(newCar);
        for (CarDTO car: carsList){
            System.out.println(id + " " + modelName);
        } return "A new car has been successfully created";
    }
}
