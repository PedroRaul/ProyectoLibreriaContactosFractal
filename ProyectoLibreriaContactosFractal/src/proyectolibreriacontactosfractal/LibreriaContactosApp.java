//

//https://github.com/PedroRaul/ProyectoLibreriaContactosFractal.git

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
    private static String nombre;
    
    
    
    
    public static void main(String[] args) {
        
        
       mostrarMenuPrincipal();
        
        
        
       
    }
    
    


// muestra el menu principal de la aplicacion
    private static void mostrarMenuPrincipal() {
        valoropcionmenuinteger=Mensajes.mostrarDialogoCapturaInteger("Opciones (Ingresa Numero Correspondiente)"
        +"\n"+"1.- Buscar Contacto "+"\n"+"2.- Agregar Contacto"+"\n"+"3.-Modificar Contacto"+"\n"+"4.-Eliminar Contacto");
        
        if(valoropcionmenuinteger==1)
            mostrarCapturaBuscarContacto();
        else if( valoropcionmenuinteger == 2 )
            mostrarCapturaTipoDeContacto();
        else if( valoropcionmenuinteger == 3 )     
            mostrarCapturaEditarContacto();
        else if( valoropcionmenuinteger == 4 )
            mostrarCapturaEliminarComtacto();
         else if( valoropcionmenuinteger == 5 )
            System.exit(0);
        
    }
    
   
    
    
    
    private static void mostrarCapturaEditarContacto() {
        String tipo = Mensajes.mostrarDialogoCapturaString("Ingresa tipo de contacto.");           
        valoropcionmenustring=Mensajes.mostrarDialogoCapturaString("Ingresa el nombre del contacto a actualizar");
        ModificarDatos.modificarContacto(tipo, valoropcionmenustring);
        mostrarMenuPrincipal();
    
    }
    
// muestra el un mensaje de entrada para capturar el nombre del contacto a buscar 
    
    private static void mostrarCapturaBuscarContacto() {
        
        valorprofesionmenustring=Mensajes.mostrarDialogoCapturaString("INGRESA EL NUMERO CORRESPONDIENTE A LA PROFESION...\n\n1.Deportista\n2-Doctor\n3.Estudiante\n4.Licenciado\n5.Persona");
        //valoropcionmenustring=Mensajes.mostrarDialogoCapturaString("Ingresa el nombre del contacto a buscar");
       
        switch(valorprofesionmenustring)
        {
            case "1":
                BusquedaDatos.menuEleccionDeportista(valorprofesionmenustring);
            break;
            case"2":
                BusquedaDatos.buscarDoctor(valorprofesionmenustring);
            break;
            case"3":
                BusquedaDatos.buscarEstudiante(valorprofesionmenustring);
            break;
            case"4":
                BusquedaDatos.buscarLicenciado(valorprofesionmenustring);
            break;
            case"5":
                BusquedaDatos.buscarPersona(valorprofesionmenustring);
            break;
                case"6":
                BusquedaDatos.buscarEjemplo(valorprofesionmenustring);
            break;
        }
        mostrarMenuPrincipal();
    }
    
     private static void mostrarCapturaEliminarComtacto(){
      Mensajes.mostrarDialogoCapturaString("Ingresa tipo de contacto.");  
    valoropcionmenustring=Mensajes.mostrarDialogoCapturaString("Ingresa el tipo de contacto");
      TipoProfesion();
     }
     public static void TipoProfesion(){
        switch(valoropcionmenustring)
        {
            case"deportista":
                EliminarPersona.EliminarPersonaDeportista();
                mostrarMenuPrincipal();
            break;
           
        }
      
     }
    

    private static void mostrarCapturaTipoDeContacto() {
        String tipo = Mensajes.mostrarDialogoCapturaString("Ingresa tipo de contacto."); 
        valoropcionmenustring=Mensajes.mostrarDialogoCapturaString("Ingresa el tipo de contacto");
            evaluarTipoDeContacto();
    }
    
    private static void evaluarTipoDeContacto(){
        
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
    
   
}
    
