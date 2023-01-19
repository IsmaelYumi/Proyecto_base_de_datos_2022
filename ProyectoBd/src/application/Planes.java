package application;

public class Planes {
	private int cod_plan;
	private String Nombre;
	private String Descripccion;
	private float valor_plan;
	private float valor_d;
	
	public Planes(int cod_plan, String nombre, String descripccion, float valor_plan, float valor_d) {
		super();
		this.cod_plan = cod_plan;
		Nombre = nombre;
		Descripccion = descripccion;
		this.valor_plan = valor_plan;
		this.valor_d = valor_d;
	}
	public int getCod_plan() {
		return cod_plan;
	}
	public void setCod_plan(int cod_plan) {
		this.cod_plan = cod_plan;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripccion() {
		return Descripccion;
	}
	public void setDescripccion(String descripccion) {
		Descripccion = descripccion;
	}
	public float getValor_plan() {
		return valor_plan;
	}
	public void setValor_plan(float valor_plan) {
		this.valor_plan = valor_plan;
	}
	public float getValor_d() {
		return valor_d;
	}
	public void setValor_d(float valor_d) {
		this.valor_d = valor_d;
	}
	

}
