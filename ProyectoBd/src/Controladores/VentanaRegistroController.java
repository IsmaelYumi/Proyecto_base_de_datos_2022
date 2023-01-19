package Controladores;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import application.Conexion;
import application.Main;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class VentanaRegistroController implements Initializable{

    @FXML
    private Button boton_enviar;

    @FXML
    private ComboBox<Integer> cb_anio;

    @FXML
    private ComboBox<Integer> cb_dia;

    @FXML
    private ComboBox<Integer> cb_mes;

    @FXML
    private ComboBox<Integer> cb_plan;
    

    @FXML
    private TextField txt_apellido;

    @FXML
    private TextField txt_cedula;

    @FXML
    private TextField txt_marca;

    @FXML
    private TextField txt_modelo;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_placa;


    @FXML
    void Enviar_informacion(ActionEvent event) {
    	if(Main.validacion_vacio(txt_apellido.getText())&& Main.validacion_vacio(txt_nombre.getText())&& Main.validacion_vacio(txt_cedula.getText()) ) {
    		Alert alerta1=new Alert(AlertType.INFORMATION,"Debe llenar todos los campos");
    		alerta1.show();	
    	}else {
    		if(Main.Validacion_letras(txt_apellido.getText())&& Main.Validacion_letras(txt_nombre.getText())&& Main.Validacion_letras(txt_cedula.getText())) {
    			Alert alerta2=new Alert(AlertType.INFORMATION,"Debe poner solo letras");
    			alerta2.show();
    		}else {
    			if(Main.Validacion_numeros(txt_cedula.getText())==false) {
    				Alert alerta3=new Alert(AlertType.INFORMATION,"Solo debe contener Numeros");
    				alerta3.show();
    			}else {
    			Conexion con= new Conexion();
            	try {
            	SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");
            	String fecha_nacimiento=cb_dia.getValue()+"-"+cb_mes.getValue()+"-"+cb_anio.getValue();
            	java.util.Date Fecha=formato.parse(fecha_nacimiento);
            	long fechaN=Fecha.getTime();
            	java.sql.Date fechaNacimiento= new java.sql.Date(fechaN);
        			CallableStatement procedimiento=con.getConexion().prepareCall("{call CRUD_clientexplan(?,?,?,?,?,?,?,?,?,?) }");
        			procedimiento.setString(1,"I");
        			procedimiento.setString(2,txt_cedula.getText());
        			procedimiento.setString(3,txt_nombre.getText());
        			procedimiento.setString(4,txt_apellido.getText());
        			procedimiento.setInt(5,cb_plan.getValue());
        			procedimiento.setDate(6,fechaNacimiento );
        			procedimiento.setString(7,txt_placa.getText());
        			procedimiento.setString(8,txt_marca.getText());
        			procedimiento.setString(9,txt_modelo.getText());
        			procedimiento.executeUpdate();
        			Alert alertaCreacion=new Alert(AlertType.INFORMATION,"Datos enviados");
        			alertaCreacion.show();
    			}catch(Exception a) {
    				a.printStackTrace();
    			}
    			}
    		}
    	}
    }
    		
    	
    	

    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Integer> items = FXCollections.observableArrayList();
		int numero=1;
		while(numero<=31) {
			items.add(numero);
			numero=numero+1;
		
	}
		cb_dia.getItems().addAll(items);
		ObservableList<Integer> mes = FXCollections.observableArrayList();
		numero=1;
		while(numero<=12) {
			mes.add(numero);
			numero=numero+1;
		
	}
		cb_mes.getItems().addAll(mes);
		ObservableList<Integer> año = FXCollections.observableArrayList();
		numero=1920;
		while(numero<=2006) {
		año.add(numero);
			numero=numero+1;
		
	}
		cb_anio.getItems().addAll(año);
		cb_plan.getItems().addAll(1,2,3);
		

}
	

	
}
