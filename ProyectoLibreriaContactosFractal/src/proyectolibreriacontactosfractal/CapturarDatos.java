package proyectolibreriacontactosfractal;

public class CapturarDatos {
    
   public static Contacto contacto;
   public static String querycontactos;
   public static String querymediodecontactos;
   private static int idMaximo=0;
   private static boolean bandera=true;
    
    private static void capturaDatosContacto(String tipoContacto)
            
    {
        // se aplica polimorfismo al objeto contacto en base al valor del parametro 
        switch(tipoContacto)
        {
            case "deportista":
                contacto=new Deportista();
                break;
            case "doctor":
                contacto=new Doctor();
                break;
            case "estudiante":
                contacto=new Estudiante();
                break;
            case "licenciado":
                contacto=new Licenciado();
                break;
            case "persona":
                contacto=new Persona();
                break;
           default:
                Mensajes.mostrarDialogo("Opcion Invalida intenta de nuevo");
                LibreriaContactosApp.mostrarMenuPrincipal();
                break;
        }
        
        contacto.setNombre(Mensajes.mostrarDialogoCapturaString("Ingresa el nombre"));
        if(contacto.getNombre()==null)
         LibreriaContactosApp.mostrarMenuPrincipal();
                 
        while(validarCadenaVacia(contacto.getNombre()))
        {
            Mensajes.mostrarDialogo("No Puedes dejar este campo vacio");
            contacto.setNombre(Mensajes.mostrarDialogoCapturaString("Ingresa el nombre"));
        }
        
        
        contacto.setApellidoPaterno(Mensajes.mostrarDialogoCapturaString("Ingresa el Apellido Paterno"));
        if(contacto.getApellidoPaterno()==null)
        {
             LibreriaContactosApp.mostrarMenuPrincipal();
                 
        }
        while(validarCadenaVacia(contacto.getApellidoPaterno()))
        {
            Mensajes.mostrarDialogo("No Puedes dejar este campo vacio");
            contacto.setApellidoPaterno(Mensajes.mostrarDialogoCapturaString("Ingresa el nombre"));
        }
        
        
        contacto.setApellidoMaterno(Mensajes.mostrarDialogoCapturaString("Ingresa el Apellido Materno"));
        
        
        
    }
    
    public static boolean validarCadenaVacia(String cadena)
    {
        
        if(cadena.equals(""))
            return true;
        else
            return false;
    
    }
    
   
    
     public static void capturarDatosDeportista() {
         
        capturaDatosContacto("deportista");
        idMaximo=ContactosABC.verIdMaximo("deportista")+1;
        capturaMediosContacto("deportista",idMaximo);
        bandera=true;
        
        while(bandera)
        {
        if(Mensajes.mostrarDialogoConfirmacionAgregarOtroMedioDeContacto())
        {
            capturaMediosContacto("deportista",idMaximo);
            bandera=true;
        }
        else
        {
        bandera=false;
        }
        }
        
        ((Deportista)contacto).setGenero(Mensajes.mostrarDialogoCapturaString("Ingresa el Genero"));
        if(((Deportista)contacto).getGenero()==null)
         LibreriaContactosApp.mostrarMenuPrincipal();
                 
        while(validarCadenaVacia(((Deportista)contacto).getGenero()))
        {
            Mensajes.mostrarDialogo("No Puedes dejar este campo vacio");
         ((Deportista)contacto).setGenero(Mensajes.mostrarDialogoCapturaString("Ingresa el Genero"));
        }
        ((Deportista)contacto).setFechaNacimiento(Mensajes.mostrarDialogoCapturaString("Ingresa la fecha de nacimiento"));
        ((Deportista)contacto).setDeporte(Mensajes.mostrarDialogoCapturaString("Ingresa el Deporte"));
        
        querycontactos="INSERT INTO deportista(Nombre, ApePa,ApeMa,Genero,FechaNac,Deporte,Profesion)"
                    + " VALUES ('"+contacto.getNombre()+"','"+contacto.getApellidoPaterno()
                +"','"+contacto.getApellidoMaterno()+"','"+((Deportista)contacto).getGenero()
                +"','"+((Deportista)contacto).getFechaNacimiento()+"','"
                +((Deportista)contacto).getDeporte()+"','"+"deportista"+"')";
        ContactosABC.guardarDatosContacto(querycontactos);
        
        
     }

    public static void capturarDatosDoctor() {
        
        capturaDatosContacto("doctor");
         idMaximo=ContactosABC.verIdMaximo("doctor")+1;
        capturaMediosContacto("doctor",idMaximo);
        bandera=true;
        
        while(bandera)
        {
        if(Mensajes.mostrarDialogoConfirmacionAgregarOtroMedioDeContacto())
        {
            capturaMediosContacto("doctor",idMaximo);
            bandera=true;
        }
        else
        {
        bandera=false;
        }
        }
        ((Doctor)contacto).setFechaNacimiento(Mensajes.mostrarDialogoCapturaString("Ingresa la fecha de nacimiento"));
        ((Doctor)contacto).setEspecialidad(Mensajes.mostrarDialogoCapturaString("Ingresa la especialidad"));
        ((Doctor)contacto).setNombreHospital(Mensajes.mostrarDialogoCapturaString("Ingresa el Nombre del hospital donde ejerce"));
        ((Doctor)contacto).setDireccionHospital(Mensajes.mostrarDialogoCapturaString("Ingresa la direccion del hospital donde ejerce"));
        
       querycontactos="INSERT INTO doctor(Nombre, ApePa,ApeMa,FechaNac,Especialidad,NombreH,DireccionH,Profesion)"
                    + " VALUES ('"+contacto.getNombre()+"','"+contacto.getApellidoPaterno()
                +"','"+contacto.getApellidoMaterno()+"','"+((Doctor)contacto).getFechaNacimiento()
                +"','"+((Doctor)contacto).getEspecialidad()+"','"+((Doctor)contacto).getNombreHospital()
                +"','"+((Doctor)contacto).getDireccionHospital()+"','doctor')";
        
       
        ContactosABC.guardarDatosContacto(querycontactos);
        
        }

    public static void capturarDatosEstudiante() {
        
        capturaDatosContacto("estudiante");
        idMaximo=ContactosABC.verIdMaximo("estudiante")+1;
        capturaMediosContacto("estudiante",idMaximo);
        bandera=true;
        
        while(bandera)
        {
        if(Mensajes.mostrarDialogoConfirmacionAgregarOtroMedioDeContacto())
        {
            capturaMediosContacto("estudiante",idMaximo);
            bandera=true;
        }
        else
        {
        bandera=false;
        }
        }
        ((Estudiante)contacto).setEmail(Mensajes.mostrarDialogoCapturaString("Ingresa el Email"));
        ((Estudiante)contacto).setFechaNacimiento(Mensajes.mostrarDialogoCapturaString("Ingresa la fecha de nacimiento"));
        ((Estudiante)contacto).setLugarNacimiento(Mensajes.mostrarDialogoCapturaString("Ingresa el lugar de nacimiento"));
        ((Estudiante)contacto).setEstudiaCarrera(Mensajes.mostrarDialogoCapturaString("Ingresa la carrera que estudia"));
        
        querycontactos="INSERT INTO estudiante(Nombre,ApePa,ApeMa,LugarNac,FechaNac,Carrera,Email,Profesion)"
                    + " VALUES ('"+contacto.getNombre()+"','"+contacto.getApellidoPaterno()
                +"','"+contacto.getApellidoMaterno()+"','"+((Estudiante)contacto).getLugarNacimento()
                +"','"+((Estudiante)contacto).getFechaNacimiento()+"','"
                +((Estudiante)contacto).getEstudiaCarrera()+"','"+((Estudiante)contacto).getEmail()+"','estudiante')";
        
       
        ContactosABC.guardarDatosContacto(querycontactos);
       
        
       }

    public static void capturarDatosLicenciado() {
        
        capturaDatosContacto("licenciado");
        idMaximo=ContactosABC.verIdMaximo("licenciado")+1;
        capturaMediosContacto("licenciado",idMaximo);
        bandera=true;
        
        while(bandera)
        {
        if(Mensajes.mostrarDialogoConfirmacionAgregarOtroMedioDeContacto())
        {
            capturaMediosContacto("licenciado",idMaximo);
            bandera=true;
        }
        else
        {
        bandera=false;
        }
        }
        ((Licenciado)contacto).setTelefonoOficina(Mensajes.mostrarDialogoCapturaString("Ingresa el Telefono de oficina"));
        ((Licenciado)contacto).setHorarioAtencionInicio(Mensajes.mostrarDialogoCapturaString("Ingresa el horario de inicio"));
        ((Licenciado)contacto).setHorarioAtencionFin(Mensajes.mostrarDialogoCapturaString("Ingresa el horario de fin"));
        
        querycontactos="INSERT INTO "+"licenciado"
                +"(Nombre, ApePa,ApeMa,TelOficina,HorarioIn,HorarioFin,Profesion)"
                    + " VALUES ('"+contacto.getNombre()+"','"+contacto.getApellidoPaterno()
                +"','"+contacto.getApellidoMaterno()+"','"+((Licenciado)contacto).getTelefonoOficina()
                +"','"+((Licenciado)contacto).getHorarioAtencionInicio()+"','"
                +((Licenciado)contacto).getHorarioAtencionFin()+"','"+"licenciado"+"')";
        
        
        ContactosABC.guardarDatosContacto(querycontactos);
        
         }

    public static void capturarDatosPersona() {
        
        capturaDatosContacto("persona");
        idMaximo=ContactosABC.verIdMaximo("persona")+1;
        capturaMediosContacto("persona",idMaximo);
        bandera=true;
        
        while(bandera)
        {
        if(Mensajes.mostrarDialogoConfirmacionAgregarOtroMedioDeContacto())
        {
            capturaMediosContacto("persona",idMaximo);
            bandera=true;
        }
        else
        {
        bandera=false;
        }
        }
        
        ((Persona)contacto).setDomicilio(Mensajes.mostrarDialogoCapturaString("Ingresa el Domicilio"));
        ((Persona)contacto).setContactoPreferido(Mensajes.mostrarDialogoCapturaString("Ingresa el medio de contacto favorito"));
        ((Persona)contacto).setOcupacion(Mensajes.mostrarDialogoCapturaString("Ingresa la ocupacion"));
        
         querycontactos="INSERT INTO persona(Nombre,Apepa,ApeMa,Domicilio,MedioPreferido,Ocupacion,Profesion)"
                    + " VALUES ('"+contacto.getNombre()+"','"+contacto.getApellidoPaterno()
                +"','"+contacto.getApellidoMaterno()+"','"+((Persona)contacto).getDomicilio()
                +"','"+((Persona)contacto).getContactoPreferido()+"','"
                +((Persona)contacto).getOcupacion()+"','"+"persona"+"')";
        
       ContactosABC.guardarDatosContacto(querycontactos);
       
        
    }
    
    
     public static void capturaMediosContacto(String tabla,int valorid){
    
    contacto.setMedioContacto(Mensajes.mostrarDialogoCapturaString("Ingresa un medio de contacto, puede ser:"
                +"\n"+"Telefono Celular, Telefono de Casa, Email "));
        
        querymediodecontactos="INSERT INTO contacto(`idPersona`, `Profesion`, `Contactos`)"
                + " VALUES ("+valorid+",'"+tabla+"','"+contacto.getMedioContacto()+"')";
        ContactosABC.guardarDatosContacto(querymediodecontactos);
}
    
    
   
    
    
    
}