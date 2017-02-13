package proyectolibreriacontactosfractal;

/**
 *
 * @author naat
 */
public class EliminarDatos {
    
  public static Contacto dato;  
  public static String queryEliminar;
  public static String queryEliminar_1;
  public static String Profesion;
  public static int idProfesion=0;
  public static void EliminarDatos(String TipoProfesion){
     
      switch(TipoProfesion){
          
          case "deportista":
            dato = new Deportista();
            break;
          case "doctor":
              dato=new Doctor();
              break;
          case "estudiante":
              dato=new Estudiante();
              break;
          case "licenciado":
              dato=new Licenciado();
              break;
          case "persona":
              dato = new Persona();
              break;
          
      }
      dato.setNombre(Mensajes.mostrarDialogoCapturaString("Ingresa el Nombre a eliminar"));
      //validar campo Nombre
      if(dato.getNombre()== null)
          LibreriaContactosApp.mostrarMenuPrincipal();
       
      while(Validaciones.ValidarCadenaVacia(dato.getNombre())){
          Mensajes.mostrarDialogo("No puedes dejar este campo vacio");
          dato.setNombre(Mensajes.mostrarDialogoCapturaString("Ingresa el Nombre a eliminar"));
      }
      
      
      dato.setApellidoPaterno(Mensajes.mostrarDialogoCapturaString("Ingresa Apellido Paterno"));
      //validar campo apellidoPaterno
       if(dato.getApellidoPaterno()== null)
          LibreriaContactosApp.mostrarMenuPrincipal();
       
      while(Validaciones.ValidarCadenaVacia(dato.getApellidoPaterno())){
          Mensajes.mostrarDialogo("No puedes dejar este campo vacio");
          dato.setApellidoPaterno(Mensajes.mostrarDialogoCapturaString("Ingresa Apellido Paterno"));
      }
      dato.setApellidoMaterno(Mensajes.mostrarDialogoCapturaString("Ingresa Apellido Materno")); 
        //validar campo apellidoMaterno
      if(dato.getApellidoMaterno()== null)
          LibreriaContactosApp.mostrarMenuPrincipal();
       
      while(Validaciones.ValidarCadenaVacia(dato.getApellidoMaterno())){
          Mensajes.mostrarDialogo("No puedes dejar este campo vacio");
          dato.setApellidoMaterno(Mensajes.mostrarDialogoCapturaString("Ingresa Apellido Paterno"));
      }
      
      
  }
  public static void EliminarPersonaDeportista(){
      
      EliminarDatos("deportista");
    queryEliminar=("DELETE FROM deportista WHERE Nombre ='"+dato.getNombre()+"'"
                    + "AND ApePa='"+dato.getApellidoPaterno()+"'"
                    + "AND ApeMa='"+dato.getApellidoMaterno()+"'"
                    +"");
    idProfesion=ContactosABC.Id("deportista",dato.getNombre(),dato.getApellidoPaterno()
            ,dato.getApellidoMaterno());
   
    queryEliminar_1=("DELETE FROM contacto WHERE IdPersona='"+idProfesion+"'AND Profesion='"+"deportista"+"'");
    ContactosABC.DatoEliminado(queryEliminar);
    ContactosABC.DatoEliminado(queryEliminar_1);
    
  }
  
  public static void EliminarPersonaDoctor(){
      EliminarDatos("doctor");
      queryEliminar=("DELETE FROM doctor WHERE Nombre ='"+dato.getNombre()+"'"
                    + "AND ApePa='"+dato.getApellidoPaterno()+"'"
                    + "AND ApeMa='"+dato.getApellidoMaterno()+"'"
                    +"");
  idProfesion=ContactosABC.Id("doctor",dato.getNombre(),dato.getApellidoPaterno()
            ,dato.getApellidoMaterno());
   
     queryEliminar_1=("DELETE FROM contacto WHERE IdPersona='"+idProfesion+"'AND Profesion='"+"doctor"+"'");
    ContactosABC.DatoEliminado(queryEliminar);
    ContactosABC.DatoEliminado(queryEliminar_1);
     
  }
  public static void EliminarPersonaEstudiante(){
       EliminarDatos("estudiante");
     queryEliminar=("DELETE FROM estudiante WHERE Nombre ='"+dato.getNombre()+"'"
                    + "AND ApePa='"+dato.getApellidoPaterno()+"'"
                    + "AND ApeMa='"+dato.getApellidoMaterno()+"'"
                    +"");
   idProfesion=ContactosABC.Id("estudiante",dato.getNombre(),dato.getApellidoPaterno()
            ,dato.getApellidoMaterno());
   
     queryEliminar_1=("DELETE FROM contacto WHERE IdPersona='"+idProfesion+"'AND Profesion='"+"estudiante"+"'");
    ContactosABC.DatoEliminado(queryEliminar);
    ContactosABC.DatoEliminado(queryEliminar_1);
    
  }
 public static void EliminarPersonaLicenciado(){
      EliminarDatos("licenciado");
     queryEliminar=("DELETE FROM licenciado WHERE Nombre ='"+dato.getNombre()+"'"
                    + "AND ApePa='"+dato.getApellidoPaterno()+"'"
                    + "AND ApeMa='"+dato.getApellidoMaterno()+"'"
                    +"");
 idProfesion=ContactosABC.Id("licenciado",dato.getNombre(),dato.getApellidoPaterno()
            ,dato.getApellidoMaterno());
   
     queryEliminar_1=("DELETE FROM contacto WHERE IdPersona='"+idProfesion+"'AND Profesion='"+"licenciado"+"'");
    ContactosABC.DatoEliminado(queryEliminar);
    ContactosABC.DatoEliminado(queryEliminar_1);
    
}  
  public static void EliminarPersona(){
        EliminarDatos("persona");
     queryEliminar=("DELETE FROM persona WHERE Nombre ='"+dato.getNombre()+"'"
                    + "AND ApePa='"+dato.getApellidoPaterno()+"'"
                    + "AND ApeMa='"+dato.getApellidoMaterno()+"'"
                    +"");
      idProfesion=ContactosABC.Id("persona",dato.getNombre(),dato.getApellidoPaterno()
            ,dato.getApellidoMaterno());
   
   queryEliminar_1=("DELETE FROM contacto WHERE IdPersona='"+idProfesion+"'AND Profesion='"+"persona"+"'");
    ContactosABC.DatoEliminado(queryEliminar);
    ContactosABC.DatoEliminado(queryEliminar_1);
     
  }
  
  
  
  
    
  
  
  
  
  
  
    
}