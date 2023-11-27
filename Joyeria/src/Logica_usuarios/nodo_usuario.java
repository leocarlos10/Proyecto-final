/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_usuarios;

/**
 *
 * @author Caleb, Moises, Leocarlos
 */
public class nodo_usuario {
    
    private String correo;
    private String password;
    nodo_usuario sig;

    public nodo_usuario(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String escribir(){
        
        return correo+"\n"+password+"\n";
    }
}
