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
    public static conexion conexion;
    private static String valoreleccion;
    private static String nombrecontacto;
    private static String apellidopaternocontacto;
    private static String apellidomaternocontacto;
    
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
    
    public static void buscarDeportista(String contac)
    {   
        
        /*
        *remplazar el objeto "cont" por el objeto contacto que esta declarado al inicio de la clase 
        *el objeto contacto se inicializa como el tipo del metodo en el que estamos en este caso = new Deportista()
        *
        */
        conexion=new conexion();
        conexion.conectar();
        contacto=new Deportista();
        
        
        /*
        * remplazar el uso de JOptionePane.showMessageDialog(null,"") 
        por el metodo mostrarDialogoCapturaString() de la clase Mensajes
        
        * las variables Nombre,AP,AM se renombraron nombreContacto,apellidopaternocontacto,apellidomaternocontacto 
        y se declararon como variables globales al inicio de la clase ya que se usan en todos los metodos 
        */
        
        nombrecontacto=Mensajes.mostrarDialogoCapturaString("Nombre");
        apellidopaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Paterno");
        apellidopaternocontacto=Mensajes.mostrarDialogoCapturaString("Apellido Materno");
        
        /*
        *Cambiado el nombre de la variable res por resultadoquery
        
        *en la impresion del resultado cambiado el JOptionPane.showMessageDialog(null,"") por Mensajes.mostrarDialogo("")
        */
        
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
               Mensajes.mostrarDialogo( "Nombre="+contacto.getNombre()+"\nApellidoPaterno="
                    +contacto.getApellidoPaterno()+"\nApellidoMaterno="+contacto.getApellidoMaterno()
                    +"\nGenero="+((Deportista)contacto).getGenero()+"\nFecha de Nacimiento="
                    +((Deportista)contacto).getFechaNacimiento()+"\nDeporte="+((Deportista)contacto).getDeporte());
            
            consulta.close();
            resultadoquery.close();
            conexion.desconectar();
            } catch (SQLException e){
            Mensajes.mostrarDialogo( "Error, no se conectó");
            System.out.println(e);
	}
    }
    
    public static void buscarDoctor(String contacto){
        conexion=new conexion();
        conexion.conectar();
        Contacto cont=new Contacto();
        cont=new Doctor();
        String Nombre=JOptionPane.showInputDialog(null,"Nombre");
        String AP=JOptionPane.showInputDialog(null,"Apellido Paterno");
        String AM=JOptionPane.showInputDialog(null,"Apellido Materno");
        try{
            
            //Contador---------------------------------
            PreparedStatement consultacontador;
            consultacontador = conexion.getConnection().prepareStatement("select count(*) from Doctor");
            ResultSet rescontador = consultacontador.executeQuery();
            rescontador.beforeFirst(); 
            rescontador.next(); 
            int NR = rescontador.getInt ("count(*)");
            //------------------------------------------
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,FechaNac,Especialidad,NombreH,DireccionH from Doctor WHERE Nombre = '"+Nombre+"' and ApePa='"+AP+"' and ApeMa='"+AM+"'");
            ResultSet res = consulta.executeQuery();
            while(res.next()){
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
                    +"\nDireccion del Hospital="+((Doctor)cont).getDireccionHospital()+"\n"+NR);
            
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
        String Nombre=JOptionPane.showInputDialog(null,"Nombre");
        String AP=JOptionPane.showInputDialog(null,"Apellido Paterno");
        String AM=JOptionPane.showInputDialog(null,"Apellido Materno");
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,LugarNac,FechaNac,Carrera,Email from Estudiante WHERE Nombre = '"+Nombre+"' and ApePa='"+AP+"' and ApeMa='"+AM+"'");
            ResultSet res = consulta.executeQuery();
            while(res.next()){
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
        String Nombre=JOptionPane.showInputDialog(null,"Nombre");
        String AP=JOptionPane.showInputDialog(null,"Apellido Paterno");
        String AM=JOptionPane.showInputDialog(null,"Apellido Materno");
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,TelOficina,HorarioIn,HorarioFin from Licenciado WHERE Nombre = '"+Nombre+"' and ApePa='"+AP+"' and ApeMa='"+AM+"'");
            ResultSet res = consulta.executeQuery();
            while(res.next()){
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
        String Nombre=JOptionPane.showInputDialog(null,"Nombre");
        String AP=JOptionPane.showInputDialog(null,"Apellido Paterno");
        String AM=JOptionPane.showInputDialog(null,"Apellido Materno");
        try{
            PreparedStatement consulta;
            consulta = conexion.getConnection().prepareStatement("SELECT Nombre,ApePa,ApeMa,Domicilio,MedioPreferido,Ocupacion from Persona WHERE Nombre = '"+Nombre+"' and ApePa='"+AP+"' and ApeMa='"+AM+"'");
            ResultSet res = consulta.executeQuery();
            while(res.next()){
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

    public static void buscarDeportistaManual(String contacto){//Este Metodo busca todo registro de la tabla y lo muestra en consola
        conexion=new conexion();
        conexion.conectar();
        Contacto cont=new Contacto();
        cont=new Deportista();        
	try{
            //--------Contador---------
            PreparedStatement consultacontador;
            consultacontador = conexion.getConnection().prepareStatement("select count(*) from Deportista");
            ResultSet rescontador = consultacontador.executeQuery();
            rescontador.beforeFirst(); 
            rescontador.next(); 
            int NR = rescontador.getInt ("count(*)");
            //--------------------------
            for(int j=1;j<=NR;j++){
                PreparedStatement consulta;
                consulta = conexion.getConnection().prepareStatement("SELECT Nombre, ApePa, ApeMa,Genero,FechaNac,Deporte FROM Deportista where IdPersona='"+j+"' ");
                ResultSet res = consulta.executeQuery();
                while(res.next()){
                    cont.setNombre(res.getString("Nombre"));
                    cont.setApellidoPaterno(res.getString("ApePa"));
                    cont.setApellidoMaterno(res.getString("ApeMa"));
                    ((Deportista)cont).setGenero(res.getString("Genero"));
                    ((Deportista)cont).setFechaNacimiento(res.getString("FechaNac"));
                    ((Deportista)cont).setDeporte(res.getString("Deporte"));
                }
                System.out.println("---------------------------"+"\nNombre="+cont.getNombre()+"\nApellidoPaterno="
                    +cont.getApellidoPaterno()+"\nApellidoMaterno="+cont.getApellidoMaterno()
                    +"\nGenero="+((Deportista)cont).getGenero()+"\nFecha de Nacimiento="
                    +((Deportista)cont).getFechaNacimiento()+"\nDeporte="+((Deportista)cont).getDeporte()
                        +"\n---------------------------");
                consulta.close();
                res.close();
            }
            conexion.desconectar();
            } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            System.out.println(e);
	}
    }
    
    public static void menuEleccionDeportista(String contacto){
        valoreleccion=Mensajes.mostrarDialogoCapturaString("INGRESA EL NUMERO COMO DESEAS BUSCAR...\n\n1-Buscar Por Nombre\n2-Buscar Todo");
        switch(valoreleccion){
            case "1":
                BusquedaDatos.buscarDeportista(contacto);
            break;
            case"2":
                BusquedaDatos.buscarDeportistaManual(contacto);
            break;
        }
    }
}
