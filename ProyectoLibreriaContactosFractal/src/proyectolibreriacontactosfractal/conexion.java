/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolibreriacontactosfractal;

import java.sql.Connection;

/**
 *
 * @author naat
 */
public class conexion {
    
    static String bd = "agenda";
    protected String login="root";
    protected String password="";
    static String url = "jdbc:mysql://localhost/"+bd; 
    
    Connection conn = null;
    
    public conexion(){
        
    }
    
    
    
    
    
    
    
    
}
