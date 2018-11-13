package pe.com.petroperu.cosude.entity;

import java.util.List;

public class DatosCosude {
	
	private String codigoRespuesta;
	
	private String mensajeRespuesta;
	
	private List<Cosude> lstCosude;

	public List<Cosude> getLstCosude() {
		return lstCosude;
	}

	public void setLstCosude(List<Cosude> lstCosude) {
		this.lstCosude = lstCosude;
	}

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


}
