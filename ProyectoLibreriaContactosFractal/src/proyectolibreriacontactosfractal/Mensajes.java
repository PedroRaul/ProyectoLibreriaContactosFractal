//https://github.com/PedroRaul/ProyectoLibreriaContactosFractal.git
package proyectolibreriacontactosfractal;

import javax.swing.JOptionPane;


public class Mensajes {
  
    
    public static int mostrarDialogoCapturaInteger(String mensaje){
        
        return Integer.parseInt(JOptionPane.showInputDialog(null,mensaje));
    
    }
    
    public static String mostrarDialogoCapturaString(String mensaje){
    
        return JOptionPane.showInputDialog(null,mensaje);
    } 
    
    public static void mostrarDialogo(String mensaje){
    
         JOptionPane.showMessageDialog(null,mensaje);
    } 
}
