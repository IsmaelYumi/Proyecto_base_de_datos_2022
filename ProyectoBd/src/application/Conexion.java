package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	private String url="jdbc:mysql://localhost/securecar";
	public  Connection con;
	
public Conexion()  {
	try {
	con=DriverManager.getConnection(url,"root","root");
	}catch(SQLException  ex){
		ex.printStackTrace();
	}
}
public Connection getConexion() {
	return con;
}
}
