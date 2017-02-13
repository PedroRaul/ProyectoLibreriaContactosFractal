/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolibreriacontactosfractal;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author naat
 */
public class Validaciones {
    
      public static boolean validarString(String cadena){ //valida los campos cadena
         boolean bandera = true;
           Pattern pat = Pattern.compile("[A-Za-z]");      
     Matcher mat = pat.matcher(cadena);
    
         
     if (mat.find()) {
         bandera = true;
     } else {
         bandera = false;
          JOptionPane.showMessageDialog(null,
                    "El ID de registro de la "
                    + "persona debe ser de 3 digitos (Mínimo)",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
        
     }
     
    return bandera;
    }
      
     
    public boolean validar(String cadena) {
      if (cadena.matches("[0-9]*")) {
         return true;
      } else {
         return false;
      }
   }
 
   public int convertir(String numero) {
      // Se reemplazan todos los caracteres que no correspondan a un numero
      // por espacio
      numero = numero.replaceAll("[^0-9]", "");
 
      // Si la cadena queda vacia
      if (numero.equals("")) {
         numero = "0";
      }
 
      return Integer.parseInt(numero);
   }
   
   public static boolean ValidarCadenaVacia(String cadena){
       if(cadena.equals("")){
           return true;
       }else{
           return false;
       }
   }
 
}
      
      
      
   

