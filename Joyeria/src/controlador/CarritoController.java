/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import Logica_Pila.Pila_Producto;
import Logica_Pila.Producto;
import Logica_cola.cola_producto;
import Logica_listasencilla.Lista_producto;
import Logica_listasencilla.nodo_producto;
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
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * 
 *
 * @author Moises , Caleb , Leocarlos
 */
public class CarritoController implements Initializable {
    
    Stage stage;
    Pila_Producto p = new Pila_Producto();
    cola_producto colaP = new cola_producto();
    Lista_producto listaP = new Lista_producto();
    
    @FXML
    private ImageView event_volver;
    @FXML
    private Button btn_eliminarPro;
   
    
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
        
        // obtenemos los datos de el fichero carrito
        p.getP_carrito();
        // si la pila esta vacia quiere decir que no hay productos agregados al carrito
        if(!p.pila.isEmpty()){
        // obtenemos el primer objeto de la pila
        Producto pro = p.pila.pop();
        // mandamos el objeto para que se precargen los datos ala vista.
        setInfoCarrito(pro);
        }else{
            
            // hacemos que el textPane no sea editable y le mandamos el texto carrito vacio.
            text_info.setEditable(false);
            text_info.setText("Carrito vacio ");
            
        }
     
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
          setCargarInfo("/imagenes/cadena 1.jpg",p);
           
        } else if (p.getNombre().equalsIgnoreCase("Cadena con gota de agua")) {
            // cargamos la info
          setCargarInfo("/imagenes/cadena 2.jpg",p);
           
        } else if (p.getNombre().equalsIgnoreCase("Cadena dorada con rubí ")) {
            // cargamos la info
          setCargarInfo("/imagenes/cadena 3.jpg",p);
           
        } else if (p.getNombre().equalsIgnoreCase("Cadena accesorio diamante")) {
            // cargamos la info
          setCargarInfo("/imagenes/cadena 4.jpg",p);
           
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
    private void event_anterior(ActionEvent event) {
        
        if(!p.pila.isEmpty()){
            
        // obtenemos la pos del objeto en la base
        int pos = p.pila.size()-1;
        // obtenemos el objeto
        Producto pro = p.pila.get(pos);
        // lo mostramos en el carrito
        setInfoCarrito(pro); 
        // eliminamos el producto ya mostrado
        p.pila.remove(pos);
        }else{
            
            p.aviso_info("Informacion", "Ya te encuentras en el tope de los productos agregados al carrito");
            // traemos los datos del fichero carrito para preparar el boton anterior
            p.getP_carrito();
            
        }
        
    }

    @FXML
    private void event_siguiente(ActionEvent event) {
       
        if (!p.pila.isEmpty()) {
            Producto pro = p.pila.pop();
            setInfoCarrito(pro);
           
        } else {
            p.aviso_info("Informacion", "Ya no hay mas productos en el carrito");
            // traemos los datos del fichero carrito para preparar el boton anterior
            p.getP_carrito();
            // eliminamos el producto repetido
            p.pila.remove(0);
            
        }
    }

    @FXML
    private void event_eliminarProducto(ActionEvent event) {
        
        String precio = label_precio.getText();
        p.eliminarPro(precio); 
        event_siguiente(event);
    }
    
    public void cambio_scene(){
        
         try {
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista_compra/vista_compra.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            Vista_compraController controlador = loader.getController();
            controlador.setStage(stage); 
           
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " Error "+e);
         }
    }

    @FXML
    private void event_proceder_pago(ActionEvent event) {
        
        p.pila.clear();
        p.getP_carrito();
        // primero traemos los datos ala cola
         String email = colaP.getEmail();
         
        if (!email.equals("")) {
          
            // obtenemos el objeto que se esta comprando
           
            Producto pro = p.getProducto(label_precio.getText());
            // recuperamos el email del usuario para instanciarlo en el objeto
            pro.setEmailUs(email);

            // guardamos el objeto en el historial de compra.
            try {
                colaP.guardar_P_Historial(pro);
                // y guardamos el precio
                 p.guardar_precio(label_precio.getText());
            } catch (Exception e) {
                System.out.println("no se pudo guardar el producto en el carrito.");
            }
            
            
            // cambiamos la scene
            cambio_scene();
        } else {

            listaP.aviso_info("INFO", """
                                      ACCION INVALIDA
                                      Por favor antes realizar la compra inicie sesion""");
        }
    }

}
