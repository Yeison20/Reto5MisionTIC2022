package modelo.VO;

public class LideresCostosPromVO {
	
	private String nombre;
	private Integer promedio;
	
	
	public LideresCostosPromVO(){
		
	}
	
	public LideresCostosPromVO(String nombre, Integer promedio){
		this.nombre = nombre;
		this.promedio = promedio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPromedio() {
		return promedio;
	}

	public void setPromedio(Integer promedio) {
		this.promedio = promedio;
	}
	
	

}
