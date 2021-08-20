package modelo.VO;

public class MaterialesProyectosVO {

	private String nombreMaterial;
	private Integer precio;
	private Integer total;

	public MaterialesProyectosVO() {

	}

	public MaterialesProyectosVO(String nombreMaterial, Integer precio, Integer total) {
		this.nombreMaterial = nombreMaterial;
		this.precio = precio;
		this.total = total;
	}

	public String getNombreMaterial() {
		return nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
