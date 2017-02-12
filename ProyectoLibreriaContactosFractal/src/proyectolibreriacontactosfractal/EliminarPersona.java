//
package proyectolibreriacontactosfractal;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author naat
 */
public class EliminarPersona {
    
    public void eliminar(String tabla,String codigo){
        
        conexion conex = new conexion();
        
        try{
            Statement estatuto;
            estatuto= conex.getConnection().createStatement();
            estatuto.executeQuery("DELETE FROM'"+tabla+"WHERE Idpersona='"+codigo+"'");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Registro no eliminado");
        }
        
        
        
    }
    
}
