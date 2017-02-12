//
package proyectolibreriacontactosfractal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BusquedaDatos {
    
    private static Contacto contacto;
    public static conexion conexion;
    
    public static void buscarContacto(String tipo, String contacto)
    {
        conexion=new conexion();
        conexion.conectar();
        try{
            Statement estatuto = conexion.getConnection().createStatement();
            String SQL = "select * from %1$s where Nombre like '%2$s'";
            ResultSet r = estatuto.executeQuery( String.format(SQL, tipo, contacto) );
            if(r.next()){
                ResultSetMetaData md = r.getMetaData();
                String all = "";
                for(int i=1;i<= md.getColumnCount();i++){
                    String key = md.getColumnLabel(i);
                    String val = r.getString(key);
                    all += String.format("%1$s : %2$s \n", key, val);
                }
                Mensajes.mostrarDialogo(all);
            }
            estatuto.close();
            conexion.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            Mensajes.mostrarDialogo("Error en el registro intente de nuevo");
        }
    }
    
    public static void buscarDeportista(String contacto)
    {
        conexion=new conexion();
        conexion.conectar();
        Contacto cont=new Contacto();
        cont=new Deportista();
        boolean existe=false;
	try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre, ApePa, ApeMa,Genero,FechaNac,Deporte FROM Deportista WHERE Nombre = '"+contacto+"'");
            ResultSet res = consulta.executeQuery();
            while(res.next()){
                cont.setNombre(res.getString("Nombre"));
		cont.setApellidoPaterno(res.getString("ApePa"));
		cont.setApellidoMaterno(res.getString("ApeMa"));
                ((Deportista)cont).setGenero(res.getString("Genero"));
                ((Deportista)cont).setFechaNacimiento(res.getString("FechaNac"));
                ((Deportista)cont).setDeporte(res.getString("Deporte"));
            }
            JOptionPane.showMessageDialog(null, "Nombre="+cont.getNombre()+"\nApellidoPaterno="
                    +cont.getApellidoPaterno()+"\nApellidoMaterno="+cont.getApellidoMaterno()
                    +"\nGenero="+((Deportista)cont).getGenero()+"\nFecha de Nacimiento="
                    +((Deportista)cont).getFechaNacimiento()+"\nDeporte="+((Deportista)cont).getDeporte());
            consulta.close();
            res.close();
            conexion.desconectar();
            } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            System.out.println(e);
	}
    }
    
    public static void buscarDoctor(String contacto){
        conexion=new conexion();
        conexion.conectar();
        Contacto cont=new Contacto();
        cont=new Doctor();
        boolean existe=false;
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,FechaNac,Especialidad,NombreH,DireccionH from Doctor WHERE Nombre = '"+contacto+"'");
            ResultSet res = consulta.executeQuery();
            while(res.next()){
                existe=true;
                cont.setNombre(res.getString("Nombre"));
                cont.setApellidoPaterno(res.getString("ApePa"));
                cont.setApellidoMaterno(res.getString("ApeMa"));
                ((Doctor)cont).setFechaNacimiento(res.getString("FechaNac"));
                ((Doctor)cont).setEspecialidad(res.getString("Especialidad"));
                ((Doctor)cont).setNombreHospital(res.getString("NombreH"));
                ((Doctor)cont).setDireccionHospital(res.getString("DireccionH"));
            }
            JOptionPane.showMessageDialog(null, "Nombre="+cont.getNombre()+"\nApellidoPaterno="
                    +cont.getApellidoPaterno()+"\nApellidoMaterno="+cont.getApellidoMaterno()
                    +"\nFecha de Nacimiento="+((Doctor)cont).getFechaNacimiento()+"\nEspecialidad="
                    +((Doctor)cont).getEspecialidad()+"\nNombre del Hospital="+((Doctor)cont).getNombreHospital()
                    +"\nDireccion del Hospital="+((Doctor)cont).getDireccionHospital());
            consulta.close();
            res.close();
            conexion.desconectar();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            System.out.println(e);
	}
    }
    
    public static void buscarEstudiante(String contacto){
        conexion=new conexion();
        conexion.conectar();
        Contacto cont=new Contacto();
        cont=new Estudiante();
        boolean existe=false;
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,LugarNac,FechaNac,Carrera,Email from Estudiante WHERE Nombre = '"+contacto+"'");
            ResultSet res = consulta.executeQuery();
            while(res.next()){
                existe=true;
                cont.setNombre(res.getString("Nombre"));
		cont.setApellidoPaterno(res.getString("ApePa"));
		cont.setApellidoMaterno(res.getString("ApeMa"));
                ((Estudiante)cont).setLugarNacimiento(res.getString("LugarNac"));
                ((Estudiante)cont).setFechaNacimiento(res.getString("FechaNac"));
                ((Estudiante)cont).setEstudiaCarrera(res.getString("Carrera"));
                ((Estudiante)cont).setEmail(res.getString("Email"));
            }
            JOptionPane.showMessageDialog(null, "Nombre="+cont.getNombre()+"\nApellidoPaterno="
                    +cont.getApellidoPaterno()+"\nApellidoMaterno="+cont.getApellidoMaterno()
                    +"\nLugar de Nacimiento="+((Estudiante)cont).getLugarNacimento()+"\nFecha de Nacimiento="
                    +((Estudiante)cont).getFechaNacimiento()+"\nCarrera="+((Estudiante)cont).getEstudiaCarrera()
                    +"\nEmail="+((Estudiante)cont).getEmail());
            consulta.close();
            res.close();
            conexion.desconectar();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            System.out.println(e);
	}
    }
    
    public static void buscarLicenciado(String contacto){
        conexion=new conexion();
        conexion.conectar();
        Contacto cont=new Contacto();
        cont=new Licenciado();
        boolean existe=false;
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,TelOficina,HorarioIn,HorarioFin from Licenciado WHERE Nombre = '"+contacto+"'");
            ResultSet res = consulta.executeQuery();
            while(res.next()){
                existe=true;
                cont.setNombre(res.getString("Nombre"));
		cont.setApellidoPaterno(res.getString("ApePa"));
		cont.setApellidoMaterno(res.getString("ApeMa"));
                ((Licenciado)cont).setTelefonoOficina(res.getString("TelOficina"));
                ((Licenciado)cont).setHorarioAtencionInicio(res.getString("HorarioIn"));
                ((Licenciado)cont).setHorarioAtencionFin(res.getString("HorarioFin"));
            }
            JOptionPane.showMessageDialog(null, "Nombre="+cont.getNombre()+"\nApellidoPaterno="
                    +cont.getApellidoPaterno()+"\nApellidoMaterno="+cont.getApellidoMaterno()
                    +"\nTelefono de Oficina="+((Licenciado)cont).getTelefonoOficina()+"\nHorario de Atencion="
                    +((Licenciado)cont).getHorarioAtencionInicio()+" a "+((Licenciado)cont).getHorarioAtencionFin());
            consulta.close();
            res.close();
            conexion.desconectar();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            System.out.println(e);
	}
    }
    
    public static void buscarPersona(String contacto){
        conexion=new conexion();
        conexion.conectar();
        Contacto cont=new Contacto();
        cont=new Persona();
        boolean existe=false;
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,Domicilio,MedioPreferido,Ocupacion from Persona WHERE Nombre = '"+contacto+"'");
            ResultSet res = consulta.executeQuery();
            while(res.next()){
                existe=true;
                cont.setNombre(res.getString("Nombre"));
		cont.setApellidoPaterno(res.getString("ApePa"));
		cont.setApellidoMaterno(res.getString("ApeMa"));
                ((Persona)cont).setDomicilio(res.getString("Domicilio"));
                ((Persona)cont).setContactoPreferido(res.getString("MedioPreferido"));
                ((Persona)cont).setOcupacion(res.getString("Ocupacion"));
            }
            JOptionPane.showMessageDialog(null, "Nombre="+cont.getNombre()+"\nApellidoPaterno="
                    +cont.getApellidoPaterno()+"\nApellidoMaterno="+cont.getApellidoMaterno()
                    +"\nDomicilio="+((Persona)cont).getDomicilio()+"\nMedio de Contacto Preferido="
                    +((Persona)cont).getContactoPreferido()+"\nOcupacion="+((Persona)cont).getOcupacion());
            consulta.close();
            res.close();
            conexion.desconectar();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            System.out.println(e);
	}
    }
}
