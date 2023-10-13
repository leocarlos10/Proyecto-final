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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


/**
 * 
 *
 * @author Leocarlos
 */
public class controller_principal implements Initializable {

     @FXML
    private ComboBox<String> combo_categorias;

    @FXML
    private ImageView usuario;

    @FXML
    private ComboBox<?> combo_inv_opciones;

    @FXML
    void event_op_usuario(MouseEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        combo_categorias.getItems().addAll("Anillos para hombre","anillos para mujer","collares para hombre","collares para mujer");
        
    }    
    
}
