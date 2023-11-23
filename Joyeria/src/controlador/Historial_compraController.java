/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
   

    public void setStage(Stage stage) {

        this.stage = stage;
    }

    @FXML
    private Label label_precio;
    
    @FXML
    private ImageView event_volver;
    
    @FXML
    private TableView<?> tabla;
    
    @FXML
    private TableColumn<?, ?> col_nombre;
    
    @FXML
    private TableColumn<?, ?> col_precio;
    
    @FXML
    private TableColumn<?, ?> col_correo_usuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}
