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
    
    protected final static String nombrebasededatos = "datos";
    protected final String usuario="root";
    protected final String contraseña="";
    static final String url = "jdbc:mysql://localhost/"+nombrebasededatos; 
    
    Connection conexion = null;
    
    public conexion(){
       
    }
    public Connection getConnection(){
        return conexion;
    }
    
    public void conectar(){
     try{
        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection(url,usuario,contraseña);
        
        if(conexion != null){
            System.out.println("conexion segura "+nombrebasededatos+" ok");
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
    public void desconectar(){
        conexion = null;
    }
    
    
    
    
    
}
