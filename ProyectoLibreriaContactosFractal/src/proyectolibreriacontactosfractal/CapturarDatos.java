
package proyectolibreriacontactosfractal;

import java.util.ArrayList;

/**
 *
 * @author LT
 */
public class CapturarDatos {
    
    private static Contacto contacto=new Contacto();
    
    
    
    
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
        
        capturaDatosContacto("deportista");
        ((Deportista)contacto).setGenero(capturarDatoContacto("Ingresa el Genero"));
        ((Deportista)contacto).setFechaNacimiento(capturarDatoContacto("Ingresa la fecha de nacimiento"));
        ((Deportista)contacto).setDeporte(capturarDatoContacto("Ingresa el Deporte"));
        LibreriaContactosApp.contactoArrayList.add(contacto);
    
        }

    public static void capturarDatosDoctor() {
        
        capturaDatosContacto("doctor");
        ((Doctor)contacto).setFechaNacimiento(capturarDatoContacto("Ingresa la fecha de nacimiento"));
        ((Doctor)contacto).setEspecialidad(capturarDatoContacto("Ingresa la especialidad"));
        ((Doctor)contacto).setNombreHospital(capturarDatoContacto("Ingresa el Nombre del hospital donde ejerce"));
        ((Doctor)contacto).setDireccionHospital(capturarDatoContacto("Ingresa la direccion del hospital donde ejerce"));
        LibreriaContactosApp.contactoArrayList.add(contacto);
        }

    public static void capturarDatosEstudiante() {
        
        capturaDatosContacto("estudiante");
        ((Estudiante)contacto).setFechaNacimiento(capturarDatoContacto("Ingresa la fecha de nacimiento"));
        ((Estudiante)contacto).setLugarNacimiento(capturarDatoContacto("Ingresa el lugar de nacimiento"));
        ((Estudiante)contacto).setEstudiaCarrera(capturarDatoContacto("Ingresa la carrera que estudia"));
        LibreriaContactosApp.contactoArrayList.add(contacto);
    
       }

    public static void capturarDatosLicenciado() {
        
        capturaDatosContacto("licenciado");
        ((Licenciado)contacto).setTelefonoOficina(capturarDatoContacto("Ingresa el Telefono de oficina"));
        ((Licenciado)contacto).setHorarioAtencionInicio(capturarDatoContacto("Ingresa el horario de inicio"));
        ((Licenciado)contacto).setHorarioAtencionFin(capturarDatoContacto("Ingresa el horario de fin"));
        LibreriaContactosApp.contactoArrayList.add(contacto);
        }

    public static void capturarDatosPersona() {
        
        capturaDatosContacto("persona");
        ((Persona)contacto).setDomicilio(capturarDatoContacto("Ingresa el Domicilio"));
        ((Persona)contacto).setContactoPreferido(capturarDatoContacto("Ingresa el medio de contacto favorito"));
        ((Persona)contacto).setOcupacion(capturarDatoContacto("Ingresa la ocupacion"));
        LibreriaContactosApp.contactoArrayList.add(contacto);
        
    }
    
    //Captura el un dato del contacto
    public static String capturarDatoContacto(String mensaje)
    {
        
        return Mensajes.mostrarDialogoCapturaString(mensaje);
    }
    
    
}
