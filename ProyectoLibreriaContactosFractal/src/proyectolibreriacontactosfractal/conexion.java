/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolibreriacontactosfractal;

import java.sql.*;
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
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url,login,password);
        
        if(conn != null){
            System.out.println("conexion segura"+bd+"ok");
        }
        
    }
        catch(SQLException e){
            System.out.println(e);
    }catch(ClassNotFoundException e){
            System.out.println(e);
    }catch(Exception e){
            System.out.println(e);
    }
    }
    public Connection getConnection(){
        return conn;
    }
    public void desconectar(){
        conn = null;
    }
    
    
    
    
    
}
