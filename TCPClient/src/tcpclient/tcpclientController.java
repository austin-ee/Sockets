/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tcpclient;

import aus.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author Winston
 */
public class tcpclientController implements Initializable {
    
    @FXML
    private TextField reg;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Student std=new Student(reg.getText(),name.getText(),Integer.parseInt(age.getText()));
        try {
            TCPClient.server(std);
        } catch (Exception ex) {
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
