package modelo.DAO;


import java.util.ArrayList;

import modelo.VO.LideresCostosPromVO;
import modelo.VO.MaterialesProyectosVO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCutilities;


public class LideresCostosPromDAO {

	public ArrayList<LideresCostosPromVO> promedioCostos() throws SQLException{
		
		ArrayList<LideresCostosPromVO> respuesta = new ArrayList<LideresCostosPromVO>();
		
		Connection connection = JDBCutilities.getConnection();
		Statement st = connection.createStatement();
		
		String query = "SELECT Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido as Nombre, " +
						"SUM(c.Cantidad * mc.Precio_Unidad)/COUNT(DISTINCT p.ID_Proyecto) Promedio " +
						"FROM Lider l " +
						"LEFT JOIN Proyecto p ON p.ID_Lider = l.ID_Lider " +
						"LEFT JOIN Compra c ON c.ID_Proyecto = p.ID_Proyecto " +
						"LEFT JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion " +
						"WHERE p.Clasificacion = 'Apartaestudio' " +
						"GROUP BY l.ID_Lider " +
						"HAVING COUNT(DISTINCT p.ID_Proyecto) >= 2 " +
						"ORDER BY 2 " +
						"LIMIT 3 ";
		
		ResultSet rs = st.executeQuery(query);
		
		while( rs.next()){
			String nombre = rs.getString("Nombre");
			Integer promedio = rs.getInt("Promedio");
			
			LideresCostosPromVO registro = new LideresCostosPromVO(nombre, promedio);
				
			respuesta.add(registro);	
		}
		
		return respuesta;
						
	}
}
