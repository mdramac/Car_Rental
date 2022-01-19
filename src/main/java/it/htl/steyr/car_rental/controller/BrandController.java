package it.htl.steyr.car_rental.controller;

import it.htl.steyr.car_rental.model.BrandRepository;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class BrandController {
    public ListView brandListView;
    public TextField brandNameTextfield;

    @Autowired
    BrandRepository brandRepository;

    public void initialize() {
        brandListView.getItems().addAll(brandRepository.findAll());
    }

    public void brandSelectedclicked(MouseEvent mouseEvent) {
        brandNameTextfield.setText(String.valueOf(brandListView.getSelectionModel().getSelectedItem()));
    }

    public void removeBrandClicked(ActionEvent actionEvent) {
    }

    public void addBrandClicked(ActionEvent actionEvent) {
    }

    public void editBrandClicked(ActionEvent actionEvent) {
    }
}
