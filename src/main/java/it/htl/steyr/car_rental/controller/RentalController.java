package it.htl.steyr.car_rental.controller;

import it.htl.steyr.car_rental.model.ClientRepository;
import it.htl.steyr.car_rental.model.Rental;
import it.htl.steyr.car_rental.model.RentalRepository;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

public class RentalController {

    public ListView<Rental> rentalListView;
    @Autowired
    RentalRepository rentalRepository;

    public void initialize() {
        rentalListView.getItems().addAll(rentalRepository.findAll());
    }

    public void removeRentalClicked(ActionEvent actionEvent) {
        rentalRepository.delete(rentalListView.getSelectionModel().getSelectedItem());
    }

    public void cancelClicked(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        s.close();
    }
}
