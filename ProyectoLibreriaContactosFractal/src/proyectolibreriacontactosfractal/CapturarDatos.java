
package proyectolibreriacontactosfractal;

import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author LT
 */
public class CapturarDatos {
    
    private static Contacto contacto;
    private static conexion conexion;
    private static final String tabladeportista="deportista";
    private static final String tabladoctor="doctor";
    private static final String tablaestudiante="estudiante";
    private static final String tablalicenciado="licenciado";
    private static final String tablapersona="persona";
    private static final String tablacontacto="contacto";
    private static final String campotelefonooficina="TelOficina";
    private static final String campohorarioinicial="HorarioIn";
    private static final String campohorariofinal="HorarioFin";
    private static final String campodomicilio="Domicilio";
    private static final String campomediodecontactopreferido="MedioPreferido";
    private static final String campoocupacion="Ocupacion";
    private static final String campogenero="Genero";
    private static final String campofechadenacimiento="FechaNac";
    private static final String campodeporte="Deporte";
    private static final String campoespecialidad="Especialidad";
    private static final String camponombrehospital="NombreH";
    private static final String campodireccionhospital="DireccionH";
    private static final String campolugardenacimiento="LugarNac";
    private static final String campocarrera="Carrera";
    
    
    
    
    private static void capturaDatosContacto(String tipoContacto)
            
    {
        // se aplica polimorfismo al objeto contacto en base al valor del parametro 
        switch(tipoContacto)
        {
            case"deportista":
                contacto=new Deportista();
                break;
            case"doctor":
                contacto=new Doctor();
                break;
            case"estudiante":
                contacto=new Estudiante();
                break;
            case"licenciado":
                contacto=new Licenciado();
                break;
            case"persona":
                contacto=new Persona();
                break;
        }
        
        contacto.setNombre(capturarDatoContacto("Ingresa el nombre"));
        contacto.setApellidoPaterno(capturarDatoContacto("Ingresa el Apellido Paterno"));
        contacto.setApellidoMaterno(capturarDatoContacto("Ingresa el Apellido Materno"));
        contacto.setTelefonoCasa(capturarDatoContacto("Ingresa el telefono de casa"));
        contacto.setTelefonoCelular(capturarDatoContacto("Ingresa el telefono celular"));
        contacto.setEmail(capturarDatoContacto("Ingresa el email"));
        
    }
    
   
     public static void capturarDatosDeportista() {
        
        capturaDatosContacto(tabladeportista);
        ((Deportista)contacto).setGenero(capturarDatoContacto("Ingresa el Genero"));
        ((Deportista)contacto).setFechaNacimiento(capturarDatoContacto("Ingresa la fecha de nacimiento"));
        ((Deportista)contacto).setDeporte(capturarDatoContacto("Ingresa el Deporte"));
        
        
        guardarDatosGeneralesContacto(tabladeportista,contacto.getNombre(),contacto.getApellidoPaterno(),
                contacto.getApellidoMaterno());
        
        guardarDatosParticularesContacto(tabladeportista,contacto.getNombre(),campogenero,campofechadenacimiento,campodeporte,"",
                ((Deportista)contacto).getGenero(),((Deportista)contacto).getFechaNacimiento(),
                ((Deportista)contacto).getDeporte(),"");
        }

    public static void capturarDatosDoctor() {
        
        capturaDatosContacto("doctor");
        ((Doctor)contacto).setFechaNacimiento(capturarDatoContacto("Ingresa la fecha de nacimiento"));
        ((Doctor)contacto).setEspecialidad(capturarDatoContacto("Ingresa la especialidad"));
        ((Doctor)contacto).setNombreHospital(capturarDatoContacto("Ingresa el Nombre del hospital donde ejerce"));
        ((Doctor)contacto).setDireccionHospital(capturarDatoContacto("Ingresa la direccion del hospital donde ejerce"));
        
        guardarDatosGeneralesContacto(tabladoctor,contacto.getNombre(),contacto.getApellidoPaterno(),
                contacto.getApellidoMaterno());
        
        guardarDatosParticularesContacto(tabladoctor,contacto.getNombre(),campofechadenacimiento,campoespecialidad
          ,camponombrehospital,campodireccionhospital,((Doctor)contacto).getFechaNacimiento(),((Doctor)contacto).getEspecialidad(),
          ((Doctor)contacto).getNombreHospital(),((Doctor)contacto).getDireccionHospital());
        
        }

    public static void capturarDatosEstudiante() {
        
        capturaDatosContacto("estudiante");
        ((Estudiante)contacto).setFechaNacimiento(capturarDatoContacto("Ingresa la fecha de nacimiento"));
        ((Estudiante)contacto).setLugarNacimiento(capturarDatoContacto("Ingresa el lugar de nacimiento"));
        ((Estudiante)contacto).setEstudiaCarrera(capturarDatoContacto("Ingresa la carrera que estudia"));
        
        
        guardarDatosGeneralesContacto(tablaestudiante,contacto.getNombre(),contacto.getApellidoPaterno(),
                contacto.getApellidoMaterno());
        
        guardarDatosParticularesContacto(tablaestudiante,contacto.getNombre(),campolugardenacimiento,campofechadenacimiento
          ,campocarrera,"",((Estudiante)contacto).getLugarNacimento(),((Estudiante)contacto).getFechaNacimiento(),
          ((Estudiante)contacto).getEstudiaCarrera(),"");
    
       }

    public static void capturarDatosLicenciado() {
        
        capturaDatosContacto("licenciado");
        ((Licenciado)contacto).setTelefonoOficina(capturarDatoContacto("Ingresa el Telefono de oficina"));
        ((Licenciado)contacto).setHorarioAtencionInicio(capturarDatoContacto("Ingresa el horario de inicio"));
        ((Licenciado)contacto).setHorarioAtencionFin(capturarDatoContacto("Ingresa el horario de fin"));
        
        
         guardarDatosGeneralesContacto(tablalicenciado,contacto.getNombre(),contacto.getApellidoPaterno(),
                contacto.getApellidoMaterno());
        
        guardarDatosParticularesContacto(tablalicenciado,contacto.getNombre(),campotelefonooficina,campohorarioinicial
          ,campohorariofinal,"",((Licenciado)contacto).getTelefonoOficina(),((Licenciado)contacto).getHorarioAtencionInicio(),
          ((Licenciado)contacto).getHorarioAtencionFin(),"");
        }

    public static void capturarDatosPersona() {
        
        capturaDatosContacto("persona");
        ((Persona)contacto).setDomicilio(capturarDatoContacto("Ingresa el Domicilio"));
        ((Persona)contacto).setContactoPreferido(capturarDatoContacto("Ingresa el medio de contacto favorito"));
        ((Persona)contacto).setOcupacion(capturarDatoContacto("Ingresa la ocupacion"));
        
        guardarDatosGeneralesContacto(tablapersona,contacto.getNombre(),contacto.getApellidoPaterno(),
                contacto.getApellidoMaterno());
        
        guardarDatosParticularesContacto(tablapersona,contacto.getNombre(),campodomicilio,campomediodecontactopreferido
          ,campoocupacion,"",((Persona)contacto).getDomicilio(),((Persona)contacto).getContactoPreferido(),
          ((Persona)contacto).getOcupacion(),"");
        
    }
    
    
    // Ejecuta el query para almacenar los 3 valores que son comunes en todas las tablas
    public static void guardarDatosGeneralesContacto(String nombretabla,String nombre,String apellidopaterno,String apellidomaterno){
        conexion=new conexion();
        conexion.conectar();
        try{
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO `"+nombretabla+"`(`Nombre`, `ApePa`, `ApeMa`,`Profesion`)"
                    + " VALUES ('"+nombre+"','"+apellidopaterno+"','"+apellidomaterno+"','"+nombretabla+"')");
            estatuto.close();
            conexion.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            Mensajes.mostrarDialogo("Error en el registro intente de nuevo");
        }
    }
    
    public static void guardarDatosParticularesContacto(String nombretabla,String nombre,String campo1,String campo2,String campo3,String campo4,String valorcampo1,String valorcampo2,String valorcampo3,String valorcampo4){
        
        conexion=new conexion();
        if(nombretabla.equals(tabladoctor))
        {
         conexion.conectar();
        try{
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("UPDATE `"+nombretabla+"` SET `"+campo1+"`='"+valorcampo1+"',`"+campo2+"`='"+valorcampo2+"',"
                    + "`"+campo3+"`='"+valorcampo3+"',`"+campo4+"`='"+valorcampo4+"' WHERE Nombre='"+nombre+"'");
            Mensajes.mostrarDialogo("Se ha registrado Exitosamente");
            estatuto.close();
            conexion.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            Mensajes.mostrarDialogo("Error en el registro intente de nuevo");
        }
        }
        else
        {
            conexion.conectar();
        try{
            Statement estatuto = conexion.getConnection().createStatement();
            estatuto.executeUpdate("UPDATE `"+nombretabla+"` SET `"+campo1+"`='"+valorcampo1+"',`"+campo2+"`='"+valorcampo2+"',"
                    + "`"+campo3+"`='"+valorcampo3+"'WHERE Nombre='"+nombre+"'");
            Mensajes.mostrarDialogo("Se ha registrado Exitosamente");
            estatuto.close();
            conexion.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            Mensajes.mostrarDialogo("Error en el registro intente de nuevo");
        }
        }
            
        
    }
    
   
    
    //Captura  un dato del contacto
    public static String capturarDatoContacto(String mensaje)
    {
        
        return Mensajes.mostrarDialogoCapturaString(mensaje);
    }
    
    
}
