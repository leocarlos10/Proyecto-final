/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_cola;

import Logica_Pila.Producto;
import Logica_listasencilla.nodo_producto;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.control.Alert;

/**
 *
 * @author Caleb, Moises, Leocarlos
 */
public class cola_producto {
    
    public nodo_producto inicio;

    public cola_producto() {
        inicio = null;
    }

    // creacion del nodo producto.
    public nodo_producto getCrearNodo(
            String nombre,
            String precio,
            String emailus
    ) {

        nodo_producto pro = new nodo_producto(nombre, precio);
        pro.setEmailUs(emailus);

        return pro;
    }

    public void setAgregar(
            String nombre,
            String precio,
            String emailus
    ) {

        nodo_producto info = getCrearNodo(nombre, precio, emailus);

        if (info != null) {
            if (inicio == null) {
                inicio = info;
                inicio.sig = inicio.ant = inicio;
                System.out.println("Elemento agregado en la cola");
            } else {
                info.ant = inicio.ant;
                info.sig = inicio;
                inicio.ant.sig = info;
                inicio.ant = info;
                System.out.println("Elemento agregado al final de la cola");
            }
        }
    }

    public void guardar_P_Historial(nodo_producto p) throws Exception {

        // utilizamos la clase FileWriter para poder escribir en el fichero 
        FileWriter escritura = new FileWriter(
                "src/Archivos/historialcompra.txt",
                true);
        escritura.write(p.escribir2());
        escritura.close();

    }
    
     public void guardar_P_Historial(Producto p) throws Exception {

        // utilizamos la clase FileWriter para poder escribir en el fichero 
        FileWriter escritura = new FileWriter(
                "src/Archivos/historialcompra.txt",
                true);
        escritura.write(p.escribir2());
        escritura.close();

    }

    public void get_P_historial() {

        try {

            File archivo = new File("src/Archivos/historialcompra.txt");
            Scanner scanner = new Scanner(archivo);
            nodo_producto pro = null;
            String atributo = "";
            // atributos 
            String nombre = "";
            String precio = "";
            String emailus = "";

            // utilizo este arrayList para poder capturar la informacion del fichero.
            List<String> info = new ArrayList<>();

            // recorro el fichero para ir guardando cada atributo en la lista info
            while (scanner.hasNextLine()) {
                atributo = scanner.nextLine();
                // con esto evitamos que nos traiga un valor vacio.
                if (!atributo.equalsIgnoreCase("")) {
                    info.add(atributo);
                }
            }

            // ahora recorremos la lista de info para poder crear los objetos y guardarlos en la lista producto
            for (int i = 0; i < info.size(); i += 3) {

                if (!info.isEmpty()) {
                    // obtenemos los atributos 
                    nombre = info.get(i);
                    precio = info.get(i + 1);
                    emailus = info.get(i + 2);
                    // por ultimo lo agregamos a la lista
                    setAgregar(nombre, precio, emailus);
                }
            }
            // cerramos el flujo.
            scanner.close();

        } catch (Exception e) {

            System.out.println("Error la traer los datos del fichero historial compra" +e);
        }
    }
    
     public String getEmail(){
         
       String correo = "";
       
       try{
      
           File archivo = new File("src/Archivos/usuarioIniciosesion.txt");
           Scanner scanner = new Scanner(archivo);
           String atributo = "";
           
           // recorro el fichero para ir guardando cada atributo en la lista
           while (scanner.hasNextLine()) {
                atributo = scanner.nextLine();
                // con esto evitamos que nos traiga un valor vacio.
                if(!atributo.equalsIgnoreCase(""))
                    correo = atributo;
            }
           // cerramos el flujo.
            scanner.close();
       
       }catch(Exception e){
           
           System.out.println("Error el fichero esta borrado");
       }
       return correo;
    }

}
