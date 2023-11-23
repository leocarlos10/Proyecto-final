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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Catalogo_cadenasmujerController implements Initializable {

    @FXML
    private ImageView imagen2;
    @FXML
    private ImageView imagen1;
    @FXML
    private ImageView imagen3;
    @FXML
    private ImageView imagen4;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    // evento para mostrar las ventanas de Informacion personal de cada producto seleccionado
    private void event_info_vista(MouseEvent event) {
        
        
    }

    @FXML
    private void event_info_vista2(MouseEvent event) {
         try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista_info_cadenasmujer/info_cadenamujer2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            Info_cadenamujer2Controller controlador = loader.getController();
            controlador.setStage(stage);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error " + e);
        }
    }

    @FXML
    private void event_info_vista1(MouseEvent event) {
         try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista_info_cadenasmujer/info_cadenamujer1.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            Info_cadenamujer1Controller controlador = loader.getController();
            controlador.setStage(stage);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error " + e);
        }
    }

    @FXML
    private void event_info_vista3(MouseEvent event) {
         try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista_info_cadenasmujer/info_cadenamujer3.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            Info_cadenamujer3Controller controlador = loader.getController();
            controlador.setStage(stage);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error " + e);
        }
    }

    @FXML
    private void event_info_vista4(MouseEvent event) {
         try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista_info_cadenasmujer/info_cadenamujer4.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            Info_cadenamujer4Controller controlador = loader.getController();
            controlador.setStage(stage);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error " + e);
        }
    }
    
}
