package com.dh.demo.service;

import com.dh.demo.domain.Car;
import com.dh.demo.repository.CarRepository;
import com.dh.demo.web.CarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Zapata on 6/18/2017.
 */
@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> getAll(){
        return carRepository.findAll();
    }

    public void addCar(CarController.CarRequestDTO carDTO){
        Car car = new Car();

        car.setBrand(carDTO.getBrand());
        car.setColor(carDTO.getColor());
        car.setImage(carDTO.getImage());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());

        carRepository.save(car);
    }

    public void removeCar(Car car){
        carRepository.delete(car);
    }

    public void update(Car car){
        carRepository.save(car);
    }

    public Car getByID(String id){
        return carRepository.findOne(id);
    }
}
