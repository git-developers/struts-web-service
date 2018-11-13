package pe.com.petroperu.cosude.entity;

import java.io.Serializable;

public class Cosude implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nroAcuerdoCosude;

	private Integer anio;

	private String descripcion;

	private String estado;

	private String fecha;

	private Integer numero;
	
	private String numeroStr;

	private Acuerdo acuerdo;

	public String getNumeroStr() {
		return numeroStr;
	}

	public void setNumeroStr(String numeroStr) {
		this.numeroStr = numeroStr;
	}

	public Acuerdo getAcuerdo() {
		return acuerdo;
	}

	public void setAcuerdo(Acuerdo acuerdo) {
		this.acuerdo = acuerdo;
	}

	public String getNroAcuerdoCosude() {
		return nroAcuerdoCosude;
	}

	public void setNroAcuerdoCosude(String nroAcuerdoCosude) {
		this.nroAcuerdoCosude = nroAcuerdoCosude;
	}

	public Cosude() {
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}