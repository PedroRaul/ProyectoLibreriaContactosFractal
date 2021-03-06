package proyectolibreriacontactosfractal;

public class Doctor extends Contacto{
	
	protected static String fechanacimiento="";
	protected static String especialidad="";
	protected static String nombrehospital="";
	protected static String direccionhospital="";
	
	public Doctor(){
		super();
	}
	
	public Doctor(String nombre,String apellidopaterno, String apellidomaterno,String mediocontacto,int id, String especialidad, String fechanacimiento, String direccionhospital,String nombrehospital )
	{
		super(nombre,apellidopaterno,apellidomaterno,mediocontacto,id);
		this.especialidad=especialidad;
		this.fechanacimiento=fechanacimiento;
		this.direccionhospital=direccionhospital;
                this.nombrehospital=nombrehospital;
	}
	
	public void setFechaNacimiento(String fechanacimiento){
		this.fechanacimiento=fechanacimiento;
	}
	
	public void setEspecialidad(String especialidad){
		this.especialidad=especialidad;
	}
	
	public void setNombreHospital(String nombrehospital){
		this.nombrehospital=nombrehospital;
	}
	
	public void setDireccionHospital(String direccionhospital){
		this.direccionhospital=direccionhospital;
	}
	
	public String getFechaNacimiento(){
		return fechanacimiento;
	}
	
	public String getEspecialidad(){
		return especialidad;
	}
	
	public String getNombreHospital(){
		return nombrehospital;
	}
	
	public String getDireccionHospital(){
		return direccionhospital;
	}
}