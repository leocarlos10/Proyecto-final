/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controlador.controller_principal;
/**
 *
 * @author Leocarlos
 */
public class Main extends Application{
    
    @Override
    public void start(Stage stage) throws Exception{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/principal.fxml"));
        Parent root = loader.load();
        // con esto setamos el stage(la ventana principal) para poder enviarla al controlador
        controller_principal controller = loader.getController();
        controller.setStage(stage); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args){
        
        launch(args);
    }
    
}
