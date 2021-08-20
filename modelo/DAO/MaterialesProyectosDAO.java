package modelo.DAO;

import java.util.ArrayList;
import modelo.VO.MaterialesProyectosVO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCutilities;

public class MaterialesProyectosDAO {

	public ArrayList<MaterialesProyectosVO> totalesMaterialesProyectos() throws SQLException {

		ArrayList<MaterialesProyectosVO> respuesta = new ArrayList<MaterialesProyectosVO>();

		Connection connection = JDBCutilities.getConnection();
		Statement st = connection.createStatement();

		String query = "SELECT mc.Nombre_Material, mc.Precio_Unidad, SUM(c.Cantidad) as Total "
				+ "FROM MaterialConstruccion mc "
				+ "INNER JOIN Compra c ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion "
				+ "INNER JOIN Proyecto p On p.ID_Proyecto = c.ID_Proyecto "
				+ "WHERE p.ID_Proyecto in (157,386,172,264,306) " + "GROUP BY mc.Nombre_Material "
				+ "ORDER BY mc.Nombre_Material ";

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			String nombreMaterial = rs.getString("Nombre_Material");
			Integer precioUnidad = rs.getInt("Precio_Unidad");
			Integer total = rs.getInt("Total");
			
			MaterialesProyectosVO registo = new MaterialesProyectosVO(nombreMaterial, precioUnidad, total);
			
			respuesta.add(registo);
		}

		return respuesta;
	}

}
