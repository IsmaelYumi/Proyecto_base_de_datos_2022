package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
    	try {
    		Stage s =new Stage();
    		FXMLLoader fxmloader= new FXMLLoader(getClass().getResource("/vistas/VentanaMenu.fxml"));
    		Pane root = fxmloader.load();
    		Scene scene= new Scene(root,782,501);
    		s.setScene(scene);
    		s.show();
    		
    	}
    	catch(Exception e) {
    		
    	}

    }

}