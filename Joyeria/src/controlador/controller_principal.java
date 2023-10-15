/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;


/**
 * 
 *
 * @author Leocarlos, moises, caleb
 */
public class controller_principal implements Initializable {
    
    // componentes FXML
    

    @FXML
    private ImageView usuario;
    
    @FXML
    private TextField text_buscar;
    
     @FXML
    private SplitMenuButton Menu_categorias;

    @FXML
    private SplitMenuButton menu_opciones;

     boolean estado_textbuscar=false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // cargamos en una lista los botones del comboBox de categorias y opciones
        String []opciones ={"Inicio de sesion","Registrarse","Historial de compra"};
        String[] categorias = { "Anillos de hombre","Anillos de mujer","Cadenas de hombre","Cadenas de mujer"};
        MenuItem item_opciones;
        MenuItem item_categorias;
        // este bucle for es el encargado de cargar los menuItem en el SplitMenuButton de opciones 
        // ademas de agregarle un evento a cada boton
        for(String i: opciones){
            
            item_opciones = new MenuItem(i);
            item_opciones.setOnAction(Event ->{
                
                manejo_eventos(i);
            });
            
            // luego lleno el comboBox de opciones
            menu_opciones.getItems().add(item_opciones);
            
        }
        
         // este bucle for es el encargado de cargar los MenuItem en el SplitMenuButton de categorias
        // ademas de agregarle un evento a cada boton
         for(String i: categorias){
             
            item_categorias = new MenuItem(i);
            item_categorias.setOnAction(Event ->{
                
                manejo_eventos(i);
            });
           
            // luego lleno el comboBox de opciones
            Menu_categorias.getItems().add(item_categorias);
           
        }
        
        // con este hacemos que cuando el cursor este sobre los comboBox se vuelvan una manito.
        menu_opciones.setCursor(Cursor.HAND);
        Menu_categorias.setCursor(Cursor.HAND);
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
    
    public void manejo_eventos(String nombre){
    
        // con un switch de Strings hago la verificacion correspondiente
        switch(nombre){
            
            case "Inicio de sesion":
                JOptionPane.showMessageDialog(null, "Evento generado para el inicio de sesion");
                break;

            case "Registrarse":
                JOptionPane.showMessageDialog(null, "Evento generado para el Registrarse");
                break;

            case "Historial de compra":
                JOptionPane.showMessageDialog(null, "Evento generado para el Historial de compra");
                break;

            case "Anillos de hombre":
                JOptionPane.showMessageDialog(null, "Evento generado para anillo de hombre");
                break;

            case "Anillos de mujer":
                JOptionPane.showMessageDialog(null, "Evento generado para anillos de mujer");
                break;

            case "Cadenas de hombre":
                JOptionPane.showMessageDialog(null, "Evento generado para cadenas de hombre");
                break;

            case "Cadenas de mujer":
                JOptionPane.showMessageDialog(null, "Evento generado para cadenas de mujer");
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "no se ejecuto ningun evento");
                break;
        }
    }
}
