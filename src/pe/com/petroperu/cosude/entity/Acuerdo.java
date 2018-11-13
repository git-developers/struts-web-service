package pe.com.petroperu.cosude.entity;

import java.io.Serializable;
import java.math.BigDecimal;


public class Acuerdo implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal desMas;

	private BigDecimal desMenos;

	private Integer duracion;

	private String duracionUnidad;

	private String estado;

	private String fecRequerimiento;

	private String producto;

	private String unidad;

	private Integer numero;

	private Integer plazoAnio;

	private String plazoMes;

	private BigDecimal saldo;

	private String tender;

	private BigDecimal volumen;
	
	private String numeroStr;

	public String getNumeroStr() {
		return numeroStr;
	}

	public void setNumeroStr(String numeroStr) {
		this.numeroStr = numeroStr;
	}

	public Acuerdo() {
	}

	public BigDecimal getDesMas() {
		return this.desMas;
	}

	public void setDesMas(BigDecimal desMas) {
		this.desMas = desMas;
	}

	public BigDecimal getDesMenos() {
		return this.desMenos;
	}

	public void setDesMenos(BigDecimal desMenos) {
		this.desMenos = desMenos;
	}

	public Integer getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getDuracionUnidad() {
		return this.duracionUnidad;
	}

	public void setDuracionUnidad(String duracionUnidad) {
		this.duracionUnidad = duracionUnidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getPlazoAnio() {
		return this.plazoAnio;
	}

	public void setPlazoAnio(Integer plazoAnio) {
		this.plazoAnio = plazoAnio;
	}

	public String getPlazoMes() {
		return this.plazoMes;
	}

	public void setPlazoMes(String plazoMes) {
		this.plazoMes = plazoMes;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTender() {
		return this.tender;
	}

	public void setTender(String tender) {
		this.tender = tender;
	}

	public BigDecimal getVolumen() {
		return this.volumen;
	}

	public void setVolumen(BigDecimal volumen) {
		this.volumen = volumen;
	}

	public String getFecRequerimiento() {
		return fecRequerimiento;
	}

	public void setFecRequerimiento(String fecRequerimiento) {
		this.fecRequerimiento = fecRequerimiento;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

}