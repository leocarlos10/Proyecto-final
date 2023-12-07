/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import Logica_Pila.Pila_Producto;
import Logica_Pila.Producto;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Caleb, Moises, Leocarlos
 */
public class Vista_compraController implements Initializable {
    
    Pila_Producto pro = new Pila_Producto();
    Stage stage;
    String precio;
    
    public void setStage(Stage stage2) {

        stage = stage2;
    }
    
     public void setPrecio(String pre) {

        precio = pre;
    }
    
    @FXML
    private ImageView imagen;
    @FXML
    private TextArea text_info;
    @FXML
    private Label label_precio;

    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        pro.getP_carrito();
        setInfoPComprado();
       
    }
    
    
    
    public void setInfoPComprado() {
        
        Producto p = null;
        try {
            p = pro.getProducto(pro.getprecio());
        } catch (Exception e) {
            System.out.println("precio vacio");
        }

        // si el objeto pro no esta vacio se carga la informacion
        if (pro != null) {

            if (p.getNombre().equalsIgnoreCase("Anillo Negro")) {

                // cargamos la info
                setCargarInfo("/imagenes/AnilloNegro1.jpeg", p);

            } else if (p.getNombre().equalsIgnoreCase("Anillo Natural black")) {
                // cargamos la info
                setCargarInfo("/imagenes/Anillo2.jpeg", p);

            } else if (p.getNombre().equalsIgnoreCase("Anillo chains wolfei")) {
                // cargamos la info
                setCargarInfo("/imagenes/AnilloNegro3.jpeg", p);

            } else if (p.getNombre().equalsIgnoreCase("Anillo Personalizado")) {
                // cargamos la info
                setCargarInfo("/imagenes/AnilloNegro4.jpeg", p);

            } else if (p.getNombre().equalsIgnoreCase("Paquete de anillos estilo gótico")) {
                // cargamos la info
                setCargarInfo("/imagenes/anillomujer1.jpg", p);

            } else if (p.getNombre().equalsIgnoreCase("Anillo minimalista de oro 18k")) {
                // cargamos la info
                setCargarInfo("/imagenes/anillomujer2.jpg", p);

            } else if (p.getNombre().equalsIgnoreCase("Anillo de oro 9k con rubíes")) {
                // cargamos la info
                setCargarInfo("/imagenes/anillomujer3.jpg", p);

            } else if (p.getNombre().equalsIgnoreCase("Anillo elegante de oro blanco ")) {
                // cargamos la info
                setCargarInfo("/imagenes/anillomujer4.jpg", p);

            } else if (p.getNombre().equalsIgnoreCase("Cadena plateada")) {
                // cargamos la info
                setCargarInfo("/imagenes/cadena hombre 1.jpg", p);

            } else if (p.getNombre().equalsIgnoreCase("Cadena Plateada Ancha")) {
                // cargamos la info
                setCargarInfo("/imagenes/cadena hombre 2.jpg", p);

            } else if (p.getNombre().equalsIgnoreCase("Cadena Doble ")) {
                // cargamos la info
                setCargarInfo("/imagenes/cadena hombre 3.jpg", p);

            } else if (p.getNombre().equalsIgnoreCase("Cadena Tipo 3")) {
                // cargamos la info
                setCargarInfo("/imagenes/cadena hombre 4.jpg", p);

            } else if (p.getNombre().equalsIgnoreCase("Cadena accesorio corazón")) {
                // cargamos la info
                setCargarInfo("/imagenes/cadena 1.jpg", p);

            } else if (p.getNombre().equalsIgnoreCase("Cadena con gota de agua")) {
                // cargamos la info
                setCargarInfo("/imagenes/cadena 2.jpg", p);

            } else if (p.getNombre().equalsIgnoreCase("Cadena dorada con rubí ")) {
                // cargamos la info
                setCargarInfo("/imagenes/cadena 3.jpg", p);

            } else if (p.getNombre().equalsIgnoreCase("Cadena accesorio diamante")) {
                // cargamos la info
                setCargarInfo("/imagenes/cadena 4.jpg", p);

            }

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
    private void event_volver_home(ActionEvent event) {
        
        stage.close();
    }
    
}
