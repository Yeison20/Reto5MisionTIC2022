package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCutilities {

	private static final String UBICACION_BD = "C://Users//yeiso//Documents//Mision TIC//Java//Retos//Reto4//src//ProyectosConstruccion.db";
	// private static final String UBICACION_BD = "ProyectosConstruccion.db";
	
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:sqlite:" + UBICACION_BD;
		return DriverManager.getConnection(url);
	}
}
