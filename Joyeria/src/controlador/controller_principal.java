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
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * 
 *
 * @author Leocarlos, moises, caleb
 * 
 */
public class controller_principal implements Initializable {
    
    
    Stage stage;
    Node contenidoActual=null;
    
    // con este metodo seteamos el stage desde el Main esto con el fin de poder manejar la scene en el stage(La ventana raiz)
    public void setStage(Stage stage1){
        
        stage=stage1;
    }
    
    // componentes FXML
    @FXML
    private HBox contenidoHbox;
    
    @FXML
    private ImageView usuario;
    
     @FXML
    private StackPane StackPane;
     
     HBox CPrincipal,CAnillosHombre,CAnillosMujer,C_Cadenashombre,C_Cadenasmujer;
    
    @FXML
    private TextField text_buscar;
    
     @FXML
    private SplitMenuButton Menu_categorias;

    @FXML
    private SplitMenuButton menu_opciones;

     boolean estado_textbuscar=false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // cargamos en una lista los nombres de categorias y opciones
        String []opciones ={"Inicio de sesion","Registrarse","Historial de compra"};
        String[] categorias = { "Anillos de hombre","Anillos de mujer","Cadenas de hombre","Cadenas de mujer"};
        MenuItem item_opciones;
        MenuItem item_categorias;
        // este bucle for es el encargado de cargar los menuItem en el SplitMenuButton de opciones 
        // ademas de agregarle un evento a cada MenuItem
       
            for(String i: opciones){
                
                // instancio el menuItem y de paso le agrego el nombre
                item_opciones = new MenuItem(i);
                // luego agrego el evento de cada uno.
                item_opciones.setOnAction(Event ->{
                    
                    manejo_eventos(i);
                });

                // por ultimo lleno el comboBox de opciones
                menu_opciones.getItems().add(item_opciones);

            }
        

             // este bucle for es el encargado de cargar los MenuItem en el SplitMenuButton de categorias
            // ademas de agregarle un evento a cada MenuItem
             for(String i: categorias){
                // instancio el menuItem y de paso le agrego el nombre
                item_categorias = new MenuItem(i);
                // luego agrego el evento de cada uno.
                item_categorias.setOnAction(Event ->{
                
                    manejo_eventos(i);
                });

                // por utlimo lleno el comboBox de opciones
                Menu_categorias.getItems().add(item_categorias);
         
           
        }
        // con esto hacemos que cuando el cursor este sobre los SplitMenuButton  se vuelvan una manito.
        menu_opciones.setCursor(Cursor.HAND);
        Menu_categorias.setCursor(Cursor.HAND);
        
        // carga de las respectivas ventanas
        try {
           CPrincipal = cargar_ventanas("/vista/contenidoPrincipal.fxml"); 
           CAnillosHombre = cargar_ventanas("/vista_catalogo/Catalogo_anilloshombre.fxml");
           CAnillosMujer = cargar_ventanas("/vista_catalogo/Catalogo_anillosmujer.fxml");
           C_Cadenashombre = cargar_ventanas("/vista_catalogo/Catalogo_cadenashombre.fxml");
          C_Cadenasmujer = cargar_ventanas("/vista_catalogo/Catalogo_cadenasmujer.fxml");
           StackPane.getChildren().addAll(CPrincipal,CAnillosHombre,CAnillosMujer,C_Cadenashombre,C_Cadenasmujer);
           // controlamos la visibilidad de la vistas
           CPrincipal.setVisible(true);
           CAnillosHombre.setVisible(false);
           CAnillosMujer.setVisible(false);
           C_Cadenashombre.setVisible(false);
           C_Cadenasmujer.setVisible(false);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR en el cambio de ventana "+e);
        }
    }    
    
    // eventos 
    
    // con este evento manejo la visibilidad del TexField buscar
    @FXML
    void event_mostrar_text_buscar(MouseEvent event) {
       
        if(estado_textbuscar){
            text_buscar.setVisible(false);
            estado_textbuscar=false;
        }else{
            text_buscar.setVisible(true);
            estado_textbuscar=true;
        }
    }
    
    // cuando el usuario le de enter para buscar se borre lo que esta y se oculte el textfield
    // ademas de buscar y mostrar los datos del producto necesario.
    @FXML
    void event_Enter(KeyEvent event) {
        // con este condicional verifico que el evento se accione solo cuando se presione la tecla enter
        if(event.getCode() == KeyCode.ENTER){
            text_buscar.setText("");
            text_buscar.setVisible(false);
        }
        // agregar el codigo para que muestre la venta del producto buscado
    }
    
    @FXML
    void event_volver_pri(MouseEvent event) {
        
        CPrincipal.setVisible(true);
        CAnillosHombre.setVisible(false);
        CAnillosMujer.setVisible(false);
        C_Cadenashombre.setVisible(false);
        C_Cadenasmujer.setVisible(false);
    }
    
     @FXML
    void event_carrito(MouseEvent event) {
         
        try {
              cambio_ventana("/vista/Carrito.fxml");
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ERROR en el cambio de ventana "+e);
         }
        
    }
    
    // este metodo me permita manejar los eventos dependiendo el nombre del menuItem
    public void manejo_eventos(String nombre){
    
        // con un switch de Strings hago la verificacion correspondiente
        switch(nombre){
            
            case "Inicio de sesion":
                
                try{
                     cambio_ventana("/vista/inicioSesion.fxml");
                }catch(Exception e){
                    
                     System.out.println("Error en el cambio de la vista inciar sesion"+e);
                }
                break;

            case "Registrarse":
                 try{
                     
                     cambio_ventana("/vista/Crearcuenta.fxml");
                     
                }catch(Exception e){
                    
                  System.out.println("Error en el cambio de la vista crear cuenta"+e);
                }
                break;

            case "Historial de compra":
                JOptionPane.showMessageDialog(null, "Evento generado para el Historial de compra");
                break;

            case "Anillos de hombre":
                
                CPrincipal.setVisible(false);
                CAnillosHombre.setVisible(true);
                CAnillosMujer.setVisible(false);
                C_Cadenashombre.setVisible(false);
                C_Cadenasmujer.setVisible(false);
                break;

            case "Anillos de mujer":
                
                CPrincipal.setVisible(false);
                CAnillosHombre.setVisible(false);
                CAnillosMujer.setVisible(true);
                C_Cadenashombre.setVisible(false);
                C_Cadenasmujer.setVisible(false);
                break;

            case "Cadenas de hombre":
                
                CPrincipal.setVisible(false);
                CAnillosHombre.setVisible(false);
                CAnillosMujer.setVisible(false);
                C_Cadenashombre.setVisible(true);
                C_Cadenasmujer.setVisible(false);
                break;

            case "Cadenas de mujer":
                CPrincipal.setVisible(false);
                CAnillosHombre.setVisible(false);
                CAnillosMujer.setVisible(false);
                C_Cadenashombre.setVisible(false);
                C_Cadenasmujer.setVisible(true);
                break;
                
            default:
                break;
        }
    }
    
    // este es el metodo encargado de cambiar la scene teniendo en cuenta la url de la ventana.
    public void cambio_ventana(String url) throws Exception{
        
        // si el url apunta a la vista de inicio de sesion muestra esa vista de lo contrario muestra la vista de Crear cuenta.
        if(url.equals("/vista/inicioSesion.fxml")){
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            InicioSesionController controller = loader.getController();
            controller.setStage1(stage);
            
        }else if(url.equals("/vista/Crearcuenta.fxml")){
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            Crear_cuentaController controller = loader.getController();
            controller.setStage2(stage); 
            
        }else if(url.equals("/vista/Carrito.fxml")){
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            CarritoController controlador = loader.getController();
            controlador.setStage(stage);
        }
    }
    
    // este metodo nos ayuda a pregar las ventanas que estan en el componente StackPane
    public HBox cargar_ventanas(String url) throws Exception {
        
        HBox hbox= FXMLLoader.load(getClass().getResource(url));
        return hbox;
    }
    
    public FXMLLoader getLoader(String url) {
        
        FXMLLoader loader =  null;
        try {
            loader = new FXMLLoader(getClass().getResource(url));
            Parent root = loader.load();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR "+e);
        }
        
        return loader;
    }
}
