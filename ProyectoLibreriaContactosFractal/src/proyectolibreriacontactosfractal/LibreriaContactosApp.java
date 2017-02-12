
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 */


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
    
    
    
    
    public static void main(String[] args) {
        
        
        mostrarMenuPrincipal();
        
        
        
       
    }
    
    


// muestra el menu principal de la aplicacion
    private static void mostrarMenuPrincipal() {
        valoropcionmenuinteger=Mensajes.mostrarDialogoCapturaInteger("Opciones (Ingresa Numero Correspondiente)"
        +"\n"+"1.- Buscar Contacto "+"\n"+"2.- Agregar Contacto");
        
        if(valoropcionmenuinteger==1)
            mostrarCapturaBuscarContacto();
        else
            mostrarCapturaTipoDeContacto();
        
    }
    


// muestra el un mensaje de entrada para capturar el nombre del contacto a buscar 
    
    private static void mostrarCapturaBuscarContacto() {
        
        valoropcionmenustring=Mensajes.mostrarDialogoCapturaString("Ingresa el nombre del contacto a buscar");
        BusquedaDatos.buscarContacto(valoropcionmenustring);
        mostrarMenuPrincipal();
    
    }
    
    

    private static void mostrarCapturaTipoDeContacto() {
        
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
    



