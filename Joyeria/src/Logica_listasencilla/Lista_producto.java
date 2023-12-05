/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_listasencilla;

import Logica_Pila.Producto;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author Caleb, Moises, Leocarlos
 */
public class Lista_producto {
    
     public nodo_producto cab;
    
    public Lista_producto() { cab = null; }
    
       public nodo_producto getCrearNodo(
            String nombre,
            String precio
    ) {
        nodo_producto p = new nodo_producto(nombre, precio);
        return p;
    }
    
    
    public  nodo_producto getUltimo(){
        
        if(cab == null){
            
            return null;
        }else{
            
            // nodo auxiliar para recorrer la lista
             nodo_producto p=cab;
            // ahora con un while recorro la lista buscando el nodo el cual su apuntador sea = null
            // ya que ese sera el ultimo
            while(p.sig!=null){ // mientras el puntero no sea nulo no se rompe
                
                //mientres no se cumpla va a seguir avanznado en la lista
                p=p.sig;
            }
            return p;
        }
    }
    
    public boolean setAgregarFinal(String nombre, String precio){
        
        // creamos el nodo
        nodo_producto info = getCrearNodo(nombre, precio); 
        boolean band = false; // bandera que me ayude a saber si se guardo correctamente o no.
        // verifcamos si se creo correctamente para poder enlazarlo en la lista
        if(info!=null){
            
            if(cab==null){
                
                cab = info;
                System.out.println("Nodo agregado en la cabeza");
                band=true;
            }else{
                
                // buscamos el ultimo de la lista
                nodo_producto ultimo = getUltimo();
                ultimo.sig = info;
                System.out.println(" Nodo agregado al final de la lista");
                band= true;
            }
        } 
        return band;
    }
    
     // agregar en la clase lista sencilla
     public void guardar_P_favoritos(nodo_producto p) throws Exception {
        
        // utilizamos la clase FileWriter para poder escribir en el fichero 
        FileWriter escritura = new FileWriter(
                "src/Archivos/favoritos.txt",
                true);
        escritura.write(p.escribir());
        escritura.close();
        
    }
     
      // agregar en la clase cola
      public void get_P_favoritos(){
        
       try{
      
           File archivo = new File("src/Archivos/favoritos.txt");
           Scanner scanner = new Scanner(archivo);
           nodo_producto pro=null;
           String atributo="";
          // atributos 
          String nombre="";
          String precio="";
          
           // utilizo este arrayList para poder capturar la informacion del fichero.
           List<String> info = new ArrayList<>();
          
           // recorro el fichero para ir guardando cada atributo en la lista info
           while (scanner.hasNextLine()) {
                atributo = scanner.nextLine();
                // con esto evitamos que nos traiga un valor vacio.
                if(!atributo.equalsIgnoreCase(""))
                    info.add(atributo);
            }
            
           // ahora recorremos la lista de info para poder crear los objetos y guardarlos en la lista producto
           for(int i=0;i<info.size();i+=2){
              
               if (!info.isEmpty()) {
                   // obtenemos los atributos 
                   nombre = info.get(i);
                   precio = info.get(i+1);
                   // por ultimo lo agregamos a la lista
                   setAgregarFinal(nombre, precio);
               }
           }
           // cerramos el flujo.
            scanner.close();
       
       }catch(Exception e){
           
           aviso_Error("Error ", " Error al traer los datos del fichero, por favor revise la ruta del fichero"+e);
       }
    }
      
      public void mostrar() {
          
          if(cab != null){
              
              nodo_producto p = cab;
              
              while(p!=null){
                  
                  System.out.println(p.getNombre());
                  System.out.println(p.getPrecio());
                  p = p.sig;
              }
          }

    }

     // metodo general para mostrar avisos de informacion
    public void aviso_info(String titulo, String info){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setContentText(info);
        alerta.show();
    }
    // metodo general para mostrar avisos de errores
    public void aviso_Error(String titulo, String info){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setContentText(info);
        alerta.show();
    }
    // metodo general para captura de datos por pantalla
     public TextInputDialog aviso_captura_informacion(String titulo, String header, String info){
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titulo);
        dialog.setHeaderText(header);
        dialog.setContentText(info);
        
        return dialog;
    }
}
