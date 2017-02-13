
package proyectolibreriacontactosfractal;

public class Contacto
{
	protected static String nombre="";
	protected static String apellidopaterno="";
	protected static String apellidomaterno="";
	protected static String telefonocelular="";
	protected static String telefonocasa="";
	protected static String email="";


	public Contacto()
	
	{

	}

	public Contacto(String nombre,String apellidopaterno, String apellidomaterno,String telefonocasa,
		String telefonocelular,String email)
	
	{
		this.nombre=nombre;
		this.apellidopaterno=apellidopaterno;
		this.apellidomaterno=apellidomaterno;
		this.telefonocelular=telefonocelular;
		this.telefonocasa=telefonocasa;
		this.email=email;
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

	public void setTelefonoCasa(String telefonocasa)

	{
		this.telefonocasa=telefonocasa;
	}

	public void setTelefonoCelular (String telefonocelular)
	{
		this.telefonocelular=telefonocelular;
	}
        
        public void setEmail (String email)
	{
		this.email=email;
	}

	public String getNombre()
	
	{
		return this.nombre;
	}

	public String getApellidoPaterno()
	
	{
		return this.apellidomaterno;
	}

	public String getApellidoMaterno()
	
	{
		return this.apellidomaterno;
	}

	public String getTelefonoCasa()
	{
		return this.telefonocasa;
	}

	public String getTelefonoCelular()
	{
		return this.telefonocelular;
	}

	public String getEmail()
	{
		return this.email;
	}
}