/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import Logica_producto.Pila_Producto;
import Logica_producto.Producto;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    Pila_Producto p = new Pila_Producto();
   
    
    public void setStage(Stage stage1){
        
        this.stage = stage1;
    }

     @FXML
    private ImageView imagen;

    @FXML
    private Label label_precio;

    @FXML
    private TextArea text_info;
    
    @FXML
    private ImageView event_volver;
    @FXML
    private Button btn_eliminarPro;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // obtenemos los datos de el fichero carrito
        p.getP_carrito();
        // obtenemos el primer objeto de la pila
        Producto pro = p.pila.pop();
        // mandamos el objeto para que se precargen los datos ala vista.
        setInfoCarrito(pro);
     
    }
    
    @FXML
    void event_volver(MouseEvent event) {
        
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
    
    public void setInfoCarrito(Producto p) {
        
        if (p.getNombre().equalsIgnoreCase("Anillo Negro")) {
            
            // cargamos la info
            setCargarInfo("/imagenes/AnilloNegro1.jpeg", p);
            
        } else if (p.getNombre().equalsIgnoreCase("Anillo Natural black")) {
             // cargamos la info
            setCargarInfo("/imagenes/Anillo2.jpeg",p);
           
            
        } else if (p.getNombre().equalsIgnoreCase("Anillo chains wolfei")) {
            // cargamos la info
            setCargarInfo("/imagenes/AnilloNegro3.jpeg",p);
            
        } else if (p.getNombre().equalsIgnoreCase("Anillo Personalizado")) {
            // cargamos la info
          setCargarInfo("/imagenes/AnilloNegro4.jpeg",p);
           
        }
    }
    
    public void setCargarInfo(String url, Producto p){
    
        // cargamos la imagen
        InputStream input = getClass().getResourceAsStream(url);
        Image image = new Image(input);
        imagen.setImage(image);

        text_info.setText(p.escribir());
        // hacemos que el textPane no sea editable
        text_info.setEditable(false);
        label_precio.setText(p.getPrecio());

    }

    @FXML
    private void event_eliminarProducto(ActionEvent event) {
    }

    @FXML
    private void event_anterior(ActionEvent event) {
        
    }

    @FXML
    private void event_siguiente(ActionEvent event) {
       
        if (!p.pila.isEmpty()) {
            Producto pro = p.pila.pop();
            setInfoCarrito(pro);
        } else {
            p.aviso_info("Informacion", "Ya no hay mas productos en el carrito");
        }
    }

}
