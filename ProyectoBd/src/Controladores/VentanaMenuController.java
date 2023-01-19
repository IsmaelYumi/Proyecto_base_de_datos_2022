package Controladores;
import application.Auto;
import application.Planes;
import application.Cliente;
import application.Clientexplan;
import application.Conexion;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.table.DefaultTableModel;

import javafx.scene.control.TableColumn;
public class VentanaMenuController implements Initializable{
	

    @FXML
    private Button Automoviles;

    @FXML
    private Button Planes;

    @FXML
    private Button Registro;

    @FXML
    private Button clientes;

    @FXML
    private Label label_busqueda;
    @FXML
    private TableView<?>Tabla;
    @FXML
    private BorderPane bp;
    @FXML
    private TextField txt_busqueda_especifica;
   
    

    
    



    @FXML
    void Registrar_cliente(ActionEvent event) {
    	try {
    		Stage Rclientes= new Stage();
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("/Vistas/RegistrarCliente.fxml"));
    		Pane root= loader.load();
    		Scene Registrar= new Scene(root,738,577);
    		Rclientes.setScene(Registrar);
    		Rclientes.show();
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    		
    	}
    	
    	

    }

    @FXML
    void Vista_Planes(ActionEvent event) {
    	label_busqueda.setText("Codigo:");
    	generar_tabla("Planes","G");
    	
    }

    @FXML
    void Vista_automoviles(ActionEvent event) {
    	label_busqueda.setText("Placa:");
    	generar_tabla("Automovil","G");

    	

    }

    @FXML
    void Vista_clientes(ActionEvent event) {
    	label_busqueda.setText("ID:");
    	generar_tabla("Cliente","G");
    		
			}
    @FXML
    void Vista_pagos(ActionEvent event) {
    	label_busqueda.setText("ID_pagos");
    	generar_tabla("Pagos","G");
    }
    
    @FXML
    void BusquedaEspecifica(ActionEvent event) {
    	if(label_busqueda.getText().equals("ID_pagos:")) {
    		generar_tabla("Pagos","E");
    		
    	}
    	if(label_busqueda.getText().equals("ID:")) {
    		generar_tabla("Cliente","E");
    		
    	}
    	if(label_busqueda.getText().equals("Placa:")){
    		generar_tabla("Automovil","E");
    		
    }
    	if(label_busqueda.getText().equals("Codigo:")){
		generar_tabla("Planes","E");
		
    	
    }
    }
    

   

	public void generar_tabla(String tabla,String opcion) {
    	if (tabla.equals("Cliente")) {
    	
    		TableView<Cliente> tb=new TableView();
    		BorderPane bp=(BorderPane) Planes.getScene().getRoot().getScene().getRoot();
    		tb.setPrefWidth(440);
    		tb.setPrefHeight(380);
    		TableColumn<Cliente,String> cedula= new TableColumn <>("Cedula");
    		TableColumn<Cliente,String> nombre= new TableColumn <>("Nombre");
    		TableColumn<Cliente,String> apellido= new TableColumn <>("Apellido");
    		TableColumn<Cliente,String> fecha_nacimiento= new TableColumn <>("Fecha_nacimiento");
    		cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
    		nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    		apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    		fecha_nacimiento.setCellValueFactory(new PropertyValueFactory<>("fecha_n"));
    		tb.getColumns().addAll(cedula,nombre,apellido,fecha_nacimiento);
    		bp.setCenter(tb);	
    		Conexion con= new Conexion();
    		if(opcion=="G") {
        	try {
    			CallableStatement procedimiento=con.getConexion().prepareCall("{call Vistas(?,?,?,?,?) }");
    			procedimiento.setString(1,"G");
    			procedimiento.setString(2,"C");
    			procedimiento.setString(3,null);
    			procedimiento.setString(4,null);
    			procedimiento.setString(5,null);
    			ResultSet consulta=procedimiento.executeQuery();
    			while(consulta.next()){
    				String cd=consulta.getString(1);
    				String Nom=consulta.getString(2);
    				String apel=consulta.getString(3);
    				String fecha=consulta.getString(4);
    				Cliente cl=new Cliente(cd,Nom,apel,fecha);
    				tb.getItems().add(cl);
    	}
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
    		}
    		if(opcion=="E") {
    			System.out.println("Holi");
    			try {
    			CallableStatement procedimiento=con.getConexion().prepareCall("{call Vistas(?,?,?,?,?) }");
    			procedimiento.setString(1,"E");
    			procedimiento.setString(2,"C");
    			procedimiento.setString(3,txt_busqueda_especifica.getText());
    			procedimiento.setString(4,null);
    			procedimiento.setString(5,null);
    			ResultSet consulta=procedimiento.executeQuery();
    			while(consulta.next()){
    				String cd=consulta.getString(1);
    				String Nom=consulta.getString(2);
    				String apel=consulta.getString(3);
    				String fecha=consulta.getString(4);
    				Cliente cl=new Cliente(cd,Nom,apel,fecha);
    				tb.getItems().add(cl);
    				System.out.println("TOdo bien");
    	}
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
    			
    		}
    		
    		
    	}
    	if(tabla.equals("Automovil")){
    		TableView<Auto> tb2= new TableView<>();
    		BorderPane bp=(BorderPane) Planes.getScene().getRoot().getScene().getRoot();
    		TableColumn<Auto,Integer> cod_auto= new TableColumn <>("codigo");
    		TableColumn<Auto,String> placa= new TableColumn <>("Placa");
    		TableColumn<Auto,String> marca= new TableColumn <>("Marca");
    		TableColumn<Auto,String> modelo= new TableColumn <>("Modelo");
    		TableColumn<Auto,String> Cedula_d= new TableColumn <>("Dueño");
    		cod_auto.setCellValueFactory(new PropertyValueFactory<>("cod_auto"));
    		placa.setCellValueFactory(new PropertyValueFactory<>("placa"));
    		marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
    		modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
    		Cedula_d.setCellValueFactory(new PropertyValueFactory<>("Cedula_d"));
    		tb2.getColumns().addAll(cod_auto,placa,modelo,Cedula_d);
    		bp.setCenter(tb2);
    		Conexion con= new Conexion();
    		if(opcion=="G") {
        	try {
    			CallableStatement procedimiento=con.getConexion().prepareCall("{call Vistas(?,?,?,?,?) }");
    			procedimiento.setString(1,"G");
    			procedimiento.setString(2,"A");
    			procedimiento.setString(3,null);
    			procedimiento.setString(4,null);
    			procedimiento.setString(5,null);
    			ResultSet consulta=procedimiento.executeQuery();
    			while(consulta.next()){
    				int cd=consulta.getInt(1);
    				String pl=consulta.getString(2);
    				String mar=consulta.getString(3);
    				String mo=consulta.getString(4);
    				String du=consulta.getString(5);
    				
    				Auto auto=new Auto(cd,pl,mar,mo,du);
    				tb2.getItems().add(auto);
    	}
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
    		}
        	if(opcion=="E") {
        	try {
    			CallableStatement procedimiento=con.getConexion().prepareCall("{call Vistas(?,?,?,?,?) }");
    			procedimiento.setString(1,"E");
    			procedimiento.setString(2,"A");
    			procedimiento.setString(3,null);
    			procedimiento.setString(4,txt_busqueda_especifica.getText());
    			procedimiento.setString(5,null);
    			ResultSet consulta=procedimiento.executeQuery();
    			while(consulta.next()){
    				int cd=consulta.getInt(1);
    				String pl=consulta.getString(2);
    				String mar=consulta.getString(3);
    				String mo=consulta.getString(4);
    				String du=consulta.getString(5);
    				
    				Auto auto=new Auto(cd,pl,mar,mo,du);
    				tb2.getItems().add(auto);
    	}
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        	}
    		}
    		
    	
    	if(tabla.equals("Pagos")) {
    		TableView<Clientexplan> tb3= new TableView<>();
    		BorderPane bp=(BorderPane) Planes.getScene().getRoot().getScene().getRoot();
    		TableColumn<Clientexplan,Integer> cedula= new TableColumn <>("Cedula");
    		TableColumn<Clientexplan,String> cod_plan= new TableColumn <>("Codigo-Plan");
    		TableColumn<Clientexplan,String> fecha_pago= new TableColumn <>("fecha_pago");
    		TableColumn<Clientexplan,String> fecha_prox= new TableColumn <>("fecha_proxima");
    		cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
    		cod_plan.setCellValueFactory(new PropertyValueFactory<>("cod_plan"));
    		fecha_pago.setCellValueFactory(new PropertyValueFactory<>("fecha_pago"));
    		fecha_prox.setCellValueFactory(new PropertyValueFactory<>("fecha_prox"));
    		tb3.getColumns().addAll(cedula,cod_plan,fecha_pago,fecha_prox);
    		System.out.println("Tabla generada");
    		bp.setCenter(tb3);
    		Conexion con= new Conexion();
    		if(opcion=="G") {
        	try {
    			CallableStatement procedimiento=con.getConexion().prepareCall("{call Vistas(?,?,?,?,?) }");
    			procedimiento.setString(1,"G");
    			procedimiento.setString(2,"S");
    			procedimiento.setString(3,null);
    			procedimiento.setString(4,null);
    			procedimiento.setString(5,null);
    			ResultSet consulta=procedimiento.executeQuery();
    			while(consulta.next()){
    				String  cd=consulta.getString(1);
    				int codigo=consulta.getInt(2);
    				String fecha_act=consulta.getString(3);
    				String fecha_p=consulta.getString(4);
    				Clientexplan auto=new Clientexplan(cd,codigo,fecha_act,fecha_p);
    				tb3.getItems().add(auto);
    	}
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
    		}if(opcion=="E") {
    		try {
    			CallableStatement procedimiento=con.getConexion().prepareCall("{call Vistas(?,?,?,?,?) }");
    			procedimiento.setString(1,"E");
    			procedimiento.setString(2,"S");
    			procedimiento.setString(3,txt_busqueda_especifica.getText());
    			procedimiento.setString(4,null);
    			procedimiento.setString(5,null);
    			ResultSet consulta=procedimiento.executeQuery();
    			while(consulta.next()){
    				String  cd=consulta.getString(1);
    				int codigo=consulta.getInt(2);
    				String fecha_act=consulta.getString(3);
    				String fecha_p=consulta.getString(4);
    				Clientexplan auto=new Clientexplan(cd,codigo,fecha_act,fecha_p);
    				tb3.getItems().add(auto);
    	}
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
    		}    		
    	}
    	if(tabla.equals("Planes")) {
    		TableView<Planes> tb4= new TableView<>();
    		BorderPane bp=(BorderPane) Planes.getScene().getRoot().getScene().getRoot();
    		TableColumn<Planes,Integer> codigo_plan= new TableColumn <>("Codigo");
    		TableColumn<Planes,String> nombre= new TableColumn <>("Nombre");
    		TableColumn<Planes,String> descripccion= new TableColumn <>("Descripccion");   		
    		TableColumn<Planes,Float> valor_pago= new TableColumn <>("Valor del plan");
    		TableColumn<Planes,Float> valor_d= new TableColumn <>("Valor del danio");
    		codigo_plan.setCellValueFactory(new PropertyValueFactory<>("cod_plan"));
    		nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
    		descripccion.setCellValueFactory(new PropertyValueFactory<>("Descripccion"));
    		valor_pago.setCellValueFactory(new PropertyValueFactory<>("valor_plan"));
    		valor_d.setCellValueFactory(new PropertyValueFactory<>("valor_d"));
    		tb4.getColumns().addAll(codigo_plan,nombre,descripccion,valor_pago,valor_d);
    		bp.setCenter(tb4);
    		
    		Conexion con= new Conexion();
    		if(opcion=="G") {
        	try {
    			CallableStatement procedimiento=con.getConexion().prepareCall("{call Vistas(?,?,?,?,?) }");
    			procedimiento.setString(1,"G");
    			procedimiento.setString(2,"P");
    			procedimiento.setString(3,null);
    			procedimiento.setString(4,null);
    			procedimiento.setString(5,null);
    			ResultSet consulta=procedimiento.executeQuery();
    			while(consulta.next()){
    				int codigo=consulta.getInt(1);
    				String Nombre=consulta.getString(2);
    				String Descripccion=consulta.getString(3);
    				float valor_plan=consulta.getFloat(4);
    				float valor_da=consulta.getFloat(5);
    				Planes plan=new Planes(codigo,Nombre,Descripccion,valor_plan,valor_da);
    				tb4.getItems().add(plan);
    	}
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
    		
    	}
    		if(opcion=="E") {
 
    	        	try {
    	    			CallableStatement procedimiento=con.getConexion().prepareCall("{call Vistas(?,?,?,?,?) }");
    	    			int codigo_txt=Integer.parseInt(txt_busqueda_especifica.getText());
    	    			procedimiento.setString(1,"E");
    	    			procedimiento.setString(2,"P");
    	    			procedimiento.setString(3,null);
    	    			procedimiento.setString(4,null);
    	    			procedimiento.setInt(5,codigo_txt);
    	    			ResultSet consulta=procedimiento.executeQuery();
    	    			while(consulta.next()){
    	    				int codigo=consulta.getInt(1);
    	    				String Nombre=consulta.getString(2);
    	    				String Descripccion=consulta.getString(3);
    	    				float valor_plan=consulta.getFloat(4);
    	    				float valor_da=consulta.getFloat(5);
    	    				Planes plan=new Planes(codigo,Nombre,Descripccion,valor_plan,valor_da);
    	    				tb4.getItems().add(plan);
    	    	}
    	        	} catch(Exception e) {
    	        		e.printStackTrace();
    	        	}
    	    		
    	    	}
    			
    		}
	}
    			
    		
        	
    	

    	
    			
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
		
	}
    

}
