package proyectolibreriacontactosfractal;

public class Deportista extends Contacto 
{
	private static String genero="";
	private static String fechanacimiento="";
	private static String deporte="";
	

	public Deportista()
	
	{
		super ();
	}

	public Deportista(String nombre,String apellidopaterno, String apellidomaterno,String mediocontacto,int id, String genero, String fechanacimiento, String deporte )
	{
		super(nombre,apellidopaterno,apellidomaterno,mediocontacto,id);
		this.genero=genero;
		this.fechanacimiento=fechanacimiento;
		this.deporte=deporte;
	}

	 public void setGenero(String genero)
	 {
	 	this.genero=genero;
	 }

	 public void setFechaNacimiento(String fechanacimiento)
	 {
	 	this.fechanacimiento=fechanacimiento;
	 }

	 public void setDeporte(String deporte)
	 {
	 	this.deporte=deporte;
	 }

	 public String getGenero()
	 {
	 	return this.genero;
	 }

	 public String getFechaNacimiento()
	 {
	 	return this.fechanacimiento;
	 }

	 public String getDeporte()
	 {
	 	return this.deporte;
	 }
	
}