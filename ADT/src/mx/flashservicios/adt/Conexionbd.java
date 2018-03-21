package mx.flashservicios.adt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mx.flashservicios.adt.POJO.Crearcuenta;

public class Conexionbd {

	static String bd = "flashmobilemx";
	static String login = "flashmobilemx";
	static String password = "FlashMobile2016";
	static String url = "jdbc:postgresql://fmmdwh01.cyq45q9v5nex.us-west-2.redshift.amazonaws.com:5439/" + bd;

	Connection connection;

	/** Constructor de DbConnection */
	public Conexionbd() {
		try {
			// obtenemos el driver de para mysql
			Class.forName("org.postgresql.Driver");
			// obtenemos la conexión
			connection = (Connection) DriverManager.getConnection(url, login, password);

			if (connection != null) {
				System.out.println("Conexión a base de datos " + bd + " OK\n");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
//	public boolean ifExists(String cuenta) throws SQLException {
//		Crearcuenta generic = new Crearcuenta();
//		Conexionbd conexionbd = new Conexionbd();
//	    PreparedStatement stmt = ((Connection) conexionbd).prepareStatement(cuenta);
//	    stmt.setString(1, generic.getNo_de_Cuenta());
//	    ResultSet rs = stmt.executeQuery();
//	    return rs.next();
//	}

	/** Permite retornar la conexión */
	public Connection getConnection() {
		return connection;
	}

	public void desconectar() {
		connection = null;
	}

}
