/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import Logica_cola.cola_producto;
import Logica_listasencilla.nodo_producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Historial_compraController implements Initializable {
    
    Stage stage;
    cola_producto colaP = new cola_producto();

    public void setStage(Stage stage) {

        this.stage = stage;
    }

    @FXML
    private Label label_precio;
    
    @FXML
    private ImageView event_volver;
    
    @FXML
    private TableView<nodo_producto> tabla;
    
    @FXML
    private TableColumn col_nombre;
    
    @FXML
    private TableColumn  col_precio;
    
    @FXML
    private TableColumn  col_correo_usuario;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        colaP.get_P_historial();
        if(!(colaP.inicio == null)){
            
          setLLenarTableView();
        }
        
    }    

    @FXML
    private void event_volver(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/principal.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            controller_principal controller = loader.getController();
            controller.setStage(stage);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al cambiar al principal " + e);
        }
    }
    
    public void setLLenarTableView() {
        
        // creamos el modelo para el tableView
        ObservableList<nodo_producto> lista = FXCollections.observableArrayList();
        
       // agregamos la direccion de los atributos a las columnas
        col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        col_correo_usuario.setCellValueFactory(new PropertyValueFactory<>("emailUs"));
       // recorremos la lista de productos en la clase lista sencilla para agregarlos al la lista modelo
       
        nodo_producto p = colaP.inicio;

        do {
            
           lista.add(p);
            p = p.sig;
            
        } while (p != colaP.inicio);
        // al terminar el de agregar las peliculas en la lista modelo se cargan en el tableView
        tabla.setItems(lista); 
    }
}
