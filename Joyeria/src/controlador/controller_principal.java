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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


/**
 * 
 *
 * @author Leocarlos, moises, caleb
 */
public class controller_principal implements Initializable {
    
    // componentes FXML
     @FXML
    private ComboBox<Button> combo_categorias;

    @FXML
    private ImageView usuario;
    
     @FXML
    private ComboBox<Button> combo_opciones;
     
     @FXML
    private TextField text_buscar;
     
     boolean estado_textbuscar=false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // cargamos el comboBox de las categorias y el de las opciones de la cuenta
        Cargar_combo_categorias();
        Cargar_combo_opciones();
        // con este hacemos que cuando el cursor este sobre los comboBox se vuelvan una manito.
        combo_opciones.setCursor(Cursor.HAND);
        combo_categorias.setCursor(Cursor.HAND);
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
        // con este condicional verifico que el evento de accione solo cuando se presione la tecla enter
        if(event.getCode() == KeyCode.ENTER){
            text_buscar.setText("");
            text_buscar.setVisible(false);
        }
        // agregar el codigo para que muestre la venta del producto buscado
    }
    
    // metodos que cargan los comboBox.
    public void Cargar_combo_categorias(){
        
        Button anillos_hombre = new Button("Anillos de hombre");
        anillos_hombre.setPrefWidth(150);
        Button anillos_mujer = new Button("Anillos de mujer");
         anillos_mujer.setPrefWidth(150);
        Button cadenas_hombre = new Button("Cadenas de hombre");
         cadenas_hombre.setPrefWidth(150);
        Button cadenas_mujer = new Button("Cadenas de mujer");
         cadenas_mujer.setPrefWidth(150);
        combo_categorias.getItems().addAll(anillos_hombre,anillos_mujer,cadenas_hombre,cadenas_mujer);
    }
    
     public void Cargar_combo_opciones(){
        
        Button incio_sesion = new Button("Inicio de sesion");
        incio_sesion.setPrefWidth(150);
        Button registro = new Button("Registrarse");
        registro.setPrefWidth(150);
        Button historial = new Button("Historial de compra");
        historial.setPrefWidth(150);
        combo_opciones.getItems().addAll(incio_sesion,registro,historial);
    }
}
