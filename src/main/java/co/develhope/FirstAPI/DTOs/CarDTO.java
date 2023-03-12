package co.develhope.FirstAPI.DTOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class CarDTO {

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

    @NotBlank (message = "Mandatory")
    private String id;

    @NotBlank (message = "Mandatory")
    private String modelName;

    private double price;

    public CarDTO() {
    }

    //se ci metto @Autowired non funziona più!!!
    public CarDTO(String id, String modelName, double price) {
        this.id = id;
        this.modelName = modelName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
