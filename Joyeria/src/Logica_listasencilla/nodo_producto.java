/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_listasencilla;

import Logica_Pila.*;

/**
 *
 * @author Caleb, Moises , Leocarlos
 */
public class nodo_producto {
    
    private String nombre;
    private String precio;
    private String emailUs;
    private String talla;
    private String cantidad;
    public nodo_producto ant,sig;
    

    public nodo_producto(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEmailUs() {
        return emailUs;
    }

    public void setEmailUs(String emailUs) {
        this.emailUs = emailUs;
    }
    
    public String escribir(){
        
        return nombre+"\n"+precio+"\n";
    }
    
      public String escribir2(){
        
        return nombre+"\n"+precio+"\n"+emailUs+"\n";
    }
}
