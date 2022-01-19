package it.htl.steyr.car_rental.controller;

import it.htl.steyr.car_rental.IDialogConfirmedSubscriber;
import it.htl.steyr.car_rental.model.Car;
import it.htl.steyr.car_rental.model.CarRepository;
import it.htl.steyr.car_rental.model.Client;
import it.htl.steyr.car_rental.model.ClientRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

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
}
