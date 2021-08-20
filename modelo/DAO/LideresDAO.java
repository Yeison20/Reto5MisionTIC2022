package modelo.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.VO.LideresVO;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCutilities;

public class LideresDAO {

	public ArrayList<LideresVO> lideresCargo() throws SQLException {

		ArrayList<LideresVO> resultado = new ArrayList<LideresVO>();

		Connection connection = JDBCutilities.getConnection();
		Statement st = connection.createStatement();

		String query = "SELECT (nombre || ' ' || Primer_Apellido || ' ' || Segundo_Apellido) as Nombre, Cargo "
				+ "FROM Lider " + "WHERE Ciudad_Residencia = 'Bucaramanga' " + "ORDER by Nombre ";

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			String nombre = rs.getString("Nombre");
			String cargo = rs.getString("Cargo");
			
			LideresVO registro = new LideresVO(nombre, cargo);
			
			resultado.add(registro);
			
		}
		
		return resultado;

	}

}
