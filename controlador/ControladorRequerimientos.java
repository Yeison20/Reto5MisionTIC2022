package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.DAO.LideresCostosPromDAO;
import modelo.DAO.LideresDAO;
import modelo.DAO.MaterialesProyectosDAO;
import modelo.VO.LideresCostosPromVO;
import modelo.VO.LideresVO;
import modelo.VO.MaterialesProyectosVO;

public class ControladorRequerimientos {
	
	private final MaterialesProyectosDAO materialesProyectosDAO;
	private final LideresCostosPromDAO lideresCostosPromDAO;
	private final LideresDAO lideresDAO;
	
	public ControladorRequerimientos(){
		materialesProyectosDAO = new MaterialesProyectosDAO();
		lideresCostosPromDAO = new LideresCostosPromDAO();
		lideresDAO = new LideresDAO();
	}
	
	public ArrayList<MaterialesProyectosVO> consultarMaterialesProyectos() throws SQLException{
		return materialesProyectosDAO.totalesMaterialesProyectos(); 
	}

	
	public ArrayList<LideresCostosPromVO> consultarPromedioCostos() throws SQLException{
		return lideresCostosPromDAO.promedioCostos();
	}
	
	public ArrayList<LideresVO> consultarLideresCargo() throws SQLException{
		return lideresDAO.lideresCargo();
	}
}
