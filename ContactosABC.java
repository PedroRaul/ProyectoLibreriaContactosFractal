/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolibreriacontactosfractal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LT
 */
public class ContactosABC {
    
    
    public static conexion conexion;
    public static String query=null;
    public static final String tabladeportista="deportista";
    public static final String tabladoctor="doctor";
    public static final String tablaestudiante="estudiante";
    public static final String tablalicenciado="licenciado";
    public static final String tablapersona="persona";
    public static final String tablacontacto="contacto";
    public static final String camponombre="Nombre";
    public static final String campotelefonooficina="TelOficina";
    public static final String campoapellidopaterno="ApePa";
    public static final String campoapellidomaterno="ApeMa";
    public static final String campoprofesion="Profesion";
    public static final String campohorarioinicial="HorarioIn";
    public static final String campohorariofinal="HorarioFin";
    public static final String campodomicilio="Domicilio";
    public static final String campomediodecontactopreferido="MedioPreferido";
    public static final String campoocupacion="Ocupacion";
    public static final String campogenero="Genero";
    public static final String campofechadenacimiento="FechaNac";
    public static final String campodeporte="Deporte";
    public static final String campoespecialidad="Especialidad";
    public static final String camponombrehospital="NombreH";
    public static final String campodireccionhospital="DireccionH";
    public static final String campolugardenacimiento="LugarNac";
    public static final String campocarrera="Carrera";
    public static final String campoidpersona="idPersona";
    public static String campocontactos="Contactos";
    
    
    
    public static void guardarDatosContacto(String query){
        
        conexion=new conexion();
        
         conexion.conectar();
        try{
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate(query);
            Mensajes.mostrarDialogo("Se ha Registrado Exitosamente");
            estatuto.close();
            conexion.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            Mensajes.mostrarDialogo("Error en el registro intente de nuevo");
        }
    }
    
    
    
    public static void DatoEliminado(String queryDato){
        conexion= new conexion();
        conexion.conectar();
        
        try{
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate(queryDato);
            
            Mensajes.mostrarDialogo("Se ha eliminado correctamente");
            estatuto.close();
            conexion.desconectar();
        }catch(SQLException e){
            System.out.println(e.getMessage());
          
            Mensajes.mostrarDialogo("Ha ocurrido un error en la eliminacion");
        }
        }
   
    
    
    
    
    
    
    
    public static int Id(String dato,String nombre,String apellidoPaterno,String apellidoMaterno){
       conexion=new conexion();
        conexion.conectar();
        int numero = 0;
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement
            ("SELECT * From "+dato+" WHERE Nombre='"+nombre+"'"
            + "AND ApePa='"+apellidoPaterno+"'"
            + "AND ApeMa='"+apellidoMaterno+"'");
            
            System.out.println(consulta);
            ResultSet res= consulta.executeQuery();
            if(res.next() ) 
            res.last();
            numero= Integer.parseInt(res.getString("IdPersona"));
           
            System.out.println(numero);
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            Mensajes.mostrarDialogo(" Error al arrojar datos");
            
        }
        conexion.desconectar();
           System.out.println(numero);   
        return numero; 
      
    }
    
    public static int verIdMaximo(String tabla)
    
    {
        conexion=new conexion();
        conexion.conectar();
        int resultado = 0;
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement
            ("SELECT * From "+tabla+" ");
            ResultSet res= consulta.executeQuery();
            if(res.next() ) 
            res.last();
            resultado= Integer.parseInt(res.getString("IdPersona"));
           
            
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            Mensajes.mostrarDialogo(" Error en el registro intente de nuevo");
            
        }
        conexion.desconectar();
            
        return resultado; 
            
    }
    
    
    
     public static void guardarMedioContacto(String query){
        
        conexion=new conexion();
        
         conexion.conectar();
        try{
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate(query);
            Mensajes.mostrarDialogo("Se ha Registrado Exitosamente");
            estatuto.close();
            conexion.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            Mensajes.mostrarDialogo("Error en el registro intente de nuevo");
        }
    
    
}
   
       
     
     
     
}
