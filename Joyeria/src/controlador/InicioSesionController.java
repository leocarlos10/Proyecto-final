/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import Logica_usuarios.Lista_us;

/**
 * FXML Controller class
 *
 * @author Moises,Caleb,Leocarlos
 */
public class InicioSesionController implements Initializable {
    
    // capturamos el stage para poder volver a mostrar la scene de el prinicipal
    Stage stage;
    Lista_us lista = new Lista_us();
    
    @FXML
    private TextField correo;
    @FXML
    private PasswordField pass;
    
    public void setStage1(Stage stage){
        this.stage=stage;
    }
 
    @FXML
    void event_volver(MouseEvent event) {
        
        volver();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void event_ingresar(ActionEvent event) {
        
        // lo primero que hacemos es obtener la info de los usuarios en el archivo de texto.
        lista.getInfo_usuarios();
        // luego verificamos si se encuentra registrado o no
        String email = lista.verfInicioSesion(correo.getText(), pass.getText());
        
        if(email.equals("")){
            
            lista.aviso_info("AVISO", """
                                      El usuario no se encuentra registrado en el sistema 
                                      Por favor cree una cuenta antes de iniciar sesion""");
            correo.setText("");
            pass.setText("");
        }else{
            
            volver(email);
        }
        
    }
    
    public void volver(){
        
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
    
    public void volver(String email){
        
        try{
        // primero cambia la scene 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/principal.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        // luego devuelve el stage(la ventana raiz).
        controller_principal controller = loader.getController();
        controller.setStage(stage);
        controller.setEmail(email); 
        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al cambiar al principal "+e);
        }
    }
    
}
