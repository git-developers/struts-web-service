package pe.com.petroperu.cosude.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ReporteDetalleImpExp {
	
	private Integer correlativo;
	private String proveedor;
	private String destino;
	private String bt;
	private BigDecimal volbls;
	private BigDecimal volmbls;
	private Date fechaCarga;
	private Date fechaRecepcion;
	public Integer getCorrelativo() {
		return correlativo;
	}
	public void setCorrelativo(Integer correlativo) {
		this.correlativo = correlativo;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public BigDecimal getVolbls() {
		return volbls;
	}
	public void setVolbls(BigDecimal volbls) {
		this.volbls = volbls;
	}
	public BigDecimal getVolmbls() {
		return volmbls;
	}
	public void setVolmbls(BigDecimal volmbls) {
		this.volmbls = volmbls;
	}
	public Date getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

}
