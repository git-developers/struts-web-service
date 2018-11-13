package pe.com.petroperu.cosude.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Especificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String estado;

	private String codProducto;

	private String metodo;

	private String nombre;

	private String nota;

	private BigDecimal typical;

	private BigDecimal valMax;

	private BigDecimal valMin;
	
	private String partidaAra;
	
	private String esReporte;

	public String getEsReporte() {
		return esReporte;
	}

	public void setEsReporte(String esReporte) {
		this.esReporte = esReporte;
	}

	public Especificacion() {
	}

	public String getPartidaAra() {
		return partidaAra;
	}



	public void setPartidaAra(String partidaAra) {
		this.partidaAra = partidaAra;
	}



	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getMetodo() {
		return this.metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public BigDecimal getTypical() {
		return this.typical;
	}

	public void setTypical(BigDecimal typical) {
		this.typical = typical;
	}

	public BigDecimal getValMax() {
		return this.valMax;
	}

	public void setValMax(BigDecimal valMax) {
		this.valMax = valMax;
	}

	public BigDecimal getValMin() {
		return this.valMin;
	}

	public void setValMin(BigDecimal valMin) {
		this.valMin = valMin;
	}

}