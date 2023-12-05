/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import Logica_producto.Pila_Producto;
import Logica_producto.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Caleb , Moises , Leocarlos
 */
public class Info_Anillo_Negro1Controller implements Initializable {
    
   Stage stage;
   Pila_Producto p = new Pila_Producto();
   
   
   public void setStage(Stage stage){
       
       this.stage=stage;
   }
   
    @FXML
    private ComboBox<String> combo_cantidad;

    @FXML
    private ComboBox<String> combo_talla;

    @FXML
    private Label nombre_producto;
    
    @FXML
    private Label precio_producto;


    @FXML
    void event_volver(MouseEvent event) {
        
        stage.close();
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        combo_cantidad.getItems().addAll("1","2","3","4");
        combo_talla.getItems().addAll("1","2","3","4","5");
    }

    @FXML
    private void event_agregar_carrito(ActionEvent event) {
        
        // primero creamos el objeto
        Producto pro = new Producto(
                nombre_producto.getText(),
                precio_producto.getText(),
                combo_talla.getValue(),
                combo_cantidad.getValue());

            // lo guardamos en le fichero.
            try {
                p.guardar_P_fichero(pro);
            } catch (Exception e) {
                System.out.println("no se pudo guardar el producto en el carrito.");
            }
        
        p.aviso_info("INFO", "Producto agregado al carrito");
    }

    @FXML
    private void event_comprar_ahora(ActionEvent event) {
    }

    @FXML
    private void event_agregar_favoritos(ActionEvent event) {
        
         // primero creamos el objeto
        Producto pro = new Producto(
                nombre_producto.getText(),
                precio_producto.getText(),
                combo_talla.getValue(),
                combo_cantidad.getValue());

            // lo guardamos en le fichero.
            try {
                p.guardar_P_favoritos(pro);
            } catch (Exception e) {
                System.out.println("no se pudo guardar el producto en favoritos.");
            }
        
        p.aviso_info("INFO", "Producto agregado a favoritos");
        
    }
}
