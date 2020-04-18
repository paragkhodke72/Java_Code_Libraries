/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KilometerConverter;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author gshee
 */
public class KilometerConverterController {

    @FXML
    private TextField entryField;

    @FXML
    private Label instructions;

    @FXML
    private Label answer;

    @FXML
    private Button convertButton;

    
    @FXML
    public void convertKilometers(ActionEvent event) {
        
    }
    
    @FXML
    void initialize() {
        assert entryField != null : "fx:id=\"entryField\" was not injected: check your FXML file 'KilometerConverter.fxml'.";
        assert instructions != null : "fx:id=\"instructions\" was not injected: check your FXML file 'KilometerConverter.fxml'.";
        assert answer != null : "fx:id=\"answer\" was not injected: check your FXML file 'KilometerConverter.fxml'.";
        assert convertButton != null : "fx:id=\"convertButton\" was not injected: check your FXML file 'KilometerConverter.fxml'.";
    }
    
    @FXML
    void performConversion() {
        try {
            int kilometers = Integer.parseInt(entryField.getText());
            if (kilometers > 1000000) {
                throw new Exception();
            } 
            double miles = (double)kilometers * 0.6214;
            answer.setText(kilometers + " kilometers is " + String.format("%.2f", miles) + " miles.");
        }
        catch(Exception ex) {
            answer.setText("Please enter an integer of 1,000,000 or less");
        }
    }
    
    @FXML
    void restrictToNumbers() {
        String cleanedInput = entryField.getText().replaceAll("[^0-9]", "");
        entryField.setText(cleanedInput);
    }
    
}
