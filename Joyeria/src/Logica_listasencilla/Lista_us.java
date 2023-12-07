/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_listasencilla;
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
public class Lista_us {
    
    nodo_usuario cab;
    
    public Lista_us() { cab = null; }
    
    // metodo para verificar si el correo del usuario que se esta ingresando es igual a un usuario ya registrado.
    public nodo_usuario getBuscarCorreo(String correo){
        
        nodo_usuario p;
        nodo_usuario repetido=null;
        
        if(cab != null){
            
            p = cab;
           while(p!=null){
               
               if (p.getCorreo().equals(correo))
                   repetido = p;
              
                p = p.sig;
           }
        }
        
        return repetido;
    }
    
    // metodo que me ayuda a verificar que no se encuentren usuarios con emails iguales en el fichero.
    public boolean verfCorreo(String correo){
        
        boolean band = false;
        // obtenemos la info del fichero
        getInfo_usuarios();
        // verificamos el correo
        nodo_usuario buscar = getBuscarCorreo(correo);
        // si buscar es diferente de null encontro un correo igual
        if(buscar != null){
            
            band = true;
        }
        
        // eliminamos los datos de la lista
        EliminarUs();
        
        // retornamos la bandera.
        return band;
    }
    
   
    // metodo encargado de crear el nodo_usuario.
    public nodo_usuario getCrearNodo(
            String correo,
            String pass
    ) {
        nodo_usuario p = new nodo_usuario(correo, pass);
        return p;
    }
    
    
    public nodo_usuario getUltimo(){
        
        if(cab == null){
            
            return null;
        }else{
            
            // nodo auxiliar para recorrer la lista
            nodo_usuario p=cab;
            // ahora con un while recorro la lista buscando el nodo el cual su apuntador sea = null
            // ya que ese sera el ultimo
            while(p.sig!=null){ // mientras el puntero no sea nulo no se rompe
                
                //mientres no se cumpla va a seguir avanznado en la lista
                p=p.sig;
            }
            return p;
        }
    }
    
    public boolean setAgregarFinal(String correo, String pass){
        
        // creamos el nodo
        nodo_usuario info = getCrearNodo(correo, pass);
        boolean band = false; // bandera que me ayude a saber si se guardo correctamente o no.
        // verifcamos si se creo correctamente para poder enlazarlo en la lista
        if(info!=null){
            
            if(cab==null){
                
                cab = info;
                System.out.println("Nodo agregado en la cabeza");
                band=true;
            }else{
                
                // buscamos el ultimo de la lista
                nodo_usuario ultimo = getUltimo();
                ultimo.sig = info;
                System.out.println(" Nodo agregado al final de la lista");
                band= true;
            }
        } 
        return band;
    }
    
    // metodo encargado de agregar los datos de los usuarios en un fichero de texto
    public void guardar_us_fichero() throws Exception {
        
        // utilizamos la clase FileWriter para poder escribir en el fichero los datos de los usuarios
        FileWriter escritura = new FileWriter(
                "src/Archivos/ListaUsuarios.txt",
                true);
        // recorremos la lista para guardar en el fichero el usuario agregado.
        if(cab!= null){
            
            nodo_usuario p = cab;
            while(p!=null){
                
                escritura.write(p.escribir());
                escritura.close();
                p = p.sig;
            } 
        }
    }
    
    public void getInfo_usuarios(){
        
       try{
      
           File archivo = new File("src/Archivos/ListaUsuarios.txt");
           Scanner scanner = new Scanner(archivo);
           nodo_usuario user = null;
           String atributo = "";
           // atributos para poder instanciar el objeto user
           String correo = "";
           String pass = "";

           // utilizo este arrayList para poder capturar la informacion del fichero.
           List<String> info = new ArrayList<>();
          
           // recorro el fichero para ir guardando cada atributo en la lista
           while (scanner.hasNextLine()) {
                atributo = scanner.nextLine();
                // con esto evitamos que nos traiga un valor vacio.
                if(!atributo.equalsIgnoreCase(""))
                    info.add(atributo);
            }
            
           // ahora recorremos la lista de info para poder crear los objetos y guardarlos en la lista enlazada.
           for(int i=0;i<info.size();i+=2){
              
               if (!info.isEmpty()) {
                   // guardamos los valores en la variables
                   correo = info.get(i);
                   pass = info.get(i+1);
                   // por ultimo lo agregamos a la lista
                   setAgregarFinal(correo, pass);
               }
           }
           // cerramos el flujo.
            scanner.close();
       
       }catch(Exception e){
           
           System.out.println("Error al traer los datos del fichero, por favor revise la ruta del fichero "+e);
       }
    }
    
    // este metodo elimina los usuarios de la lista.
    public void EliminarUs() {

        if(cab != null){
            
            if(cab.sig == null){
                
                cab = null;
                System.out.println("Usuario elimiando de la cabeza de la lista");
            }else{
             
                nodo_usuario actual = cab;
                while (actual != null) {
                    nodo_usuario siguiente = actual.sig; // Guardamos el nodo sig
                    actual.sig = null; // desconectamos al nodo actaul
                    actual = siguiente; // Movemos al siguiente nodo
                }
                cab = null; // finalmente, establecemos la cabeza en null
                System.out.println("Todos los usuarios han sido eliminados");
            }
            
        }
       
    }
    
    public String verfInicioSesion(String correo, String pass){
        
        String email = "";
        // recorremos la lista enlazada para buscar el usuario.
        if(cab!=null){
            
            nodo_usuario p = cab;
            while(p!=null){
                
                if(p.getCorreo().equals(correo) && p.getPassword().equals(pass))
                    email = p.getCorreo();
                
                p= p.sig;
            }
        }
        return email;
    }
    
    // este metodo se encarga de guardar el usuario que ha iniciado sesion
     public void usuario_inicio_sesion(String email) throws Exception {
        
        // utilizamos la clase FileWriter para poder escribir en el fichero 
        FileWriter escritura = new FileWriter(
                "src/Archivos/usuarioIniciosesion.txt",
                true);
        escritura.write(email);
        escritura.close();
        
    }
     
      public void cerrarsesion() throws Exception{
         
         File ruta = new File("src/Archivos/usuarioIniciosesion.txt");
        
         // este condicional es para verificar si se borro correctamente o no el fichero
        if(ruta.delete()){
            
            System.out.println("archivo borrado");
        } else{
            System.out.println("el archivo no se pudo borrar");
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
}
