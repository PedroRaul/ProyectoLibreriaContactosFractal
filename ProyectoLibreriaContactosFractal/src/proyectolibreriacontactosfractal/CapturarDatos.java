//
package proyectolibreriacontactosfractal;

public class CapturarDatos {
    
   public static Contacto contacto;
   public static String querycontactos;
   public static String querymediodecontactos;
    
    private static void capturaDatosContacto(String tipoContacto)
            
    {
        // se aplica polimorfismo al objeto contacto en base al valor del parametro 
        switch(tipoContacto)
        {
            case ContactosABC.tabladeportista:
                contacto=new Deportista();
                break;
            case ContactosABC.tabladoctor:
                contacto=new Doctor();
                break;
            case ContactosABC.tablaestudiante:
                contacto=new Estudiante();
                break;
            case ContactosABC.tablalicenciado:
                contacto=new Licenciado();
                break;
            case ContactosABC.tablapersona:
                contacto=new Persona();
                break;
        }
        
        contacto.setNombre(Mensajes.mostrarDialogoCapturaString("Ingresa el nombre"));
        contacto.setApellidoPaterno(Mensajes.mostrarDialogoCapturaString("Ingresa el Apellido Paterno"));
        contacto.setApellidoMaterno(Mensajes.mostrarDialogoCapturaString("Ingresa el Apellido Materno"));
        contacto.setTelefonoCasa(Mensajes.mostrarDialogoCapturaString("Ingresa el telefono de casa"));
        contacto.setTelefonoCelular(Mensajes.mostrarDialogoCapturaString("Ingresa el telefono celular"));
        contacto.setEmail(Mensajes.mostrarDialogoCapturaString("Ingresa el email"));
        
    }
    
   
     public static void capturarDatosDeportista() {
        
        capturaDatosContacto(ContactosABC.tabladeportista);
        ((Deportista)contacto).setGenero(Mensajes.mostrarDialogoCapturaString("Ingresa el Genero"));
        ((Deportista)contacto).setFechaNacimiento(Mensajes.mostrarDialogoCapturaString("Ingresa la fecha de nacimiento"));
        ((Deportista)contacto).setDeporte(Mensajes.mostrarDialogoCapturaString("Ingresa el Deporte"));
        
        querycontactos="INSERT INTO "+ContactosABC.tabladeportista
                +"("+ContactosABC.camponombre+", "+ContactosABC.campoapellidopaterno
                +","+ContactosABC.campoapellidomaterno+","+ContactosABC.campogenero
                +","+ContactosABC.campofechadenacimiento+","+ContactosABC.campodeporte
                +","+ContactosABC.campoprofesion+")"
                    + " VALUES ('"+contacto.getNombre()+"','"+contacto.getApellidoPaterno()
                +"','"+contacto.getApellidoMaterno()+"','"+((Deportista)contacto).getGenero()
                +"','"+((Deportista)contacto).getFechaNacimiento()+"','"
                +((Deportista)contacto).getDeporte()+"','"+ContactosABC.tabladeportista+"')";
        
        ContactosABC.guardarDatosContacto(querycontactos);
        
     }

    public static void capturarDatosDoctor() {
        
        capturaDatosContacto("doctor");
        ((Doctor)contacto).setFechaNacimiento(Mensajes.mostrarDialogoCapturaString("Ingresa la fecha de nacimiento"));
        ((Doctor)contacto).setEspecialidad(Mensajes.mostrarDialogoCapturaString("Ingresa la especialidad"));
        ((Doctor)contacto).setNombreHospital(Mensajes.mostrarDialogoCapturaString("Ingresa el Nombre del hospital donde ejerce"));
        ((Doctor)contacto).setDireccionHospital(Mensajes.mostrarDialogoCapturaString("Ingresa la direccion del hospital donde ejerce"));
        
        querycontactos="INSERT INTO "+ContactosABC.tabladoctor
                +"("+ContactosABC.camponombre+", "+ContactosABC.campoapellidopaterno+","
                +ContactosABC.campoapellidomaterno+","+ContactosABC.campofechadenacimiento+","
                +ContactosABC.campoespecialidad+","+ContactosABC.camponombrehospital+","
                +ContactosABC.campodireccionhospital+","+ContactosABC.campoprofesion+")"
                    + " VALUES ('"+contacto.getNombre()+"','"+contacto.getApellidoPaterno()
                +"','"+contacto.getApellidoMaterno()+"','"+((Doctor)contacto).getFechaNacimiento()
                +"','"+((Doctor)contacto).getEspecialidad()+"','"+((Doctor)contacto).getNombreHospital()
                +"','"+((Doctor)contacto).getDireccionHospital()+"','"+ContactosABC.tabladoctor+"')";
        
        ContactosABC.guardarDatosContacto(querycontactos);
        }

    public static void capturarDatosEstudiante() {
        
        capturaDatosContacto("estudiante");
        ((Estudiante)contacto).setFechaNacimiento(Mensajes.mostrarDialogoCapturaString("Ingresa la fecha de nacimiento"));
        ((Estudiante)contacto).setLugarNacimiento(Mensajes.mostrarDialogoCapturaString("Ingresa el lugar de nacimiento"));
        ((Estudiante)contacto).setEstudiaCarrera(Mensajes.mostrarDialogoCapturaString("Ingresa la carrera que estudia"));
        
        querycontactos="INSERT INTO "+ContactosABC.tablaestudiante
                +"("+ContactosABC.camponombre+", "+ContactosABC.campoapellidopaterno
                +","+ContactosABC.campoapellidomaterno+","+ContactosABC.campolugardenacimiento
                +","+ContactosABC.campofechadenacimiento+","+ContactosABC.campocarrera
                +","+ContactosABC.campoprofesion+")"
                    + " VALUES ('"+contacto.getNombre()+"','"+contacto.getApellidoPaterno()
                +"','"+contacto.getApellidoMaterno()+"','"+((Estudiante)contacto).getLugarNacimento()
                +"','"+((Estudiante)contacto).getFechaNacimiento()+"','"
                +((Estudiante)contacto).getEstudiaCarrera()+"','"+ContactosABC.tablaestudiante+"')";
        
        ContactosABC.guardarDatosContacto(querycontactos);
        
       }

    public static void capturarDatosLicenciado() {
        
        capturaDatosContacto("licenciado");
        ((Licenciado)contacto).setTelefonoOficina(Mensajes.mostrarDialogoCapturaString("Ingresa el Telefono de oficina"));
        ((Licenciado)contacto).setHorarioAtencionInicio(Mensajes.mostrarDialogoCapturaString("Ingresa el horario de inicio"));
        ((Licenciado)contacto).setHorarioAtencionFin(Mensajes.mostrarDialogoCapturaString("Ingresa el horario de fin"));
        
        querycontactos="INSERT INTO "+ContactosABC.tablalicenciado
                +"("+ContactosABC.camponombre+", "+ContactosABC.campoapellidopaterno
                +","+ContactosABC.campoapellidomaterno+","+ContactosABC.campotelefonooficina
                +","+ContactosABC.campohorarioinicial+","+ContactosABC.campohorariofinal
                +","+ContactosABC.campoprofesion+")"
                    + " VALUES ('"+contacto.getNombre()+"','"+contacto.getApellidoPaterno()
                +"','"+contacto.getApellidoMaterno()+"','"+((Licenciado)contacto).getTelefonoOficina()
                +"','"+((Licenciado)contacto).getHorarioAtencionInicio()+"','"
                +((Licenciado)contacto).getHorarioAtencionFin()+"','"+ContactosABC.tablalicenciado+"')";
        
        ContactosABC.guardarDatosContacto(querycontactos);
         }

    public static void capturarDatosPersona() {
        
        capturaDatosContacto("persona");
        ((Persona)contacto).setDomicilio(Mensajes.mostrarDialogoCapturaString("Ingresa el Domicilio"));
        ((Persona)contacto).setContactoPreferido(Mensajes.mostrarDialogoCapturaString("Ingresa el medio de contacto favorito"));
        ((Persona)contacto).setOcupacion(Mensajes.mostrarDialogoCapturaString("Ingresa la ocupacion"));
        
         querycontactos="INSERT INTO "+ContactosABC.tablapersona
                +"("+ContactosABC.camponombre+", "+ContactosABC.campoapellidopaterno
                +","+ContactosABC.campoapellidomaterno+","+ContactosABC.campodomicilio
                +","+ContactosABC.campomediodecontactopreferido+","+ContactosABC.campoocupacion
                +","+ContactosABC.campoprofesion+")"
                    + " VALUES ('"+contacto.getNombre()+"','"+contacto.getApellidoPaterno()
                +"','"+contacto.getApellidoMaterno()+"','"+((Persona)contacto).getDomicilio()
                +"','"+((Persona)contacto).getContactoPreferido()+"','"
                +((Persona)contacto).getOcupacion()+"','"+ContactosABC.tablapersona+"')";
        
        ContactosABC.guardarDatosContacto(querycontactos);
        
    }
    
    
    
   
    
    
    
}
