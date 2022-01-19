package it.htl.steyr.car_rental.controller;

import it.htl.steyr.car_rental.model.Client;
import it.htl.steyr.car_rental.model.ClientRepository;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientsController {

    public ListView<Client> customerListView;
    public TextField firstnameTextfield;
    public TextField lastnameTextfield;
    public TextField emailTextField;
    public TextField ibanTextField;
    @Autowired
    ClientRepository clientRepository;

    public void initialize() {
        customerListView.getItems().addAll(clientRepository.findAll());
    }

    public void removeCustomerClicked(ActionEvent actionEvent) {
        clientRepository.delete(customerListView.getSelectionModel().getSelectedItem());

    }

    public void cancelClicked(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        s.close();
    }

    public void newClientClicked(ActionEvent actionEvent) {
        Client client = new Client();
        client.setName(firstnameTextfield.getText() + " " + lastnameTextfield.getText());
        client.setEmail(emailTextField.getText());
        client.setIban(ibanTextField.getText());
    }
}
