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
      dato.setApellidoMaterno(Mensajes.mostrarDialogoCapturaString("Ingresa Apellido Materno"));   
  } 
  
  
 
  
  
  public static void EliminarPersonaDeportista(){
      
      EliminarDatos(ContactosABC.tabladeportista);
      System.out.println(ContactosABC.tabladeportista);
      System.out.println(dato.getNombre());
      System.out.println(dato.getApellidoMaterno());
    
            queryEliminar=("DELETE FROM "+ContactosABC.tabladeportista+" WHERE Nombre ='"+dato.getNombre()+"'"
                    + "AND ApePa='"+dato.getApellidoPaterno()+"'"
                    + "AND ApeMa='"+dato.getApellidoMaterno()+"'"
                    +"");
    ContactosABC.DatoEliminado(queryEliminar);
      
  }
  
  public static void EliminarPersonaDoctor(){
      EliminarDatos(ContactosABC.tabladoctor);
     
     
    
            queryEliminar=("DELETE FROM "+ContactosABC.tabladoctor+" WHERE Nombre ='"+dato.getNombre()+"'"
                    + "AND ApePa='"+dato.getApellidoPaterno()+"'"
                    + "AND ApeMa='"+dato.getApellidoMaterno()+"'"
                    +"");
    ContactosABC.DatoEliminado(queryEliminar); 
  }
 
  
  public static void EliminarPersonaEstudiante(){
       EliminarDatos(ContactosABC.tablaestudiante);
     
     
    
            queryEliminar=("DELETE FROM "+ContactosABC.tablaestudiante+" WHERE Nombre ='"+dato.getNombre()+"'"
                    + "AND ApePa='"+dato.getApellidoPaterno()+"'"
                    + "AND ApeMa='"+dato.getApellidoMaterno()+"'"
                    +"");
    ContactosABC.DatoEliminado(queryEliminar); 
  }
        


public static void EliminarPersonaLicenciado(){
      EliminarDatos(ContactosABC.tablalicenciado);
     
     
    
            queryEliminar=("DELETE FROM "+ContactosABC.tablalicenciado+" WHERE Nombre ='"+dato.getNombre()+"'"
                    + "AND ApePa='"+dato.getApellidoPaterno()+"'"
                    + "AND ApeMa='"+dato.getApellidoMaterno()+"'"
                    +"");
    ContactosABC.DatoEliminado(queryEliminar); 
}  
  public static void EliminarPersona(){
        EliminarDatos(ContactosABC.tablapersona);
     
     
    
            queryEliminar=("DELETE FROM "+ContactosABC.tablapersona+" WHERE Nombre ='"+dato.getNombre()+"'"
                    + "AND ApePa='"+dato.getApellidoPaterno()+"'"
                    + "AND ApeMa='"+dato.getApellidoMaterno()+"'"
                    +"");
    ContactosABC.DatoEliminado(queryEliminar); 
  }
    
}
