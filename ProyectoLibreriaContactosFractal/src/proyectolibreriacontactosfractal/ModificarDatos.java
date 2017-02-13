package proyectolibreriacontactosfractal;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModificarDatos {
    
    public static void altasDeportista() {
    }
    public static void altasDoctor() {}
    public static void altasEstudiante() {}
    public static void altasLicenciado() {}
    public static void altasPersona() {}
    
    
  
    private static Contacto contacto;
    private static conexion conexion;
    public static void modificarContacto(String tipo, String contacto)//tipo = clase 
    {
        conexion=new conexion();
        conexion.conectar();
        try{ 
                                                            
            Statement estatuto = conexion.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);//CONCUR_UPDATABLE= permiso para actualixar
            String SQL = "select * from %1$s where Nombre like '%2$s'";// 1= parametro s = codificaciones 
            SQL = String.format(SQL, tipo, contacto);
            System.out.println( SQL );
            ResultSet r = estatuto.executeQuery( SQL );// busqueda de la tabla y nos regresa un ResultSet
            if(r.next()){
                ResultSetMetaData md = r.getMetaData();// meatadatos ; saber  
                for(int i=1;i<= md.getColumnCount();i++){// cantidad de columnas 
                    String key = md.getColumnLabel(i);// nombre de la clumna nobre, apellido etc
                    String val = r.getString(key);//nombre de la persona 
                    if(!key.toLowerCase().contains("id") && !key.toLowerCase().contains("profes")  ){ // Solo si no es la columna ID entramos, no pregunta id ni profesion
                        String msg = "Nuevo valor para %1$s ? (deje en blanco conservar previo '%2$s')";// parametro 1  2 segundo parametro 
                        String new_value = Mensajes.mostrarDialogoCapturaString( String.format(msg, key, val)  );
                        new_value = ( new_value.isEmpty() )? val : new_value ; // Si vacio ponemos valor anterior  , pregunta so dejo en blanco 
                        r.updateString(key, new_value);// key es columna ,
                    }
                }
                r.updateRow();//confirmar cambios hechos y eniciar al la BD
                Mensajes.mostrarDialogo("Modificación Realizada..");
                BusquedaDatos.buscarContacto(tipo, contacto);// ver cambios 
            }
            else
            {
             JOptionPane.showMessageDialog(null, "Dato no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
           
            }
            estatuto.close();
            conexion.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            Mensajes.mostrarDialogo("Error en el registro intente de nuevo");
        }
    
    }
}
