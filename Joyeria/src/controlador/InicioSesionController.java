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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class InicioSesionController implements Initializable {
    
    // capturamos el stage para poder volver a mostrar la scene de el prinicipal
    Stage stage;
    
    public void setStage1(Stage stage){
        this.stage=stage;
    }
 
    @FXML
    void event_volver(MouseEvent event) {
        
        try{
        // primero cambia la scene 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/principal.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        // luego devuelve el stage(la ventana raiz).
        controller_principal controller = loader.getController();
        controller.setStage(stage); 
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al cambiar al principal "+e);
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
