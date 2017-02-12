package proyectolibreriacontactosfractal;

import java.sql.*;
import javax.swing.JOptionPane;

public class Busqueda {
    
    public Contacto busquedaDeportista(String nombre,String apellidopaterno,String apellidomaterno){
	conexion conex= new conexion();
        Contacto contacto=new Contacto();
        contacto=new Deportista();
        boolean existe=false;
	try{
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement
                ("select Nombre,ApePa,ApeMa,Genero,FechaNac,Deporte from Deportista dep where dep.Nombre = ? "
                +" and dep.ApePa= ? "+"and dep.ApeMa= ? ");
            
            consulta.setString(1, contacto.getNombre());
            consulta.setString(2, contacto.getApellidoPaterno());
            consulta.setString(3, contacto.getApellidoMaterno());
            ResultSet res = consulta.executeQuery();
            
            while(res.next()){
                existe=true;
                contacto.setNombre(res.getString("Nombre"));
		contacto.setApellidoPaterno(res.getString("ApePa"));
		contacto.setApellidoMaterno(res.getString("ApeMa"));
                ((Deportista)contacto).setGenero(res.getString("Genero"));
                ((Deportista)contacto).setFechaNacimiento(res.getString("FechaNac"));
                ((Deportista)contacto).setDeporte(res.getString("Deporte"));
            }
            consulta.close();
            res.close();
            conex.desconectar();
            JOptionPane.showMessageDialog(null, consulta);
            } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            System.out.println(e);
	}
        
	if (existe) {
            return contacto;
	} else {return null;}	
    }
//--------------------------------------------------------------------------------------------------
    public Contacto busquedaDoctor(String nombre,String apellidopaterno,String apellidomaterno){
        conexion conex= new conexion();
        Contacto contacto=new Contacto();
        contacto=new Doctor();
        boolean existe=false;
        try{
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement("select Nombre,ApePa,ApeMa,FechaNac,Especialidad,NombreH,DireccionH from Doctor doc where doc.Nombre = ? "
    				+" and doc.ApePa= ? "+"and doc.ApeMa= ? ");
            consulta.setString(1, contacto.getNombre());
            consulta.setString(2, contacto.getApellidoPaterno());
            consulta.setString(3, contacto.getApellidoMaterno());
            ResultSet res = consulta.executeQuery();
            
            while(res.next()){
            existe=true;
            contacto.setNombre(res.getString("Nombre"));
            contacto.setApellidoPaterno(res.getString("ApePa"));
            contacto.setApellidoMaterno(res.getString("ApeMa"));
            ((Doctor)contacto).setFechaNacimiento(res.getString("FechaNac"));
            ((Doctor)contacto).setEspecialidad(res.getString("Especialidad"));
            ((Doctor)contacto).setNombreHospital(res.getString("NombreH"));
            ((Doctor)contacto).setDireccionHospital(res.getString("DireccionH"));
            }
            consulta.close();
            res.close();
            conex.desconectar();
            JOptionPane.showMessageDialog(null, consulta);
            } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            System.out.println(e);
	}
        
	if (existe) {
            return contacto;
	} else {return null;}	
    }
//--------------------------------------------------------------------------------------------------
    public Contacto busquedaEstudiante(String nombre,String apellidopaterno,String apellidomaterno){
        conexion conex= new conexion();
        Contacto contacto=new Contacto();
        contacto=new Estudiante();
        boolean existe=false;
        try{
            PreparedStatement consulta;    
            consulta = conex.getConnection().prepareStatement
                    ("select Nombre,ApePa,ApeMa,LugarNac,FechaNac,Carrera,Email from Estudiante est where est.Nombre = ? "
    				+" and est.ApePa= ? "+"and est.ApeMa= ? ");
            consulta.setString(1, contacto.getNombre());
            consulta.setString(2, contacto.getApellidoPaterno());
            consulta.setString(3, contacto.getApellidoMaterno());
            ResultSet res = consulta.executeQuery();
            
            while(res.next()){
                existe=true;
                contacto.setNombre(res.getString("Nombre"));
		contacto.setApellidoPaterno(res.getString("ApePa"));
		contacto.setApellidoMaterno(res.getString("ApeMa"));
                ((Estudiante)contacto).setLugarNacimiento(res.getString("LugarNac"));
                ((Estudiante)contacto).setFechaNacimiento(res.getString("FechaNac"));
                ((Estudiante)contacto).setEstudiaCarrera(res.getString("Carrera"));
                ((Estudiante)contacto).setEmail(res.getString("Email"));
            }
            consulta.close();
            res.close();
            conex.desconectar();
            JOptionPane.showMessageDialog(null, consulta);
            } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            System.out.println(e);
	}
        
	if (existe) {
            return contacto;
	} else {return null;}	
    }
//--------------------------------------------------------------------------------------------------
    public Contacto busquedaLicenciado(String nombre,String apellidopaterno,String apellidomaterno){
	conexion conex= new conexion();
        Contacto contacto=new Contacto();
        contacto=new Licenciado();
        boolean existe=false;
        try{
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement
                        ("select Nombre,ApePa,ApeMa,TelOficina,HorarioIn,HorarioFin from Licenciado lic where lic.Nombre = ? "
    				+" and lic.ApePa= ? "+"and lic.ApeMa= ? ");
            consulta.setString(1, contacto.getNombre());
            consulta.setString(2, contacto.getApellidoPaterno());
            consulta.setString(3, contacto.getApellidoMaterno());
            ResultSet res = consulta.executeQuery();
            
            while(res.next()){
                existe=true;
                contacto.setNombre(res.getString("Nombre"));
		contacto.setApellidoPaterno(res.getString("ApePa"));
		contacto.setApellidoMaterno(res.getString("ApeMa"));
                ((Licenciado)contacto).setTelefonoOficina(res.getString("TelOficina"));
                ((Licenciado)contacto).setHorarioAtencionInicio(res.getString("HorarioIn"));
                ((Licenciado)contacto).setHorarioAtencionFin(res.getString("HorarioFin"));
            }
            consulta.close();
            res.close();
            conex.desconectar();
            JOptionPane.showMessageDialog(null, consulta);
            } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            System.out.println(e);
	}
        
	if (existe) {
            return contacto;
	} else {return null;}	
    }
//--------------------------------------------------------------------------------------------------
    public Contacto busquedaPersona(String nombre,String apellidopaterno,String apellidomaterno){
        conexion conex= new conexion();
        Contacto contacto=new Contacto();
        contacto=new Persona();
        boolean existe=false;
	try{
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement
                        ("select Nombre,ApePa,ApeMa,Domicilio,MedioPreferido,Ocupacion from Persona per where per.Nombre = ? "
    				+" and per.ApePa= ? "+"and per.ApeMa= ? ");
            consulta.setString(1, contacto.getNombre());
            consulta.setString(2, contacto.getApellidoPaterno());
            consulta.setString(3, contacto.getApellidoMaterno());
            ResultSet res = consulta.executeQuery();
            
            while(res.next()){
                existe=true;
                contacto.setNombre(res.getString("Nombre"));
		contacto.setApellidoPaterno(res.getString("ApePa"));
		contacto.setApellidoMaterno(res.getString("ApeMa"));
                ((Persona)contacto).setDomicilio(res.getString("Domicilio"));
                ((Persona)contacto).setContactoPreferido(res.getString("MedioPreferido"));
                ((Persona)contacto).setOcupacion(res.getString("Ocupacion"));
            }
            consulta.close();
            res.close();
            conex.desconectar();
            JOptionPane.showMessageDialog(null, consulta);
            } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            System.out.println(e);
	}
        
	if (existe) {
            return contacto;
	} else {return null;}	
    }
}	