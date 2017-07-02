package com.dh.demo.web;

import com.dh.demo.domain.Car;
import com.dh.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Juan Zapata on 6/18/2017.
 */
@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getAll(){
        return carService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCar(@RequestBody CarRequestDTO car){
        carService.addCar(car);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public void updateCar(@RequestBody Car car){
        carService.update(car);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeCar(@RequestBody String id){
        Car car = carService.getByID(id);
        carService.removeCar(car);
    }

    public static class CarRequestDTO{
        private String model;
        private int year;
        private String brand;
        private String color;
        private String image;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
