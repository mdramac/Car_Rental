package it.htl.steyr.car_rental.controller;

import it.htl.steyr.car_rental.model.*;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

public class Controller {

    public ListView<Car> carSelection;
    public DatePicker startRental;
    public DatePicker stopRental;
    public ListView<Client> clientSelection;

    @Autowired
    CarRepository carRepository;
    @Autowired
    ClientRepository clientRepository;

    public void initialize() {
        carSelection.getItems().addAll(carRepository.findAll());
        clientSelection.getItems().addAll(clientRepository.findAll());
    }

    public void saveRentalClicked(ActionEvent actionEvent) {
        Rental newRental = new Rental();
        newRental.setRental_date(java.sql.Date.valueOf(startRental.getValue()));
        newRental.setReturn_date(java.sql.Date.valueOf(stopRental.getValue()));
        newRental.setActive(1);
        newRental.setCar(carSelection.getSelectionModel().getSelectedItem());
        newRental.setClient(clientSelection.getSelectionModel().getSelectedItem());
    }

    public void editClient(ActionEvent actionEvent) {
        loadFxml("it.htl.steyr.car_rental.Clients","Edit Clients");
    }

    public void editRentals(ActionEvent actionEvent) {
        loadFxml("it.htl.steyr.car_rental.Rental","Edit Rentals");
    }

    public void editCars(ActionEvent actionEvent) {
        loadFxml("it.htl.steyr.car_rental.Car","Edit Cars");
    }

    public void editBrand(ActionEvent actionEvent) {
        loadFxml("it.htl.steyr.car_rental.Brand","Edit Brands");

    }

    public void loadFxml(String path, String title){
        MyFXMLLoader loader = new MyFXMLLoader();
        loader.loadFXML(path, title);
    }

    public void ListViewClicked(MouseEvent mouseEvent) {
    }
}
