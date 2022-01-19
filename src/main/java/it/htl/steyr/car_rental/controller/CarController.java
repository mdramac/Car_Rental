package it.htl.steyr.car_rental.controller;

import it.htl.steyr.car_rental.model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class CarController {
    public ListView<Car> carListView;
    public ComboBox<Brand> brandsBox;
    public TextField modellTextField;
    public TextField rentPerDayField;
    @Autowired
    CarRepository carRepository;
    @Autowired
    BrandRepository brandRepository;

    public void initialize() {
        brandsBox.setItems((ObservableList<Brand>) brandRepository.findAll());
        carListView.getItems().addAll(carRepository.findAll());
    }


    public void removeBrandClicked(ActionEvent actionEvent) {
        carRepository.delete(carListView.getSelectionModel().getSelectedItem());

    }

    public void addBrandClicked(ActionEvent actionEvent) {
        Car car = new Car();
        car.setDaily_rate(Integer.parseInt(rentPerDayField.getText()));
        car.setModell(modellTextField.getText());
    }

}
