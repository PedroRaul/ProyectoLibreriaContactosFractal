package proyectolibreriacontactosfractal;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModificarDatos {
    
    public static void altasDeportista() {
        conexion conex = new conexion();
    }
    public static void altasDoctor() {}
    public static void altasEstudiante() {}
    public static void altasLicenciado() {}
    public static void altasPersona() {}
    
    
  
    private static Contacto contacto;
    private static conexion conexion;
    public static void modificarContacto(String tipo, String contacto)
    {
        conexion=new conexion();
        conexion.conectar();
        try{
                                                            
            Statement estatuto = conexion.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "select * from %1$s where Nombre like '%2$s'";
            SQL = String.format(SQL, tipo, contacto);
            System.out.println( SQL );
            ResultSet r = estatuto.executeQuery( SQL );
            if(r.next()){
                ResultSetMetaData md = r.getMetaData();
                for(int i=1;i<= md.getColumnCount();i++){
                    String key = md.getColumnLabel(i);
                    String val = r.getString(key);
                    if(!key.toLowerCase().contains("id") && !key.toLowerCase().contains("profes")  ){ // Solo si no es la columna ID entramos
                        String msg = "Nuevo valor para %1$s ? (deje en blanco conservar previo '%2$s')";
                        String new_value = Mensajes.mostrarDialogoCapturaString( String.format(msg, key, val)  );
                        new_value = ( new_value.isEmpty() )? val : new_value ; // Si vacio ponemos valor anterior
                        r.updateString(key, new_value);
                    }
                }
                r.updateRow();
                Mensajes.mostrarDialogo("Listo..");
                BusquedaDatos.buscarContacto(tipo, contacto);
            }
            estatuto.close();
            conexion.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            Mensajes.mostrarDialogo("Error en el registro intente de nuevo");
        }
    
    }
}
