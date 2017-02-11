//https://github.com/PedroRaul/ProyectoLibreriaContactosFractal.git
package proyectolibreriacontactosfractal;


public class Estudiante extends Contacto 

{

    protected static String lugarnacimiento="";
    protected static String fechanacimiento="";
    protected static String estudiacarrera="";

    public Estudiante()
    
    {
        super();
    }

    public Estudiante(String nombre,String apellidopaterno, String apellidomaterno,String telefonocasa,
                      String telefonocelular,String email,String lugarnacimento,String fechanacimiento,String estudiacarrera)
    {
        super(nombre,apellidopaterno,apellidomaterno,telefonocasa,telefonocelular,email);
        this.lugarnacimiento=lugarnacimento;
        this.fechanacimiento=fechanacimiento;
        this.estudiacarrera=estudiacarrera;
    }

    public void setLugarNacimiento(String lugarnacimiento)
    {
        this.lugarnacimiento=lugarnacimiento;
    }

    public void setFechaNacimiento(String fechanacimiento)
    {
        this.fechanacimiento=fechanacimiento;
    }

    public void setEstudiaCarrera(String estudiacarrera)
    {
        this.estudiacarrera=estudiacarrera;
    }

    public String getLugarNacimento() {
        return this.lugarnacimiento;
    }

    public String getFechaNacimiento() {
        return this.fechanacimiento;
    }

    public String getEstudiaCarrera()
    {
        return this.estudiacarrera;
    }
}