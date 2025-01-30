package it.giannotti.Controller;

import java.io.IOException;

import it.giannotti.Phonebook.Contact;
import it.giannotti.Phonebook.Index;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainController {

    @FXML
    private Pane add_contact_pane;

    @FXML
    private Pane edit_contact_pane;

    @FXML
    private VBox contact_box;

    @FXML
    private TextField add_name_field;
    @FXML
    private TextField add_surname_field;
    @FXML
    private TextField add_number_field;
    @FXML
    private TextField edit_name_field;
    @FXML
    private TextField edit_surname_field;
    @FXML
    private TextField edit_number_field;

    private Index phonebook = Index.getInstance();
    private Contact editing_contact;

    @FXML
    public void initialize() {
        displayContacts();
    }

    private void displayContacts() {
        contact_box.getChildren().clear();
        for (Contact c : phonebook.getContacts()) {
            HBox contact = new HBox();
            //name label
            Label name = new Label();
            name.setAlignment(Pos.CENTER);
            name.setMinWidth(140);
            name.setMinHeight(50);
            name.setText(c.getName());
            //surname label
            Label surname = new Label();
            surname.setAlignment(Pos.CENTER);
            surname.setMinWidth(140);
            surname.setMinHeight(50);
            surname.setText(c.getSurname());
            //number label
            Label number = new Label();
            number.setAlignment(Pos.CENTER);
            number.setMinWidth(140);
            number.setMinHeight(50);
            number.setText(c.getNumber());
            //delete button
            Button del_button = new Button();
            del_button.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                deleteContact(e);
            }
            });
            del_button.setText("Delete");
            del_button.setMinWidth(50);
            del_button.setMinHeight(30);
            //edit button
            Button edit_button = new Button();
            edit_button.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                showEditPane(e);
            }
            });
            edit_button.setText("Edit");
            edit_button.setMinWidth(50);
            edit_button.setMinHeight(30);
            //centering buttons
            HBox.setMargin(del_button, new Insets(10,0,0,10));
            HBox.setMargin(edit_button, new Insets(10,0,0,10));
            //adding elements to contact box
            contact.getChildren().add(name);
            contact.getChildren().add(surname);
            contact.getChildren().add(number);
            contact.getChildren().add(edit_button);
            contact.getChildren().add(del_button);
            contact.setAlignment(Pos.CENTER);
            contact.setMinHeight(50);
            contact.setMinWidth(560);
            contact_box.getChildren().add(contact);
        }
    }

    @FXML
    private void cancelEdit() {
        edit_contact_pane.setVisible(false);
    }

    @FXML
    private void addContact() {
        Contact c = new Contact(add_name_field.getText(), add_surname_field.getText(), add_number_field.getText());
        phonebook.addContact(c);
        displayContacts();
        add_contact_pane.setVisible(false);
    }

    @FXML
    private void editContact() {
        phonebook.editContact(editing_contact, edit_name_field.getText(), edit_surname_field.getText(), edit_number_field.getText());
        displayContacts();
        edit_contact_pane.setVisible(false);
    }

    private void deleteContact(ActionEvent e) {
        Button clicked = (Button) e.getSource();
        HBox box = (HBox) clicked.getParent();
        Label name = (Label) box.getChildren().get(0);
        Label surname = (Label) box.getChildren().get(1);
        phonebook.removeContact(name.getText(), surname.getText());
        displayContacts();
    }

    private void showEditPane(ActionEvent e) {
        edit_contact_pane.setVisible(true);
        
        Button clicked = (Button) e.getSource();
        HBox box = (HBox) clicked.getParent();
        Label name = (Label) box.getChildren().get(0);
        Label surname = (Label) box.getChildren().get(1);
        editing_contact = phonebook.getContactByName(name.getText(), surname.getText());
        edit_name_field.setText(editing_contact.getName());
        edit_surname_field.setText(editing_contact.getSurname());
        edit_number_field.setText(editing_contact.getNumber());
    }

    @FXML
    private void showNewContactPane() throws IOException {
        add_contact_pane.setVisible(true);
    }

}
