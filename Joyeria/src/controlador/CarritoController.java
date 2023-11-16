/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * 
 *
 * @author Moises , Caleb , Leocarlos
 */
public class CarritoController implements Initializable {
    
    Stage stage;
    
    public void setStage(Stage stage1){
        
        this.stage = stage1;
    }

     @FXML
    private ImageView imagen;

    @FXML
    private Label label_precio;

    @FXML
    private TextArea text_info;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // cargamos la imagen
        InputStream input = getClass().getResourceAsStream("/imagenes/AnilloNegro1.jpeg");
        Image image = new Image(input);
        imagen.setImage(image);
        
        text_info.setText("""
                          Anillo de hombre
                          115.000 COP
                          Color: negro cantidad: 1""");
        // hacemos que el textPane no sea editable
        text_info.setEditable(false);
        label_precio.setText("115.000 COP");
        
    }    
    
    
    @FXML
    void event_volver(MouseEvent event) {
        
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/principal.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        controller_principal controller = loader.getController();
        controller.setStage(stage); 
        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al cambiar al principal "+e);
        }
    }

}
