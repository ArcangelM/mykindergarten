/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.Stateless;
import modelo.Childrens;

/**
 *
 * @author arK
 */
@Stateless
public class UtilidadesDao {
    Childrens objetochildr=null;
//     File   archivochildrens= new File("C:/Users/arK/Desktop/archivChildrens.txt");
    ArrayList<Childrens> childrensArreglo=new ArrayList();
    public List<Childrens> listarArray(String ruta) {
//        File   archivochildrens= new File("C:/Users/arK/Desktop/archivChildrens.txt");
        File   archivochildrens= new File(ruta);
       System.out.println("ENCONTRE el archivo metodo de archivo a arreglo");
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
             leerFichero.close();
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
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
