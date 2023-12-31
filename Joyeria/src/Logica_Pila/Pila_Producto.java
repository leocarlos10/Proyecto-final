/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Pila;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author Caleb, Moises, Leocarlos
 */
public class Pila_Producto {

    public Stack<Producto> pila;

    public Pila_Producto() {

        pila = new Stack<>();
    }
    
    public Producto getProducto(String precio){
        
        Producto p = null;
        for (Producto i : pila) {
             if(i.getPrecio().equals(precio))
                p = i;
        }
        
        return p;
    }

    public void setPushProducto(Producto p) {

        pila.push(p);
    }

    public void guardar_P_fichero(Producto p) throws Exception {

        // utilizamos la clase FileWriter para poder escribir en el fichero 
        FileWriter escritura = new FileWriter(
                "src/Archivos/carrito.txt",
                true);
        escritura.write(p.escribir());
        escritura.close();
    }

    public void getP_carrito() {

        try {

            File archivo = new File("src/Archivos/carrito.txt");
            Scanner scanner = new Scanner(archivo);
            Producto pro = null;
            String atributo = "";
            // atributos para poder instanciar el objeto pelicula
            String nombre = "";
            String precio = "";
            String talla = "";
            String cantidad = "";

            // utilizo este arrayList para poder capturar la informacion del fichero.
            List<String> info = new ArrayList<>();

            // recorro el fichero para ir guardando cada atributo en la lista
            while (scanner.hasNextLine()) {
                atributo = scanner.nextLine();
                // con esto evitamos que nos traiga un valor vacio.
                if (!atributo.equalsIgnoreCase("")) {
                    info.add(atributo);
                }
            }

            // ahora recorremos la lista de info para poder crear los objetos y guardarlos en la pila
            for (int i = 0; i < info.size(); i += 4) {

                if (!info.isEmpty()) {
                    nombre = info.get(i);
                    precio = info.get(i + 1);
                    talla = info.get(i + 2);
                    cantidad = info.get(i + 3);
                    // creamos el objeto
                    pro = new Producto(nombre, precio, talla, cantidad);
                    // por ultimo lo agregamos a la pila
                    pila.push(pro);
                }
            }
            // cerramos el flujo.
            scanner.close();

        } catch (Exception e) {

            System.out.println("Error al traer los datos del fichero, por favor revise la ruta del fichero"+ e);
        }
    }

    public Producto getProduto(String nombre) {

         for (Producto i : pila) {

            if (i.getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }

        return null;
    }

    public void eliminar_carrito() {

        File ruta = new File("src/Archivos/carrito.txt");

        // este condicional es para verificar si se borro correctamente o no el fichero
        if (ruta.delete()) {

            System.out.println("archivo borrado");
        } else {
            System.out.println("el archivo no se pudo borrar");
        }
    }

    
    public void eliminarPro(String precio){
        
        // primero eliminamos el fichero del carrito
        eliminar_carrito();
        
        // luego eliminamos el producto de la pila
        
        for(int i =0; i< pila.size();i++){
            
            if(pila.get(i).getPrecio().equals(precio))
                pila.remove(i);
        }
        
        // posteriormente guardamos los productos restantes de nuevo en el fichero
        for (Producto i : pila) {

            try {
                guardar_P_fichero(i);
            } catch (Exception e) {
                System.out.println("no se pudo guardar el producto en el fichero carrito");
            }

        }
    }
    
    public void guardar_precio(String precio) throws Exception {
        
        // utilizamos la clase FileWriter para poder escribir en el fichero 
        FileWriter escritura = new FileWriter(
                "src/Archivos/precio.txt");
        escritura.write(precio);
        escritura.close();
        
    }
    
    public String getprecio() throws Exception{
        
        File archivo = new File("src/Archivos/precio.txt");
        Scanner scanner = new Scanner(archivo);
        String atributo = "";
        String precio = "";
        while (scanner.hasNextLine()) {
            atributo = scanner.nextLine();
            // con esto evitamos que nos traiga un valor vacio.
            if (!atributo.equalsIgnoreCase("")) {
                precio = atributo;
            }
        }
        return precio;
    }

    
    // metodo general para mostrar avisos de informacion
    public void aviso_info(String titulo, String info) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setContentText(info);
        alerta.show();
    }
}
