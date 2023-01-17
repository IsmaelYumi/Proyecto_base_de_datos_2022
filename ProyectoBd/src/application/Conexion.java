package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	private String url="jdbc:mysql://localhost/securecar";
	private Connection con;
	
public Conexion()  {
	try {
	con=DriverManager.getConnection(url);
	}catch(SQLException  ex){
		System.out.println("Conexion fallida");
		ex.printStackTrace();
	}
}
}
