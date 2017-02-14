package proyectolibreriacontactosfractal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static proyectolibreriacontactosfractal.BusquedaDatos.conexion;
import static proyectolibreriacontactosfractal.LibreriaContactosApp.mostrarMenuPrincipal;

public class BusquedaDatos {
    
    private static Contacto contacto;
    private static Contacto valorentrada;
    private static String valorprofesion;
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
//-----------------------------------------------------------------------------------------    
    public static void buscarDeportista(String valorentrada){   
        conexion=new conexion();
        conexion.conectar();
        contacto=new Deportista();
        nombrecontacto=Mensajes.mostrarDialogoCapturaString("Nombre");
        apellidopaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Paterno");
        apellidomaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Materno");
	try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre, ApePa, ApeMa,IdPersona,Genero,FechaNac,Deporte FROM Deportista WHERE Nombre = '"+nombrecontacto+"' and ApePa='"+apellidopaternocontacto+"' and ApeMa='"+apellidomaternocontacto+"'");
            ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
		contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
		contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                contacto.setIdPersonal(resultadoquery.getInt("IdPersona"));
                ((Deportista)contacto).setGenero(resultadoquery.getString("Genero"));
                ((Deportista)contacto).setFechaNacimiento(resultadoquery.getString("FechaNac"));
                ((Deportista)contacto).setDeporte(resultadoquery.getString("Deporte"));
            }
            consulta=conexion.getConnection().prepareStatement("SELECT Contactos FROM Contacto WHERE IdPersona = '"+contacto.getIdPersona()+"' and Profesion='Deportista'");
            resultadoquery = consulta.executeQuery(); 
            
            while(resultadoquery.next()){
                contacto.setMedioContacto(resultadoquery.getString("Contactos"));
            }
            Mensajes.mostrarDialogo("Nombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nGenero="+((Deportista)contacto).getGenero()+"\nFecha de Nacimiento="
                    +((Deportista)contacto).getFechaNacimiento()+"\nDeporte="+((Deportista)contacto).getDeporte()+"\nContactos="+contacto.getMedioContacto());
            
            consulta.close();
            resultadoquery.close();
            conexion.desconectar();
            } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
        Restaurar("Deportista");
    }
//-----------------------------------------------------------------------------------------    
    public static void buscarDoctor(String valorentrada){
        conexion=new conexion();
        conexion.conectar();
        contacto=new Doctor();
        nombrecontacto=Mensajes.mostrarDialogoCapturaString("Nombre");
        apellidopaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Paterno");
        apellidomaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Materno");
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,IdPersona,FechaNac,Especialidad,NombreH,DireccionH from Doctor WHERE Nombre = '"+nombrecontacto+"' and ApePa='"+apellidopaternocontacto+"' and ApeMa='"+apellidomaternocontacto+"'");
            ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
                contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
                contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                contacto.setIdPersonal(resultadoquery.getInt("IdPersona"));
                ((Doctor)contacto).setFechaNacimiento(resultadoquery.getString("FechaNac"));
                ((Doctor)contacto).setEspecialidad(resultadoquery.getString("Especialidad"));
                ((Doctor)contacto).setNombreHospital(resultadoquery.getString("NombreH"));
                ((Doctor)contacto).setDireccionHospital(resultadoquery.getString("DireccionH"));
            }
            consulta=conexion.getConnection().prepareStatement("SELECT Contactos FROM Contacto WHERE IdPersona = '"+contacto.getIdPersona()+"' and Profesion='Doctor'");
            resultadoquery = consulta.executeQuery(); 
            while(resultadoquery.next()){
                contacto.setMedioContacto(resultadoquery.getString("Contactos"));
            }
            Mensajes.mostrarDialogo("Nombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nFecha de Nacimiento="+((Doctor)contacto).getFechaNacimiento()+"\nEspecialidad="
                    +((Doctor)contacto).getEspecialidad()+"\nNombre del Hospital="+((Doctor)contacto).getNombreHospital()
                    +"\nDireccion del Hospital="+((Doctor)contacto).getDireccionHospital()+"\nContactos="+contacto.getMedioContacto());
            
            consulta.close();
            resultadoquery.close();
            conexion.desconectar();
        } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
        Restaurar("Doctor");
    }
//-----------------------------------------------------------------------------------------    
    public static void buscarEstudiante(String valorentrada){
        conexion=new conexion();
        conexion.conectar();
        contacto=new Estudiante();
        nombrecontacto=Mensajes.mostrarDialogoCapturaString("Nombre");
        apellidopaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Paterno");
        apellidomaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Materno");
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,IdPersona,LugarNac,FechaNac,Carrera,Email from Estudiante WHERE Nombre = '"+nombrecontacto+"' and ApePa='"+apellidopaternocontacto+"' and ApeMa='"+apellidomaternocontacto+"'");
            ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
		contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
		contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                contacto.setIdPersonal(resultadoquery.getInt("IdPersona"));
                ((Estudiante)contacto).setLugarNacimiento(resultadoquery.getString("LugarNac"));
                ((Estudiante)contacto).setFechaNacimiento(resultadoquery.getString("FechaNac"));
                ((Estudiante)contacto).setEstudiaCarrera(resultadoquery.getString("Carrera"));
                ((Estudiante)contacto).setEmail(resultadoquery.getString("Email"));
            }
            consulta=conexion.getConnection().prepareStatement("SELECT Contactos FROM Contacto WHERE IdPersona = '"+contacto.getIdPersona()+"' and Profesion='Estudiante'");
            resultadoquery = consulta.executeQuery(); 
            while(resultadoquery.next()){
                contacto.setMedioContacto(resultadoquery.getString("Contactos"));
            }
            Mensajes.mostrarDialogo("Nombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nLugar de Nacimiento="+((Estudiante)contacto).getLugarNacimento()+"\nFecha de Nacimiento="
                    +((Estudiante)contacto).getFechaNacimiento()+"\nCarrera="+((Estudiante)contacto).getEstudiaCarrera()
                    +"\nEmail="+((Estudiante)contacto).getEmail()+"\nContactos="+contacto.getMedioContacto());
            
            consulta.close();
            resultadoquery.close();
            conexion.desconectar();
        } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
        Restaurar("Estudiante");
    }
//-----------------------------------------------------------------------------------------    
    public static void buscarLicenciado(String valorentrada){
        conexion=new conexion();
        conexion.conectar();
        contacto=new Licenciado();
        nombrecontacto=Mensajes.mostrarDialogoCapturaString("Nombre");
        apellidopaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Paterno");
        apellidomaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Materno");
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,IdPersona,TelOficina,HorarioIn,HorarioFin from Licenciado WHERE Nombre = '"+nombrecontacto+"' and ApePa='"+apellidopaternocontacto+"' and ApeMa='"+apellidomaternocontacto+"'");
            ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
		contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
		contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                contacto.setIdPersonal(resultadoquery.getInt("IdPersona"));
                ((Licenciado)contacto).setTelefonoOficina(resultadoquery.getString("TelOficina"));
                ((Licenciado)contacto).setHorarioAtencionInicio(resultadoquery.getString("HorarioIn"));
                ((Licenciado)contacto).setHorarioAtencionFin(resultadoquery.getString("HorarioFin"));
            }
            consulta=conexion.getConnection().prepareStatement("SELECT Contactos FROM Contacto WHERE IdPersona = '"+contacto.getIdPersona()+"' and Profesion='Licenciado'");
            resultadoquery = consulta.executeQuery(); 
            while(resultadoquery.next()){
                contacto.setMedioContacto(resultadoquery.getString("Contactos"));
            }
            Mensajes.mostrarDialogo("Nombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nTelefono de Oficina="+((Licenciado)contacto).getTelefonoOficina()+"\nHorario de Atencion="
                    +((Licenciado)contacto).getHorarioAtencionInicio()+" a "+((Licenciado)contacto).getHorarioAtencionFin()+"\nContactos="+contacto.getMedioContacto());
            
            consulta.close();
            resultadoquery.close();
            conexion.desconectar();
        } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
        Restaurar("Licenciado");
    }
//-----------------------------------------------------------------------------------------    
    public static void buscarPersona(String valorentrada){
        conexion=new conexion();
        conexion.conectar();
        contacto=new Persona();
        nombrecontacto=Mensajes.mostrarDialogoCapturaString("Nombre");
        apellidopaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Paterno");
        apellidomaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Materno");
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,IdPersona,Domicilio,MedioPreferido,Ocupacion from Persona WHERE Nombre = '"+nombrecontacto+"' and ApePa='"+apellidopaternocontacto+"' and ApeMa='"+apellidomaternocontacto+"'");
            ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
		contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
		contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                contacto.setIdPersonal(resultadoquery.getInt("IdPersona"));
                ((Persona)contacto).setDomicilio(resultadoquery.getString("Domicilio"));
                ((Persona)contacto).setContactoPreferido(resultadoquery.getString("MedioPreferido"));
                ((Persona)contacto).setOcupacion(resultadoquery.getString("Ocupacion"));
            }
            consulta=conexion.getConnection().prepareStatement("SELECT Contactos FROM Contacto WHERE IdPersona = '"+contacto.getIdPersona()+"' and Profesion='Persona'");
            resultadoquery = consulta.executeQuery(); 
            while(resultadoquery.next()){
                contacto.setMedioContacto(resultadoquery.getString("Contactos"));
            }
            Mensajes.mostrarDialogo("Nombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nDomicilio="+((Persona)contacto).getDomicilio()+"\nMedio de Contacto Preferido="
                    +((Persona)contacto).getContactoPreferido()+"\nOcupacion="+((Persona)contacto).getOcupacion()+"\nContactos="+contacto.getMedioContacto());
            
            consulta.close();
            resultadoquery.close();
            conexion.desconectar();
        } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
        Restaurar("Persona");
    }
//-----------------------------------------------------------------------------------------
    public static void buscarDeportistaManual(String valorentrada){//Este Metodo busca todo registro de la tabla y lo muestra en consola
        conexion=new conexion();
        conexion.conectar();
        contacto=new Deportista();  
	try{
            //--------Contador---------
            PreparedStatement consultacontador,consultapuntero;
            consultacontador = conexion.getConnection().prepareStatement("select count(*) from Deportista");
            ResultSet resultadoquerycontador = consultacontador.executeQuery();
            resultadoquerycontador.beforeFirst(); 
            resultadoquerycontador.next();
            int NR = resultadoquerycontador.getInt ("count(*)");
            //--------------------------
            for(int j=1;j<=NR;j++){
                //Consultar id de la persona para el barrido de los datos
                consultapuntero = conexion.getConnection().prepareStatement("SELECT IdPersona from Deportista Limit "+(j-1)+","+j+"");
                resultadoquerycontador = consultapuntero.executeQuery();
                resultadoquerycontador.beforeFirst(); 
                resultadoquerycontador.next();
                int NPuntero = resultadoquerycontador.getInt ("IdPersona");
                //--------------------------------------------------------
                PreparedStatement consulta;
                consulta = conexion.getConnection().prepareStatement("SELECT Nombre, ApePa, ApeMa,IdPersona,Genero,FechaNac,Deporte FROM Deportista where IdPersona="+NPuntero+"");
                ResultSet resultadoquery = consulta.executeQuery();
                while(resultadoquery.next()){
                    contacto.setNombre(resultadoquery.getString("Nombre"));
                    contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
                    contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                    contacto.setIdPersonal(resultadoquery.getInt("IdPersona"));
                    ((Deportista)contacto).setGenero(resultadoquery.getString("Genero"));
                    ((Deportista)contacto).setFechaNacimiento(resultadoquery.getString("FechaNac"));
                    ((Deportista)contacto).setDeporte(resultadoquery.getString("Deporte"));
                }
                consulta=conexion.getConnection().prepareStatement("SELECT Contactos FROM Contacto WHERE IdPersona = '"+contacto.getIdPersona()+"' and Profesion='Deportista'");
                resultadoquery = consulta.executeQuery(); 
                while(resultadoquery.next()){
                    contacto.setMedioContacto(resultadoquery.getString("Contactos"));
                }
                Mensajes.mostrarDialogo("---------------------------"+"\nNombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nGenero="+((Deportista)contacto).getGenero()+"\nFecha de Nacimiento="
                    +((Deportista)contacto).getFechaNacimiento()+"\nDeporte="+((Deportista)contacto).getDeporte()+"\nContactos="+contacto.getMedioContacto()
                        +"\n---------------------------");
                consulta.close();
                resultadoquery.close();
                contacto.setMedioContacto("");
            }
            conexion.desconectar();
            } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
        Restaurar("Deportista");
    }
//-----------------------------------------------------------------------------------------    
    public static void buscarDoctorManual(String valorentrada){//Este Metodo busca todo registro de la tabla y lo muestra en consola
        conexion=new conexion();
        conexion.conectar();
        contacto=new Doctor();  
	try{
            //--------Contador---------
            PreparedStatement consultacontador,consultapuntero;
            consultacontador = conexion.getConnection().prepareStatement("select count(*) from Doctor");
            ResultSet resultadoquerycontador = consultacontador.executeQuery();
            resultadoquerycontador.beforeFirst(); 
            resultadoquerycontador.next();
            int NR = resultadoquerycontador.getInt ("count(*)");
            //--------------------------
            for(int j=1;j<=NR;j++){
                //Consultar id de la persona para el barrido de los datos
                consultapuntero = conexion.getConnection().prepareStatement("SELECT IdPersona from Doctor Limit "+(j-1)+","+j+"");
                resultadoquerycontador = consultapuntero.executeQuery();
                resultadoquerycontador.beforeFirst(); 
                resultadoquerycontador.next();
                int NPuntero = resultadoquerycontador.getInt ("IdPersona");
                //--------------------------------------------------------
                PreparedStatement consulta;
                consulta = conexion.getConnection().prepareStatement("SELECT Nombre, ApePa, ApeMa,IdPersona,FechaNac,Especialidad,NombreH,DireccionH FROM Doctor where IdPersona='"+NPuntero+"' ");
                ResultSet resultadoquery = consulta.executeQuery();
                while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
                contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
                contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                contacto.setIdPersonal(resultadoquery.getInt("IdPersona"));
                ((Doctor)contacto).setFechaNacimiento(resultadoquery.getString("FechaNac"));
                ((Doctor)contacto).setEspecialidad(resultadoquery.getString("Especialidad"));
                ((Doctor)contacto).setNombreHospital(resultadoquery.getString("NombreH"));
                ((Doctor)contacto).setDireccionHospital(resultadoquery.getString("DireccionH"));
            }
                consulta=conexion.getConnection().prepareStatement("SELECT Contactos FROM Contacto WHERE IdPersona = '"+contacto.getIdPersona()+"' and Profesion='Doctor'");
                resultadoquery = consulta.executeQuery(); 
                while(resultadoquery.next()){
                    contacto.setMedioContacto(resultadoquery.getString("Contactos"));
                }
            Mensajes.mostrarDialogo("---------------------------"+"\nNombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nFecha de Nacimiento="+((Doctor)contacto).getFechaNacimiento()+"\nEspecialidad="
                    +((Doctor)contacto).getEspecialidad()+"\nNombre del Hospital="+((Doctor)contacto).getNombreHospital()
                    +"\nDireccion del Hospital="+((Doctor)contacto).getDireccionHospital()+"\nContactos="+contacto.getMedioContacto());
                consulta.close();
                resultadoquery.close();
                contacto.setMedioContacto("");
            }
            conexion.desconectar();//
            } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
        Restaurar("Doctor");
    }
//-----------------------------------------------------------------------------------------    
    public static void buscarEstudianteManual(String valorentrada){//Este Metodo busca todo registro de la tabla y lo muestra en consola
        conexion=new conexion();
        conexion.conectar();
        contacto=new Estudiante();  
	try{
            //--------Contador---------
            PreparedStatement consultacontador,consultapuntero;
            consultacontador = conexion.getConnection().prepareStatement("select count(*) from Estudiante");
            ResultSet resultadoquerycontador = consultacontador.executeQuery();
            resultadoquerycontador.beforeFirst(); 
            resultadoquerycontador.next();
            int NR = resultadoquerycontador.getInt ("count(*)");
            //--------------------------
            for(int j=1;j<=NR;j++){
                //Consultar id de la persona para el barrido de los datos
                consultapuntero = conexion.getConnection().prepareStatement("SELECT IdPersona from Estudiante Limit "+(j-1)+","+j+"");
                resultadoquerycontador = consultapuntero.executeQuery();
                resultadoquerycontador.beforeFirst(); 
                resultadoquerycontador.next();
                int NPuntero = resultadoquerycontador.getInt ("IdPersona");
                //--------------------------------------------------------
                PreparedStatement consulta;
                consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,IdPersona,LugarNac,FechaNac,Carrera,Email from Estudiante WHERE IdPersona='"+NPuntero+"' ");
                ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
		contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
		contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                contacto.setIdPersonal(resultadoquery.getInt("IdPersona"));
                ((Estudiante)contacto).setLugarNacimiento(resultadoquery.getString("LugarNac"));
                ((Estudiante)contacto).setFechaNacimiento(resultadoquery.getString("FechaNac"));
                ((Estudiante)contacto).setEstudiaCarrera(resultadoquery.getString("Carrera"));
                ((Estudiante)contacto).setEmail(resultadoquery.getString("Email"));
            }
                consulta=conexion.getConnection().prepareStatement("SELECT Contactos FROM Contacto WHERE IdPersona = '"+contacto.getIdPersona()+"' and Profesion='Estudiante'");
                resultadoquery = consulta.executeQuery(); 
                while(resultadoquery.next()){
                    contacto.setMedioContacto(resultadoquery.getString("Contactos"));
                }
                Mensajes.mostrarDialogo("---------------------------"+"\nNombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nLugar de Nacimiento="+((Estudiante)contacto).getLugarNacimento()+"\nFecha de Nacimiento="
                    +((Estudiante)contacto).getFechaNacimiento()+"\nCarrera="+((Estudiante)contacto).getEstudiaCarrera()
                    +"\nEmail="+((Estudiante)contacto).getEmail()+"\nContactos="+contacto.getMedioContacto());
                consulta.close();
                resultadoquery.close();
                contacto.setMedioContacto("");
            }
            conexion.desconectar();
            } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
        Restaurar("Estudiante");
    }
 //-----------------------------------------------------------------------------------------   
    public static void buscarLicenciadoManual(String valorentrada){//Este Metodo busca todo registro de la tabla y lo muestra en consola
        conexion=new conexion();
        conexion.conectar();
        contacto=new Licenciado();  
	try{
            //--------Contador---------
            PreparedStatement consultacontador,consultapuntero;
            consultacontador = conexion.getConnection().prepareStatement("select count(*) from Licenciado");
            ResultSet resultadoquerycontador = consultacontador.executeQuery();
            resultadoquerycontador.beforeFirst(); 
            resultadoquerycontador.next();
            int NR = resultadoquerycontador.getInt ("count(*)");
            //--------------------------
            for(int j=1;j<=NR;j++){
                //Consultar id de la persona para el barrido de los datos
                consultapuntero = conexion.getConnection().prepareStatement("SELECT IdPersona from Licenciado Limit "+(j-1)+","+j+"");
                resultadoquerycontador = consultapuntero.executeQuery();
                resultadoquerycontador.beforeFirst(); 
                resultadoquerycontador.next();
                int NPuntero = resultadoquerycontador.getInt ("IdPersona");
                //--------------------------------------------------------
                PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,IdPersona,TelOficina,HorarioIn,HorarioFin from Licenciado WHERE IdPersona='"+NPuntero+"' ");
            ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
		contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
		contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                contacto.setIdPersonal(resultadoquery.getInt("IdPersona"));
                ((Licenciado)contacto).setTelefonoOficina(resultadoquery.getString("TelOficina"));
                ((Licenciado)contacto).setHorarioAtencionInicio(resultadoquery.getString("HorarioIn"));
                ((Licenciado)contacto).setHorarioAtencionFin(resultadoquery.getString("HorarioFin"));
            }
            consulta=conexion.getConnection().prepareStatement("SELECT Contactos FROM Contacto WHERE IdPersona = '"+contacto.getIdPersona()+"' and Profesion='Licenciado'");
            resultadoquery = consulta.executeQuery(); 
            while(resultadoquery.next()){
                contacto.setMedioContacto(resultadoquery.getString("Contactos"));
            }
            Mensajes.mostrarDialogo("---------------------------"+"\nNombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nTelefono de Oficina="+((Licenciado)contacto).getTelefonoOficina()+"\nHorario de Atencion="
                    +((Licenciado)contacto).getHorarioAtencionInicio()+" a "+((Licenciado)contacto).getHorarioAtencionFin()+"\nContactos="+contacto.getMedioContacto());
                consulta.close();
                resultadoquery.close();
                contacto.setMedioContacto("");
            }
            conexion.desconectar();
            } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
        Restaurar("Licenciado");
    }
//-----------------------------------------------------------------------------------------    
    public static void buscarPersonaManual(String valorentrada){//Este Metodo busca todo registro de la tabla y lo muestra en consola
        conexion=new conexion();
        conexion.conectar();
        contacto=new Persona();  
	try{
            //--------Contador---------
            PreparedStatement consultacontador,consultapuntero;
            consultacontador = conexion.getConnection().prepareStatement("select count(*) from Persona");
            ResultSet resultadoquerycontador = consultacontador.executeQuery();
            resultadoquerycontador.beforeFirst(); 
            resultadoquerycontador.next();
            int NR = resultadoquerycontador.getInt ("count(*)");
            //--------------------------
            for(int j=1;j<=NR;j++){
                //Consultar id de la persona para el barrido de los datos
                consultapuntero = conexion.getConnection().prepareStatement("SELECT IdPersona from Persona Limit "+(j-1)+","+j+"");
                resultadoquerycontador = consultapuntero.executeQuery();
                resultadoquerycontador.beforeFirst(); 
                resultadoquerycontador.next();
                int NPuntero = resultadoquerycontador.getInt ("IdPersona");
                //--------------------------------------------------------
                PreparedStatement consulta;
                consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,IdPersona,Domicilio,MedioPreferido,Ocupacion from Persona WHERE IdPersona='"+NPuntero+"' ");
                ResultSet resultadoquery = consulta.executeQuery();
            while(resultadoquery.next()){
                contacto.setNombre(resultadoquery.getString("Nombre"));
		contacto.setApellidoPaterno(resultadoquery.getString("ApePa"));
		contacto.setApellidoMaterno(resultadoquery.getString("ApeMa"));
                contacto.setIdPersonal(resultadoquery.getInt("IdPersona"));
                ((Persona)contacto).setDomicilio(resultadoquery.getString("Domicilio"));
                ((Persona)contacto).setContactoPreferido(resultadoquery.getString("MedioPreferido"));
                ((Persona)contacto).setOcupacion(resultadoquery.getString("Ocupacion"));
            }
            consulta=conexion.getConnection().prepareStatement("SELECT Contactos FROM Contacto WHERE IdPersona = '"+contacto.getIdPersona()+"' and Profesion='Persona'");
                resultadoquery = consulta.executeQuery(); 
                while(resultadoquery.next()){
                    contacto.setMedioContacto(resultadoquery.getString("Contactos"));
                }
                Mensajes.mostrarDialogo("---------------------------"+"\nNombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nDomicilio="+((Persona)contacto).getDomicilio()+"\nMedio de Contacto Preferido="
                    +((Persona)contacto).getContactoPreferido()+"\nOcupacion="+((Persona)contacto).getOcupacion()+"\nContactos="+contacto.getMedioContacto());
                //---------------
            consulta.close();
            resultadoquery.close();
            contacto.setMedioContacto("");
            }
            conexion.desconectar();
            } catch (SQLException e){
            Mensajes.mostrarDialogo("Error, no se conectó");
            System.out.println(e);
	}
        Restaurar("Persona");
    }
 //-----------------------------------------------------------------------------------------   
    public static void menuEleccionDeportista(String valorentrada){
        valoreleccion=Mensajes.mostrarDialogoCapturaString("INGRESA EL NUMERO COMO DESEAS BUSCAR...\n\n1-Buscar Por Nombre\n2-Buscar Todo");
        if(valoreleccion==null)
        {
           mostrarMenuPrincipal();
        }
        switch(valoreleccion){
            case "1":
                BusquedaDatos.buscarDeportista(valorentrada);
            break;
            case"2":
                BusquedaDatos.buscarDeportistaManual(valorentrada);
            break;
            default :
                BusquedaDatos.menuEleccionDoctor(valorentrada);
            break;    
        }
    }
    public static void menuEleccionDoctor(String valorentrada){
        valoreleccion=Mensajes.mostrarDialogoCapturaString("INGRESA EL NUMERO COMO DESEAS BUSCAR...\n\n1-Buscar Por Nombre\n2-Buscar Todo");
        
        if(valoreleccion==null)
        {
           mostrarMenuPrincipal();
        }
        switch(valoreleccion){
            case "1":
                BusquedaDatos.buscarDoctor(valorentrada);
            break;
            case"2":
                BusquedaDatos.buscarDoctorManual(valorentrada);
            break;
            default : BusquedaDatos.menuEleccionDoctor(valorentrada);
            break;
        }
    }
    public static void menuEleccionEstudiante(String valorentrada){
        valoreleccion=Mensajes.mostrarDialogoCapturaString("INGRESA EL NUMERO COMO DESEAS BUSCAR...\n\n1-Buscar Por Nombre\n2-Buscar Todo");
        if(valoreleccion==null)
        {
           mostrarMenuPrincipal();
        }
        switch(valoreleccion){
            case "1":
                BusquedaDatos.buscarEstudiante(valorentrada);
            break;
            case"2":
                BusquedaDatos.buscarEstudianteManual(valorentrada);
            break;
            default : BusquedaDatos.menuEleccionDoctor(valorentrada);
            break;    
        }
    }
    public static void menuEleccionLicenciado(String valorentrada){
        valoreleccion=Mensajes.mostrarDialogoCapturaString("INGRESA EL NUMERO COMO DESEAS BUSCAR...\n\n1-Buscar Por Nombre\n2-Buscar Todo");
        if(valoreleccion==null)
        {
           mostrarMenuPrincipal();
        }
        switch(valoreleccion){
            case "1":
                BusquedaDatos.buscarLicenciado(valorentrada);
            break;
            case"2":
                BusquedaDatos.buscarLicenciadoManual(valorentrada);
            break;
            default : BusquedaDatos.menuEleccionDoctor(valorentrada);
            break;    
        }
    }
    public static void menuEleccionPersona(String valorentrada){
        valoreleccion=Mensajes.mostrarDialogoCapturaString("INGRESA EL NUMERO COMO DESEAS BUSCAR...\n\n1-Buscar Por Nombre\n2-Buscar Todo");
        if(valoreleccion==null)
        {
           mostrarMenuPrincipal();
        }
        switch(valoreleccion){
            case "1":
                BusquedaDatos.buscarPersona(valorentrada);
            break;
            case"2":
                BusquedaDatos.buscarPersonaManual(valorentrada);
            break;
            default : BusquedaDatos.menuEleccionDoctor(valorentrada);
            break;    
        }
    }
    public static void Restaurar(String valorprofesion){
        contacto.setNombre("");
        contacto.setApellidoPaterno("");
        contacto.setApellidoMaterno("");
        contacto.setIdPersonal(0);
        contacto.setMedioContacto("");
        
        switch(valorprofesion){
            case"Deportista":deportistaReset();
                break;
            case"Doctor":doctorReset();
                break;
            case"Estudiante":estudianteReset();
                break;
            case"Licenciado":licenciadoReset();
                break;
            case"Persona":personaReset();
                break;
        }
        LibreriaContactosApp.mostrarMenuPrincipal();
    }
    public static void deportistaReset(){
        ((Deportista)contacto).setGenero("");
        ((Deportista)contacto).setFechaNacimiento("");
        ((Deportista)contacto).setDeporte("");
    }
    public static void doctorReset(){
        ((Doctor)contacto).setFechaNacimiento("");
        ((Doctor)contacto).setEspecialidad("");
        ((Doctor)contacto).setNombreHospital("");
    }
    public static void estudianteReset(){
        ((Estudiante)contacto).setLugarNacimiento("");
        ((Estudiante)contacto).setFechaNacimiento("");
        ((Estudiante)contacto).setEstudiaCarrera("");
        ((Estudiante)contacto).setEmail("");
    }
    public static void licenciadoReset(){
        ((Licenciado)contacto).setTelefonoOficina("");
        ((Licenciado)contacto).setHorarioAtencionInicio("");
        ((Licenciado)contacto).setHorarioAtencionFin("");
    }
    public static void personaReset(){
        ((Persona)contacto).setDomicilio("");
        ((Persona)contacto).setContactoPreferido("");
        ((Persona)contacto).setOcupacion("");
    }
}
