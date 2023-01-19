package application;

public class Cliente {
	private String cedula;
	private String nombre;
	private String apellido;
	private String Fecha_n;
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFecha_n() {
		return Fecha_n;
	}
	public void setFecha_n(String fecha_n) {
		Fecha_n = fecha_n;
	}
	public Cliente(String cedula, String nombre, String apellido, String fecha_n) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		Fecha_n = fecha_n;
	}
	

}
