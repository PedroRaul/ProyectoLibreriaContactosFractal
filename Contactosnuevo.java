//
package proyectolibreriacontactosfractal;

public class Contacto
{
        //EL metodo de acceso a las variables es protegido para que sean accesibles solo para esta clase y las clases hijas
	protected static String nombre="";
	protected static String apellidopaterno="";
	protected static String apellidomaterno="";
	protected static String mediocontacto="";
        protected static int idpersonal="";


	public Contacto()
	
	{

	}

	public Contacto(String nombre,String apellidopaterno, String apellidomaterno,String mediocontacto,int idpersonal)
	
	{
		this.nombre=nombre;
		this.apellidopaterno=apellidopaterno;
		this.apellidomaterno=apellidomaterno;
		this.mediocontacto=mediocontacto;
                this.idpersonal=idpersonal;
	}

	public void setNombre(String nombre)
	
	{
		this.nombre=nombre;
	}

	public void setApellidoPaterno(String apellidopaterno)
	
	{
		this.apellidopaterno=apellidopaterno;
	}

	public void setApellidoMaterno(String apellidomaterno)
	
	{
		this.apellidomaterno=apellidomaterno;
	}

	public void setMedioContacto(String mediocontacto)

	{
		this.mediocontacto=mediocontacto;
	}
        
        public void setIdPersonal(int idpersonal)

	{
		this.idpersonal=idpersonal;
	}

	public String getNombre()
	
	{
		return this.nombre;
	}

	public String getApellidoPaterno()
	
	{
		return this.apellidopaterno;
	}

	public String getApellidoMaterno()
	
	{
		return this.apellidomaterno;
	}

	public String getMedioContacto()
	{
		return this.mediocontacto;
	}
        public int getIdPersona()
	{
		return this.idpersonal;
	}
}