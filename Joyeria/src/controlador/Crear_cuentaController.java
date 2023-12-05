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
import Logica_listasencilla.Lista_us;


/**
 * FXML Controller class
 *
 * @author Leocarlos,moises,caleb
 */
public class Crear_cuentaController implements Initializable {
 
    // capturamos el stage poder volver a mostrar la scene de el prinicipal
    Stage stage;
    Lista_us lista = new Lista_us();

    public void setStage2(Stage stage1) {
        stage = stage1;
    }

    @FXML
    private TextField correo;

    @FXML
    private PasswordField pass;

    
    
    @FXML
    void event_volver(MouseEvent event) {
        volver();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    // evento para registrar a los usuarios
    @FXML
    private void event_registrar(ActionEvent event) {
        
        // primero verificamos si el correo se encuentra repetido
        boolean repetido = lista.verfCorreo(correo.getText());
        // si devuelve true se encuentra repetido si devuelve false no se encuentra repetido
        
        if (repetido) {
            lista.aviso_Error("ERROR", "Correo repetido, Por favor intente nuevamente");
            correo.setText("");
            correo.requestFocus();
        } else {
            // agremos el usuario a la lista
            boolean estado = lista.setAgregarFinal(correo.getText(), pass.getText());

            // si se guardo correctamente en la lista podemos guardarlo en el fichero.
            if (estado) {
                try {
                    // guardamos en usuario en el fichero
                    lista.guardar_us_fichero();
                    // eliminamos el usuario de la cabeza de la lista.
                    lista.EliminarUs();
                } catch (Exception e) {

                    lista.aviso_Error("ERROR", " No se pudo guardar los dato en el fichero " + e);
                }
            }
            volver();
        }
    }
    
    public void volver(){
        
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
}
