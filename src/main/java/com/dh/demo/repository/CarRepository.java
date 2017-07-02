package com.dh.demo.repository;

import com.dh.demo.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Juan Zapata on 6/18/2017.
 */
public interface CarRepository extends MongoRepository<Car,String>{
}
