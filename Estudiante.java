//
package proyectolibreriacontactosfractal;


public class Estudiante extends Contacto 

{

    protected static String lugarnacimiento="";
    protected static String fechanacimiento="";
    protected static String estudiacarrera="";
    protected static String email="";

    public Estudiante()
    
    {
        super();
    }

    public Estudiante(String nombre,String apellidopaterno, String apellidomaterno,
                      String mediocontacto,int idpersonal,String lugarnacimento,String fechanacimiento,String estudiacarrera)
    {
        super(nombre,apellidopaterno, apellidomaterno,mediocontacto,idpersonal);
        this.lugarnacimiento=lugarnacimento;
        this.fechanacimiento=fechanacimiento;
        this.estudiacarrera=estudiacarrera;
        this.email=email;
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
    
    public void setEmail(String email)
    {
        this.email=email;
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
    
    public String getEmail()
    {
        return this.email;
    }
}