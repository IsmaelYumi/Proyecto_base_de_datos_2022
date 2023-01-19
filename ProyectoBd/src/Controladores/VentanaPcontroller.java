package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VentanaPcontroller {

    @FXML
    private Button BotonInicio;

    @FXML
    private TextField txt_contr;

    @FXML
    private TextField txt_user;

    @FXML
    void IniciarSesion(ActionEvent event) {
    	String usuario=txt_user.getText();
    	String contra=txt_contr.getText();
    	if(usuario.equals("yumi")&& contra.equals("123")) {
    	try {
    		Stage s =new Stage();
    		FXMLLoader fxmloader= new FXMLLoader(getClass().getResource("/Vistas/VentanaMenu.fxml"));
    		Pane root = fxmloader.load();
    		Scene scene= new Scene(root,1250,650);
    		s.setScene(scene);
    		s.show();
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		
    	}
    	}else {
    		Alert Error =new Alert(AlertType.INFORMATION,"Usuario no registrado");
    		Error.show();
    	}
    }

}
