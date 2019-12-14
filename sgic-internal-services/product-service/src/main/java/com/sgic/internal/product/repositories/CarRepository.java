package com.sgic.internal.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sgic.internal.product.entities.Car;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car>{

	
}
