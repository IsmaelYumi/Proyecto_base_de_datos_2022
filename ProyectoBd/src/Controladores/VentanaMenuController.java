package Controladores;
import application.Conexion;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

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
   
    private TableView<String> Tabla;

    
    



    @FXML
    void Registrar_cliente(ActionEvent event) {

    }

    @FXML
    void Vista_Planes(ActionEvent event) {
    	label_busqueda.setText("Codigo:");

    }

    @FXML
    void Vista_automoviles(ActionEvent event) {
    	label_busqueda.setText("Placa:");

    	

    }

    @FXML
    void Vista_clientes(ActionEvent event) {
    	label_busqueda.setText("ID:");
    	generar_tabla("Cliente");
    	Conexion con= new Conexion();
    	try {
			CallableStatement procedimiento=con.getConexion().prepareCall("{call Vistas(?,?,?,?,?) }");
			procedimiento.setString(1,"G");
			procedimiento.setString(2,"C");
			procedimiento.setString(3,null);
			procedimiento.setString(4,null);
			procedimiento.setString(5,null);
			ResultSet consulta=procedimiento.executeQuery();
			while(consulta.next()){
				String cedula=consulta.getString(1);
				String Nombre=consulta.getString(2);
				String apellido=consulta.getString(3);
				String fecha_n=consulta.getString(4);
			ObservableList<String> datos=FXCollections.observableArrayList(cedula,Nombre,apellido,fecha_n);
			this.Tabla.setItems(datos);
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


    }
    public  void generar_tabla(String tabla) {
    	if (tabla.equals("Cliente")) {
    		Scene sc= this.Automoviles.getScene();
    		this.Tabla= (TableView<String>)sc.lookup("#Tabla");
    		TableColumn<?,String> cedula= new TableColumn <>("Cedula");
    		TableColumn<?,String> nombre= new TableColumn <>("Nombre");
    		TableColumn<?,String> apellido= new TableColumn <>("Apellido");
    		TableColumn<?,String> fecha_nacimiento= new TableColumn <>("Fecha_nacimiento");
    		cedula.setCellValueFactory(new PropertyValueFactory("Cedula"));
    		nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
    		apellido.setCellValueFactory(new PropertyValueFactory<String, String>("Apellido"));
    		fecha_nacimiento.setCellValueFactory(new PropertyValueFactory<String, String>("Fecha_nacimiento"));
    		this.Tabla.getColumns().addAll(cedula,nombre,apellido,fecha_nacimiento);
    		System.out.println("Tabla generada");
    		
    		
    		
    	}
    
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
		
	}
    

}
