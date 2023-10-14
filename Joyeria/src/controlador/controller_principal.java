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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


/**
 * 
 *
 * @author Leocarlos, moises, caleb
 */
public class controller_principal implements Initializable {
    
    // componentes FXML
     @FXML
    private ComboBox<String> combo_categorias;

    @FXML
    private ImageView usuario;
    
     @FXML
    private ComboBox<String> combo_opciones;
     
     @FXML
    private TextField text_buscar;
     
     boolean estado_textbuscar=false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // cargamos el comboBox de las categorias y el de las opciones de la cuenta
        combo_categorias.getItems().addAll("Anillos para hombre","anillos para mujer","collares para hombre","collares para mujer");
        combo_opciones.getItems().addAll("Iniciar sesion","Registrarse","Historial de compra");
        // con este hacemos que cuando el cursor este sobre los comboBox se vuelvan una manito.
        combo_opciones.setCursor(Cursor.HAND);
        combo_categorias.setCursor(Cursor.HAND);
    }    
    
    // eventos
    
    // con este evento manejo la visibilidad del TexField buscar
    @FXML
    void event_mostrar_text_buscar(MouseEvent event) {
       
        if(estado_textbuscar){
            text_buscar.setVisible(false);
            estado_textbuscar=false;
        }else{
            text_buscar.setVisible(true);
            estado_textbuscar=true;
        }
    }
    
    // cuando el usuario le de enter para buscar se borre lo que esta y se oculte el textfield
    // ademas de buscar y mostrar los datos del producto necesario.
    @FXML
    void event_Enter(KeyEvent event) {
        // con este condicional verifico que el evento de accione solo cuando se presione la tecla enter
        if(event.getCode() == KeyCode.ENTER){
            text_buscar.setText("");
            text_buscar.setVisible(false);
        }
        // agregar el codigo para que muestre la venta del producto buscado
    }
}
