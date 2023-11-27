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
 * @author USUARIO
 */
public class Info_anillo_negro3Controller implements Initializable {
    
     Stage stage;
     Pila_Producto p = new Pila_Producto();

    public void setStage(Stage stage) {

        this.stage = stage;
    }

    @FXML
    private ComboBox<String> combo_talla;
    @FXML
    private ComboBox<String> combo_cantidad;
    @FXML
    private Label nombre_producto;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo_cantidad.getItems().addAll("1", "2", "3", "4");
        combo_talla.getItems().addAll("1", "2", "3", "4", "5");
    }    

    @FXML
    private void event_volver(MouseEvent event) {
        stage.close();
    }

    @FXML
    private void event_agregar_carrito(ActionEvent event) {
        
         // primero cargamos la info de los productos en la pila
        p.getInfo_Productos();
        // luego recorremos la lista para buscar el producto el cual se va agregar al fichero carrito
        Producto pro = p.getProduto(nombre_producto.getText());
        if (pro != null) {

            // lo guardamos en le fichero.
            try {
                p.guardar_P_fichero(pro);
            } catch (Exception e) {
                System.out.println("no se pudo guardar el producto en el carrito.");
            }
        } else {
            System.out.println("El producto no se pudo agregar al carrito");
        }
        
        p.aviso_info("INFO", "Producto agregado al carrito");
    }

    @FXML
    private void event_comprar_ahora(ActionEvent event) {
    }

    @FXML
    private void event_agregar_favoritos(ActionEvent event) {
    }
    
}
