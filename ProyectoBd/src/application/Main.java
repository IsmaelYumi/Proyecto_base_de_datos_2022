package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/Vistas/VentanaPrincipal.fxml"));
			Pane root = fxmlloader.load();
			Scene scene = new Scene(root,650,520);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public static boolean comprobacion(String usu, String paswword) {
		boolean validacion=false;
		if(usu.equals("root") &&  paswword.equals("Hola")) {
			validacion=true;
		}
		return validacion;
	}
}
