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
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author moises , caleb, Leocarlos
 */
public class Catalogo_anillosmujerController implements Initializable {

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
     @FXML
    private void event_info_vista1(MouseEvent event) {
         try {
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista_info_anillosmujer/info_anillomujer1.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            Info_anillomujer1Controller controlador = loader.getController();
            controlador.setStage(stage);
           
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Error "+e);
         }
    }

    @FXML
    private void event_info_vista2(MouseEvent event) {
         try {
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista_info_anillosmujer/info_anillomujer2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            Info_anillomujer2Controller controlador = loader.getController();
            controlador.setStage(stage);
           
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Error "+e);
         }
    }
    
    @FXML
    private void event_info_vista3(MouseEvent event) {
    
    try {
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista_info_anillosmujer/info_anillomujer3.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            Info_anillosmujer3Controller controlador = loader.getController();
            controlador.setStage(stage);
           
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Error "+e);
}
    }
    @FXML
    private void event_info_vista4(MouseEvent event) {
    }
    
}
