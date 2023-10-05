/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javax.swing.JOptionPane;

/**
 * 
 *
 * @author USUARIO
 */
public class PrincipalController implements Initializable {

     @FXML
    private Button btn_hello;

    @FXML
    void event_saludo(ActionEvent event) {
        
        JOptionPane.showMessageDialog(null,"hola");

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
