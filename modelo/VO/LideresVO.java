package modelo.VO;

public class LideresVO {

	private String nombre;
	private String cargo;
	
	
	public LideresVO(){
		
	}
	
	public LideresVO(String nombre, String cargo){
		this.nombre = nombre;
		this.cargo = cargo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
