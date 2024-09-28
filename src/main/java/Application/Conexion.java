package Application;
import java.sql.*;

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
