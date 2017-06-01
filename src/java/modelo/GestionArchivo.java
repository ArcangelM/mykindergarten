/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 *
 * @author arK
 */
public class GestionArchivo {
  
  
   
       Childrens objetochildr=null;
       ArrayList<Childrens> childrensArreglo=new ArrayList();
    
       
     
    File   archivochildrens= new File("src/Archivos/archivChildrens.txt");
    
    public int numero(){
        return 10;
    }
    public void comprobarBaseDatos(){//veerificacion y creacion de base de datos en archivo
        try
      {
        //Varialble con la ruta donde esta el archivo de la bd de los productos  
        //File archivochildrens= new File("./Bd/productos.txt");
        //crear el fichero de base de datos de productos   
        if(!archivochildrens.exists())
        {
            archivochildrens.createNewFile();
            
        }
        
        
        
        
       }catch (Exception ex) 
       {  
          //Captura un posible error le imprime en pantalla   
        System.out.println(ex.getMessage());  
       }
     }
    
    
     
    
    
    
   
     public ArrayList<Childrens> deArchivoAarreglo() //Este metodo recuperara del archivo la base de datos y la ubicara en un arreglo de empleado
     {  System.out.println("ENCONTRE el archivo metodo de archivo a arreglo");
        try
        {
         
         try (BufferedReader leerFichero = new BufferedReader (new FileReader(archivochildrens.getAbsolutePath()))) {
              
             System.out.println("ENtre al buffer");
              String linea = null;
             while ((linea = leerFichero.readLine()) != null) {
                 System.out.println("ENtre al while");
                 //este bucle es para meter todos los datos leidos de archivo de texto separlo en atributos y convertirlos a objeto para poder trabajar con el
                 //en esta parte le digo que lo separe en tokens
                 String madre;
                 String padre;
                 String nombr;
                 String  iden;
                 String  ed ;
                 
                 StringTokenizer mistokens = new StringTokenizer(linea, " ");
                 
                 iden =  mistokens.nextToken().trim(); //trim elimina los espacios
                 System.out.println(iden);
                 nombr =  mistokens.nextToken().trim();
                 ed =  mistokens.nextToken().trim();
                 padre =  mistokens.nextToken().trim();
                 madre =  mistokens.nextToken().trim();
                 int ident=Integer.parseInt(iden);
                 int edad=Integer.parseInt(ed);
                 //lo paso al constructor para que me cree los objetos
                 objetochildr= new Childrens(ident,nombr,edad,padre,madre);
                 
                 //lo añado al vecto para poder jugetear con el
                 childrensArreglo.add(objetochildr);
                 
//            for (Childrens chi:childrensArreglo ){
//               System.out.println(chi.getId()+" "+chi.getName()+" "+chi.getPadre()+" "+chi.getEdad()+" "+chi.getMadre());
//             }
             } //fin while
//         for (Childrens chi:childrensArreglo ){
//               System.out.println(chi.getId()+" "+chi.getName()+" "+chi.getPadre()+" "+chi.getEdad()+" "+chi.getMadre());
//             }
         }catch (Exception ex) 
       {  
          //Captura un posible error le imprime en pantalla   
         System.out.println("no entre al segundo try"+ex.getMessage());  
       }
         
       
       }catch (Exception ex) 
       {  
         System.out.println(ex.getMessage()); 
           //Captura un posible error le imprime en pantalla   
         // JOptionPane.showMessageDialog(null,ex.getMessage());  
       }
        return childrensArreglo;
      }
     
    /*METODO QUE IRA ACTUALIZANDO EL ARREGLO CREADO PARA LOS EMPLEADOS*/
     public void ActualizarArraList()
   {
      //Este es el ArrayList declarado para almacenar los empleados  
      childrensArreglo.clear();
      
     
      deArchivoAarreglo(); 
      
   }
  
//        public static void main(String [] args){
//        GestionArchivo obj = new GestionArchivo();
//        obj.deArchivoAarreglo().forEach((chi) -> {
//            System.out.println(chi.getId()+" "+chi.getName()+" "+chi.getPadre()+" "+chi.getEdad()+" "+chi.getMadre());
//           });
//    
//    
//    }
   
  
   
          
       
   
     
}//
