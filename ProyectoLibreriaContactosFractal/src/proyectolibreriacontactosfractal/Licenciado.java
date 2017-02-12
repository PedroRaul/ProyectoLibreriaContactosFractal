//
package proyectolibreriacontactosfractal;

public class Licenciado extends Contacto

{

	protected static String telefonooficina="";
	protected static String horarioatencioninicio="";
	protected static String horarioatencionfin="";

	public Licenciado()
	
	{
		super();
	}

	public Licenciado(String nombre,String apellidopaterno, String apellidomaterno,
		String telefonocasa,String telefonocelular,String email, String telefonooficina,
		String horarioatencioninicio, String horarioatencionfin)
	{
		super(nombre,apellidopaterno,apellidomaterno,telefonocasa,telefonocelular,email);
		this.telefonooficina=telefonooficina;
		this.horarioatencioninicio=horarioatencioninicio;
		this.horarioatencionfin=horarioatencionfin;
	}

	public void setTelefonoOficina(String telefonooficina)
	
	{
		this.telefonooficina=telefonooficina;
	}

	public void setHorarioAtencionInicio(String horarioatencioninicio)
	
	{
		this.horarioatencioninicio=horarioatencioninicio;
	}

	public void setHorarioAtencionFin(String horarioatencionfin)
	
	{
		this.horarioatencionfin=horarioatencionfin;
	}

	public String getTelefonoOficina()
	
	{
		return this.telefonooficina;
	}

	public String getHorarioAtencionInicio()

	{
		return this.horarioatencioninicio;
	}

	public String getHorarioAtencionFin()

	{
		return this.horarioatencionfin;
	}


	
}