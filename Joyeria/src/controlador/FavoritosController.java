/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import Logica_listasencilla.Lista_producto;
import Logica_listasencilla.nodo_producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
public class FavoritosController implements Initializable {
    
     Stage stage;
     Lista_producto listaP = new Lista_producto();
     
    @FXML
    private ImageView event_volver;
    
    public void setStage(Stage stage1){
        stage=stage1;
    }

    @FXML
    private Label label_precio;
    @FXML
    private TableView<nodo_producto> tabla;
    @FXML
    private TableColumn col_nombre;
    @FXML
    private TableColumn col_precio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // primero que todo debemos traer toda la informacion de el fichero favoritos
        listaP.get_P_favoritos();
        if (!(listaP.cab == null)) {

            setLLenarTableView();
        }
    }    

    @FXML
    private void event_volver(MouseEvent event) {
        
        try {
            // primero cambia la scene 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/principal.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            // luego devuelve el stage(la ventana raiz).
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
        
       // recorremos la lista de productos en la clase lista sencilla para agregarlos al la lista modelo
       if(listaP.cab != null){
           
           nodo_producto p = listaP.cab;
           
           while(p!=null){
               
               lista.add(p);
               p = p.sig;
           }
       }
        // al terminar el de agregar las peliculas en la lista modelo se cargan en el tableView
        tabla.setItems(lista); 
    }

    @FXML
    private void event_eliminarp(ActionEvent event) {
        
        nodo_producto pro = tabla.getSelectionModel().getSelectedItem();
        
        if (!(pro == null)) {
            listaP.eliminar_producto(pro);
            setLLenarTableView();
        } else {

            listaP.aviso_info("INFO", "Por favor seleccione un elemento de la tabla");
        }
        
    }
    
}
