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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author Moises, caleb , Leocarlos
 */
public class Catalogo_anilloshombreController implements Initializable {
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
     @FXML
     void event_ventana_info(MouseEvent event) {
        
         try {
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista_info_anilloshombre/Info_Anillo_Negro1.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            Info_Anillo_Negro1Controller controlador = loader.getController();
            controlador.setStage(stage);
           
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Error "+e);
         }
    }

    @FXML
    private void event_info_vista2(MouseEvent event) {
          JOptionPane.showMessageDialog(null, "Evento generado");
    }

    @FXML
    private void event_info_vista3(MouseEvent event) {
          JOptionPane.showMessageDialog(null, "Evento generado");
    }

    @FXML
    private void event_info_vista4(MouseEvent event) {
          JOptionPane.showMessageDialog(null, "Evento generado");
    }

   
    
}
