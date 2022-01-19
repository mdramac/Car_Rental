package it.htl.steyr.car_rental.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, String> {

}
