package application;

public class Auto {
private  int cod_auto;
private String placa;
private String marca ;
public Auto(int cod_auto, String placa, String marca, String modelo, String cedula_d) {
	super();
	this.cod_auto = cod_auto;
	this.placa = placa;
	this.marca = marca;
	this.modelo = modelo;
	Cedula_d = cedula_d;
}
private String modelo;
private String Cedula_d;
public int getCod_auto() {
	return cod_auto;
}
public void setCod_auto(int cod_auto) {
	this.cod_auto = cod_auto;
}
public String getPlaca() {
	return placa;
}
public void setPlaca(String placa) {
	this.placa = placa;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getCedula_d() {
	return Cedula_d;
}
public void setCedula_d(String cedula_d) {
	Cedula_d = cedula_d;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}

}
