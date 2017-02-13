package proyectolibreriacontactosfractal;


/**
     * Clase que ejecuta la Aplicacion
     */
    
    
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class LibreriaContactosApp {

    
    //Almacena el valor entero capturado por el usuario
    private static int valoropcionmenuinteger;
    
    //Almacena una cadena de caracteres capturada por el usuario
    private static String valoropcionmenustring;
    private static String valorprofesionmenustring;
    private static String nombreamodificar;
    private static String valorcaptura;
    
    
    
    
    public static void main(String[] args) {
        
        
       mostrarMenuPrincipal();
        
        
        
       
    }
    
    


// muestra el menu principal de la aplicacion
    public static void mostrarMenuPrincipal() {
        valorcaptura=Mensajes.mostrarDialogoCapturaString("Opciones (Ingresa Numero Correspondiente)"
        +"\n"+"1.- Buscar Contacto "+"\n"+"2.- Agregar Contacto"+"\n"+"3.-Modificar Contacto"+"\n"+"4.-Eliminar Contacto");
        
        if(valorcaptura==null)
           System.exit(0);
        else 
        {
        
            switch(valorcaptura){
            case "1":
                mostrarCapturaBuscarContacto();
            break;
            case "2":
                mostrarCapturaTipoDeContactoAgregar();
            break;
            case "3":
                mostrarCapturaTipoDeContactoModificar();
            break;
            case "4":
                mostrarCapturaEliminarComtacto();
            break;
           
            default:
                Mensajes.mostrarDialogo("Opcion Invalida intenta de nuevo");
                mostrarMenuPrincipal();
        }
        
        }
    }
    
   
    
    
    
   
    
// muestra el un mensaje de entrada para capturar el nombre del contacto a buscar 
    
    private static void mostrarCapturaBuscarContacto() {
        
        valorprofesionmenustring=Mensajes.mostrarDialogoCapturaString
        ("INGRESA EL NUMERO CORRESPONDIENTE A LA PROFESION...\n\n1.Deportista\n2-Doctor\n3.Estudiante\n4.Licenciado\n5.Persona");
        
        /*Valida la salida de la ventana, si regresa un null regresa a la ventana anterior 
          si es diferentede null continua el metodo*/
        if(valorprofesionmenustring==null)
        {
           mostrarMenuPrincipal();
        }
            
          
        
        switch(valorprofesionmenustring)
        {
            case "1":
                BusquedaDatos.menuEleccionDeportista(valorprofesionmenustring);
            break;
            case"2":
                BusquedaDatos.menuEleccionDoctor(valorprofesionmenustring);
            break;
            case"3":
                BusquedaDatos.menuEleccionEstudiante(valorprofesionmenustring);
            break;
            case"4":
                BusquedaDatos.menuEleccionLicenciado(valorprofesionmenustring);
            break;
            case"5":
                BusquedaDatos.menuEleccionPersona(valorprofesionmenustring);
            break;
            default : mostrarCapturaBuscarContacto();
                    
               
        }
         }
        
        
       
    
    
     private static void mostrarCapturaEliminarComtacto(){ 
         
         
        valoropcionmenustring=Mensajes.mostrarDialogoCapturaString("Ingresa el tipo de contacto");
            if(valoropcionmenustring==null)
                mostrarMenuPrincipal();
    
    evaluarTipoDeContactoEliminar();
     }
    
    

    private static void mostrarCapturaTipoDeContactoAgregar() {
        valoropcionmenustring=Mensajes.mostrarDialogoCapturaString("Ingresa el tipo de contacto");
        
        if(valoropcionmenustring==null)
            mostrarMenuPrincipal();
        evaluarTipoDeContactoAgregrar();
    }
    
    private static void mostrarCapturaTipoDeContactoModificar() {
        valoropcionmenustring=Mensajes.mostrarDialogoCapturaString("Ingresa el tipo de contacto");
        
        if(valoropcionmenustring==null)
        mostrarMenuPrincipal();
        
        evaluarTipoDeContactoModificar();
    }
    
    
    
    private static void evaluarTipoDeContactoAgregrar(){
        
        switch(valoropcionmenustring)
        {
            case"deportista":
                CapturarDatos.capturarDatosDeportista();
                mostrarMenuPrincipal();
            break;
            case"doctor":
                CapturarDatos.capturarDatosDoctor();
                mostrarMenuPrincipal();
            
            break;
            case"estudiante":
                CapturarDatos.capturarDatosEstudiante();
                mostrarMenuPrincipal();
            break;
            case"licenciado":
                CapturarDatos.capturarDatosLicenciado();
                mostrarMenuPrincipal();
            break;
            case"persona":
                CapturarDatos.capturarDatosPersona();
                mostrarMenuPrincipal();
            break;
        }
    
    
    }
    
    private static void evaluarTipoDeContactoModificar(){
        
        switch(valoropcionmenustring)
        {
            case"deportista":
                nombreamodificar=Mensajes.mostrarDialogoCapturaString("Ingresa el nombre del contacto a actualizar");
                ModificarDatos.modificarContacto(valoropcionmenustring, nombreamodificar);
            break;
            case"doctor":
                nombreamodificar=Mensajes.mostrarDialogoCapturaString("Ingresa el nombre del contacto a actualizar");
                ModificarDatos.modificarContacto(valoropcionmenustring, nombreamodificar);
            
            break;
            case"estudiante":
                nombreamodificar=Mensajes.mostrarDialogoCapturaString("Ingresa el nombre del contacto a actualizar");
                ModificarDatos.modificarContacto(valoropcionmenustring, nombreamodificar);
            break;
            case"licenciado":
                nombreamodificar=Mensajes.mostrarDialogoCapturaString("Ingresa el nombre del contacto a actualizar");
                ModificarDatos.modificarContacto(valoropcionmenustring, nombreamodificar);
            break;
            case"persona":
                nombreamodificar=Mensajes.mostrarDialogoCapturaString("Ingresa el nombre del contacto a actualizar");
                ModificarDatos.modificarContacto(valoropcionmenustring, nombreamodificar);
            break;
            default:Mensajes.mostrarDialogo("Dato no existe,Intente de nuevo \n Existentes: deportista, doctor, estudiante, licenciado, persona");
                break;
        }
    }
    
    public static void evaluarTipoDeContactoEliminar(){
        switch(valoropcionmenustring)
        {
            case"deportista":
                EliminarPersona.EliminarPersonaDeportista();
                mostrarMenuPrincipal();
            break;
             case"doctor":
                EliminarPersona.EliminarPersonaDoctor();
                mostrarMenuPrincipal();
            break;
              case"estudiante":
                EliminarPersona.EliminarPersonaEstudiante();
                mostrarMenuPrincipal();
            break;
            case"Licenciado":
                EliminarPersona.EliminarPersonaLicenciado();
                mostrarMenuPrincipal();
            break;
            case"persona":
                EliminarPersona.EliminarPersona();
                mostrarMenuPrincipal();
            break;
           
        }
      
     }
    
   
}