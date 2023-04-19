/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejermsdos;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Jennifer
 */
public class EjerMSDOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //CREACION DE ESTRUCTURA
      //Directorio principal
        //DefinicionCAMBIAR RUTA 
        File dirPadre = new File("DIRECTORIO");
        //Creación
        System.out.println(crearDir(dirPadre));
        
      //Directorios secundarios
        //Definicion
        File apli = new File(dirPadre,"APLI");
        File prog = new File(dirPadre,"PROG");
        File varios = new File(dirPadre,"VARIOS");
        //Creación
        System.out.println(crearDir(apli));
        System.out.println(crearDir(prog));
        System.out.println(crearDir(varios));
        
      //Directorios terciarios
        //APLI-Definicion
        File word = new File(apli,"WORD");
        File access = new File(apli,"ACCESS");
        File excel = new File(apli,"EXCEL");
        //Creación
        System.out.println(crearDir(word));
        System.out.println(crearDir(access));
        System.out.println(crearDir(excel));
        
        //BASIC-Definicion
        File basic = new File(prog,"BASIC");
        File pascal = new File(prog,"PASCAL");
        File fortrant = new File(prog,"FORTRANT");
        //Creación
        System.out.println(crearDir(basic));
        System.out.println(crearDir(pascal));
        System.out.println(crearDir(fortrant));
        
        
    //IMPRIME LOS DIRECTORIOS
        listArbol(dirPadre,"");
               
        //Eliminamos la carpeta varios y pascal
        System.out.println(borrarDir(varios));
        System.out.println(borrarDir(pascal));
    //IMPRIME LOS DIRECTORIOS DE APLI
        listArbol(apli,""); 
        //CREAMOS EN WORD UNA SUBCARPETA LLAMADA NUEVO
        File nuevo = new File(word,"NUEVO");
        System.out.println(crearDir(nuevo));
        
        //CAMBIAMOS EL NOMBRE DE LAS CARPETAS
         
         System.out.println(cambiarNom(fortrant,"JAVA"));
         System.out.println(cambiarNom(basic,"PHP"));
         
         listArbol(dirPadre,"");
               
    }
    
    /**
     * Método recursivo para listar directorios
     * @param f
     * @param spaces 
     */
    public static void listArbol(File f, String spaces){
        System.out.println(spaces.concat(File.separator).concat(f.getName()));
        if (f.isDirectory() && f.canRead()) {
            for (File file  : f.listFiles()) {
                listArbol(file, spaces.concat("  |__"));
            }
        }      
    }
    /**
     * 
     * @param f
     * @return 
     */
    public static String crearDir(File f){
       if(f.mkdir()){
         return "El directorio "+f.getName()+" se ha creado";
       }else{
           return "No se ha podido crear el directorio "+f.getName()+", puede que ya exista";
       }
       
    }
    /**
     * 
     * @param f
     * @return 
     */
    public static String borrarDir(File f){
        if(f.delete()){
         return "El directorio "+f.getName()+" se ha eliminado";
       }else{
           return "No se ha podido eliminar el directorio "+f.getName();
       }
    }
    /**
     * 
     * @param f
     * @param nombre
     * @return 
     */
    public static String cambiarNom(File f,String nombre){
         if(f.renameTo(new File(f.getParent()+File.separator+nombre))){
              return "La carpeta "+f.getName()+" ha cambiado de nombre por "+nombre;
          }else{
              return "No se ha podido cambiar el nombre";
          }
    }
}
