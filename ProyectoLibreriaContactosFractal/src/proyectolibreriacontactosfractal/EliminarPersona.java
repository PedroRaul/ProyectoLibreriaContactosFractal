//
package proyectolibreriacontactosfractal;
/**
 *
 * @author naat
 */
public class EliminarPersona {
    
  public static Contacto dato;  
  public static String queryEliminar;
  public static String Profesion;
  
  public static void EliminarDatos(String TipoProfesion){
     
      switch(TipoProfesion){
          
          case ContactosABC.tabladeportista:
            dato = new Deportista();
            break;
          case ContactosABC.tabladoctor:
              dato=new Doctor();
              break;
          case ContactosABC.tablaestudiante:
              dato=new Estudiante();
              break;
          case ContactosABC.tablalicenciado:
              dato=new Licenciado();
              break;
          case ContactosABC.tablapersona:
              dato = new Persona();
              break;
          
      }
      dato.setNombre(Mensajes.mostrarDialogoCapturaString("Ingresa el Nombre a eliminar"));
      dato.setApellidoPaterno(Mensajes.mostrarDialogoCapturaString("Ingresa Apellido Paterno"));
      //dato.setApellidoMaterno(Mensajes.mostrarDialogoCapturaString("Ingresa Apellido Materno"));   
  } 
  
  
 
  
  
  public static void EliminarPersonaDeportista(){
      
      EliminarDatos(ContactosABC.tabladeportista);
      
    
            queryEliminar=("DELETE FROM "+ContactosABC.tabladeportista+" WHERE Nombre ='"+dato.getNombre()+"'"
                    + "AND ApePa='"+dato.getApellidoMaterno()+"'"
                    + "");
    ContactosABC.DatoEliminado(queryEliminar);
      
  }
  
  public static void EliminarPersonaDoctor(){
      
  }
  
  
  
    
}
