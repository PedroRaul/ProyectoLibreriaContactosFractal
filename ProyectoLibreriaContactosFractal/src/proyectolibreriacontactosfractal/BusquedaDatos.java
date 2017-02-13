package proyectolibreriacontactosfractal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static proyectolibreriacontactosfractal.BusquedaDatos.conexion;

public class BusquedaDatos {
    
    private static Contacto contacto;
    private static Contacto valorentrada;
    public static conexion conexion;
    private static String valoreleccion;
    private static String nombrecontacto;
    private static String apellidopaternocontacto;
    private static String apellidomaternocontacto;
    private static String nombre;
    private static String apellidopaterno;
    private static String apellidomaterno;
    
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
    
    public static void buscarDeportista(String valorentrada){   
        conexion=new conexion();
        conexion.conectar();
        contacto=new Deportista();
        nombrecontacto=Mensajes.mostrarDialogoCapturaString("Nombre");
        apellidopaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Paterno");
        apellidomaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Materno");
	try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre, ApePa, ApeMa,Genero,FechaNac,Deporte FROM Deportista WHERE Nombre = '"+nombrecontacto+"' and ApePa='"+apellidopaternocontacto+"' and ApeMa='"+apellidomaternocontacto+"'");
            ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
		contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
		contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                ((Deportista)contacto).setGenero(resultadoquery.getString("Genero"));
                ((Deportista)contacto).setFechaNacimiento(resultadoquery.getString("FechaNac"));
                ((Deportista)contacto).setDeporte(resultadoquery.getString("Deporte"));
            }
                Mensajes.mostrarDialogo("Nombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nGenero="+((Deportista)contacto).getGenero()+"\nFecha de Nacimiento="
                    +((Deportista)contacto).getFechaNacimiento()+"\nDeporte="+((Deportista)contacto).getDeporte());
            
            consulta.close();
            resultadoquery.close();
            conexion.desconectar();
            } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
    }
    
    public static void buscarDoctor(String valorentrada){
        conexion=new conexion();
        conexion.conectar();
        contacto=new Doctor();
        nombrecontacto=Mensajes.mostrarDialogoCapturaString("Nombre");
        apellidopaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Paterno");
        apellidomaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Materno");
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,FechaNac,Especialidad,NombreH,DireccionH from Doctor WHERE Nombre = '"+nombrecontacto+"' and ApePa='"+apellidopaternocontacto+"' and ApeMa='"+apellidomaternocontacto+"'");
            ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
                contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
                contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                ((Doctor)contacto).setFechaNacimiento(resultadoquery.getString("FechaNac"));
                ((Doctor)contacto).setEspecialidad(resultadoquery.getString("Especialidad"));
                ((Doctor)contacto).setNombreHospital(resultadoquery.getString("NombreH"));
                ((Doctor)contacto).setDireccionHospital(resultadoquery.getString("DireccionH"));
            }
            Mensajes.mostrarDialogo("Nombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nFecha de Nacimiento="+((Doctor)contacto).getFechaNacimiento()+"\nEspecialidad="
                    +((Doctor)contacto).getEspecialidad()+"\nNombre del Hospital="+((Doctor)contacto).getNombreHospital()
                    +"\nDireccion del Hospital="+((Doctor)contacto).getDireccionHospital());
            
            consulta.close();
            resultadoquery.close();
            conexion.desconectar();
        } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
    }
    
    public static void buscarEstudiante(String valorentrada){
        conexion=new conexion();
        conexion.conectar();
        contacto=new Estudiante();
        nombrecontacto=Mensajes.mostrarDialogoCapturaString("Nombre");
        apellidopaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Paterno");
        apellidomaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Materno");
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,LugarNac,FechaNac,Carrera,Email from Estudiante WHERE Nombre = '"+nombrecontacto+"' and ApePa='"+apellidopaternocontacto+"' and ApeMa='"+apellidomaternocontacto+"'");
            ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
		contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
		contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                ((Estudiante)contacto).setLugarNacimiento(resultadoquery.getString("LugarNac"));
                ((Estudiante)contacto).setFechaNacimiento(resultadoquery.getString("FechaNac"));
                ((Estudiante)contacto).setEstudiaCarrera(resultadoquery.getString("Carrera"));
                ((Estudiante)contacto).setEmail(resultadoquery.getString("Email"));
            }
            Mensajes.mostrarDialogo("Nombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nLugar de Nacimiento="+((Estudiante)contacto).getLugarNacimento()+"\nFecha de Nacimiento="
                    +((Estudiante)contacto).getFechaNacimiento()+"\nCarrera="+((Estudiante)contacto).getEstudiaCarrera()
                    +"\nEmail="+((Estudiante)contacto).getEmail());
            
            consulta.close();
            resultadoquery.close();
            conexion.desconectar();
        } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
    }
    
    public static void buscarLicenciado(String valorentrada){
        conexion=new conexion();
        conexion.conectar();
        contacto=new Licenciado();
        nombrecontacto=Mensajes.mostrarDialogoCapturaString("Nombre");
        apellidopaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Paterno");
        apellidomaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Materno");
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,TelOficina,HorarioIn,HorarioFin from Licenciado WHERE Nombre = '"+nombrecontacto+"' and ApePa='"+apellidopaternocontacto+"' and ApeMa='"+apellidomaternocontacto+"'");
            ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
		contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
		contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                ((Licenciado)contacto).setTelefonoOficina(resultadoquery.getString("TelOficina"));
                ((Licenciado)contacto).setHorarioAtencionInicio(resultadoquery.getString("HorarioIn"));
                ((Licenciado)contacto).setHorarioAtencionFin(resultadoquery.getString("HorarioFin"));
            }
            Mensajes.mostrarDialogo("Nombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nTelefono de Oficina="+((Licenciado)contacto).getTelefonoOficina()+"\nHorario de Atencion="
                    +((Licenciado)contacto).getHorarioAtencionInicio()+" a "+((Licenciado)contacto).getHorarioAtencionFin());
            
            consulta.close();
            resultadoquery.close();
            conexion.desconectar();
        } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
    }
    
    public static void buscarPersona(String valorentrada){
        conexion=new conexion();
        conexion.conectar();
        contacto=new Persona();
        nombrecontacto=Mensajes.mostrarDialogoCapturaString("Nombre");
        apellidopaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Paterno");
        apellidomaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Materno");
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,Domicilio,MedioPreferido,Ocupacion from Persona WHERE Nombre = '"+nombrecontacto+"' and ApePa='"+apellidopaternocontacto+"' and ApeMa='"+apellidomaternocontacto+"'");
            ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
		contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
		contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                ((Persona)contacto).setDomicilio(resultadoquery.getString("Domicilio"));
                ((Persona)contacto).setContactoPreferido(resultadoquery.getString("MedioPreferido"));
                ((Persona)contacto).setOcupacion(resultadoquery.getString("Ocupacion"));
            }
            Mensajes.mostrarDialogo("Nombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nDomicilio="+((Persona)contacto).getDomicilio()+"\nMedio de Contacto Preferido="
                    +((Persona)contacto).getContactoPreferido()+"\nOcupacion="+((Persona)contacto).getOcupacion());
            
            consulta.close();
            resultadoquery.close();
            conexion.desconectar();
        } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
    }

    public static void buscarDeportistaManual(String valorentrada){//Este Metodo busca todo registro de la tabla y lo muestra en consola
        conexion=new conexion();
        conexion.conectar();
        contacto=new Deportista();  
	try{
            //--------Contador---------
            PreparedStatement consultacontador;
            consultacontador = conexion.getConnection().prepareStatement("select count(*) from Deportista");
            ResultSet resultadoquerycontador = consultacontador.executeQuery();
            resultadoquerycontador.beforeFirst(); 
            resultadoquerycontador.next();
            int NR = resultadoquerycontador.getInt ("count(*)");
            //--------------------------
            for(int j=1;j<=NR;j++){
                PreparedStatement consulta;
                consulta = conexion.getConnection().prepareStatement("SELECT Nombre, ApePa, ApeMa,Genero,FechaNac,Deporte FROM Deportista where IdPersona='"+j+"' ");
                ResultSet resultadoquery = consulta.executeQuery();
                while(resultadoquery.next()){
                    contacto.setNombre(resultadoquery.getString("Nombre"));
                    contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
                    contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                    ((Deportista)contacto).setGenero(resultadoquery.getString("Genero"));
                    ((Deportista)contacto).setFechaNacimiento(resultadoquery.getString("FechaNac"));
                    ((Deportista)contacto).setDeporte(resultadoquery.getString("Deporte"));
                }
                Mensajes.mostrarDialogo("---------------------------"+"\nNombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nGenero="+((Deportista)contacto).getGenero()+"\nFecha de Nacimiento="
                    +((Deportista)contacto).getFechaNacimiento()+"\nDeporte="+((Deportista)contacto).getDeporte()
                        +"\n---------------------------");
                consulta.close();
                resultadoquery.close();
            }
            conexion.desconectar();
            } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
    }
    
    public static void menuEleccionDeportista(String valorentrada){
        valoreleccion=Mensajes.mostrarDialogoCapturaString("INGRESA EL NUMERO COMO DESEAS BUSCAR...\n\n1-Buscar Por Nombre\n2-Buscar Todo");
        switch(valoreleccion){
            case "1":
                BusquedaDatos.buscarDeportista(valorentrada);
            break;
            case"2":
                BusquedaDatos.buscarDeportistaManual(valorentrada);
            break;
        }
    }
}
