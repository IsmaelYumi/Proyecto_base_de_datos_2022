package application;

public class Clientexplan {
	private String cedula;
	private int cod_plan;
	private String fecha_pago;
	private String fecha_prox;
	public Clientexplan(String cedula, int cod_plan, String fecha_pago, String fecha_prox) {
		super();
		this.cedula = cedula;
		this.cod_plan = cod_plan;
		this.fecha_pago = fecha_pago;
		this.fecha_prox = fecha_prox;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public int getCod_plan() {
		return cod_plan;
	}
	public void setCod_plan(int cod_plan) {
		this.cod_plan = cod_plan;
	}
	public String getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(String fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	public String getFecha_prox() {
		return fecha_prox;
	}
	public void setFecha_prox(String fecha_prox) {
		this.fecha_prox = fecha_prox;
	}
	
	

}
