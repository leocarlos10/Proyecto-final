/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moises
 */
public class Info_cadenahombre2Controller implements Initializable {

    Stage stage;

    public void setStage(Stage stage) {

        this.stage = stage;
    }
    
    @FXML
    private ComboBox<String> combo_talla;
    @FXML
    private ComboBox<String> combo_cantidad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo_cantidad.getItems().addAll("1", "2", "3", "4");
        combo_talla.getItems().addAll("1", "2", "3", "4", "5");
    }    

    @FXML
    private void event_volver(MouseEvent event) {
        stage.close();
    }
    
}
