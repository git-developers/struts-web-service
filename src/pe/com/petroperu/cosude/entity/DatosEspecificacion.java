package pe.com.petroperu.cosude.entity;

import java.util.List;

public class DatosEspecificacion {
	
	private String codigoRespuesta;
	
	private String mensajeRespuesta;
	
	private List<Especificacion> lstEspecificaciones;

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public List<Especificacion> getLstEspecificaciones() {
		return lstEspecificaciones;
	}

	public void setLstEspecificaciones(List<Especificacion> lstEspecificaciones) {
		this.lstEspecificaciones = lstEspecificaciones;
	}

}
