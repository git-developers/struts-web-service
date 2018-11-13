package pe.com.petroperu.cosude.entity;

import java.util.List;

public class ReporteDetalladoImpExp {

	private String producto;
	
	private List<ReporteCabeceraImpExp> lstCabecera;

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public List<ReporteCabeceraImpExp> getLstCabecera() {
		return lstCabecera;
	}

	public void setLstCabecera(List<ReporteCabeceraImpExp> lstCabecera) {
		this.lstCabecera = lstCabecera;
	}
}
