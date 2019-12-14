package com.sgic.internal.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.product.entities.Car;
import com.sgic.internal.product.repositories.CarRepository;
import com.sipios.springsearch.anotation.SearchSpec;

@RestController
public class CarController {

	@Autowired
	private CarRepository carRepository;

//    public CarController(CarRepository carRepository) {
//        this.carRepository = carRepository;
//    }

	@GetMapping("/cars")
	public ResponseEntity<List<Car>> searchForCars(@SearchSpec Specification<Car> specs) {
		return new ResponseEntity<>(carRepository.findAll(Specification.where(specs)), 
				HttpStatus.OK);
	}
}
