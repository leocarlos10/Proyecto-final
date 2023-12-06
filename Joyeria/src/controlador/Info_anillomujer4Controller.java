/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import Logica_Pila.Pila_Producto;
import Logica_Pila.Producto;
import Logica_cola.cola_producto;
import Logica_listasencilla.Lista_producto;
import Logica_listasencilla.nodo_producto;
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
public class Info_anillomujer4Controller implements Initializable {

    Stage stage;
    Pila_Producto p = new Pila_Producto();
   Lista_producto listaP = new Lista_producto();
   cola_producto colaP = new cola_producto();
   
    @FXML
    private Label nombre_producto;
    @FXML
    private Label precio_producto;

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

    @FXML
    private void event_agregar_carrito(ActionEvent event) {
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
    private void event_agregar_favoritos(ActionEvent event) {
        nodo_producto pro = new nodo_producto(nombre_producto.getText(),precio_producto.getText());
        
           // lo guardamos en le fichero.
           try {
               listaP.guardar_P_favoritos(pro);
            } catch (Exception e) {
                System.out.println("no se pudo guardar el producto en favoritos.");
            }
        
        p.aviso_info("INFO", "Producto agregado a favoritos");
    }

    @FXML
    private void event_comprar_ahora(ActionEvent event) {
        
         String email = colaP.getEmail();
        if (!email.equals("")) {
            nodo_producto pro = new nodo_producto(
                    nombre_producto.getText(),
                    precio_producto.getText());
            // recuperamos el email del usuario para instanciarlo en el objeto
            pro.setEmailUs(email);

            try {
                colaP.guardar_P_Historial(pro);
            } catch (Exception e) {
                System.out.println("no se pudo guardar el producto en el carrito.");
            }

            p.aviso_info("INFO", "Compra Exitosa");
        }else{
            
            listaP.aviso_info("INFO", """
                                      ACCION INVALIDA
                                      Por favor antes realizar la compra inicie sesion""");
        }
    }

}
