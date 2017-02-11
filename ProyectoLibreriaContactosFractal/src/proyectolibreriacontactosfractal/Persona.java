
package proyectolibreriacontactosfractal;




public class Persona extends Contacto{
	
	protected static String domicilio="";
	protected static String contactopreferido="";
	protected static String ocupacion="";
	
	public Persona(){
		super();
	}
	
	public Persona(String nombre,String apellidopaterno, String apellidomaterno,
				   String telefonocasa,String telefonocelular,String email,String domicilio,String contactopreferido,String ocupacion){
		super(nombre,apellidopaterno,apellidomaterno,telefonocasa,telefonocelular,email);
		this.domicilio=domicilio;
		this.contactopreferido=contactopreferido;
		this.ocupacion=ocupacion;
	}
	
	public void setDomicilio(String domicilio){
		this.domicilio=domicilio;
	}
	
	public void setContactoPreferido(String contactopreferido){
		this.contactopreferido=contactopreferido;
	}
	
	public void setOcupacion(String ocupacion){
		this.ocupacion=ocupacion;
	}
	
	public String getDomicilio(){
		return domicilio;
	}
	
	public String getContactoPreferido(){
		return contactopreferido;
	}
	
	public String getOcupacion(){
		return ocupacion;
	}
}
