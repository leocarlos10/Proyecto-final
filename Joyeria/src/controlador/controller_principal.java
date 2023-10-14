/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


/**
 * 
 *
 * @author Leocarlos, moises, caleb
 */
public class controller_principal implements Initializable {

     @FXML
    private ComboBox<String> combo_categorias;

    @FXML
    private ImageView usuario;

    @FXML
    private ComboBox<?> combo_inv_opciones;
    
     @FXML
    private ComboBox<String> combo_opciones;

    @FXML
    void event_op_usuario(MouseEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // cargamos el comboBox de las categorias y el de las opciones de la cuenta
        combo_categorias.getItems().addAll("Anillos para hombre","anillos para mujer","collares para hombre","collares para mujer");
        combo_opciones.getItems().addAll("Iniciar sesion","Registrarse","Historial de compra");
        // con este hacemos que cuando el cursor este sobre los comboBox se vuelvan una manito.
        combo_opciones.setCursor(Cursor.HAND);
        combo_categorias.setCursor(Cursor.HAND);
    }    
    
}
