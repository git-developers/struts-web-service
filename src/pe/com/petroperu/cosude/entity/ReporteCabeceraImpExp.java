package pe.com.petroperu.cosude.entity;

import java.math.BigDecimal;
import java.util.List;

public class ReporteCabeceraImpExp {
	
	private String reunion;
	private String acuerdo;
	
	private List<ReporteDetalleImpExp> lstDetalleImpExp;

	public String getReunion() {
		return reunion;
	}

	public void setReunion(String reunion) {
		this.reunion = reunion;
	}

	public String getAcuerdo() {
		return acuerdo;
	}

	public void setAcuerdo(String acuerdo) {
		this.acuerdo = acuerdo;
	}

	public List<ReporteDetalleImpExp> getLstDetalleImpExp() {
		return lstDetalleImpExp;
	}

	public void setLstDetalleImpExp(List<ReporteDetalleImpExp> lstDetalleImpExp) {
		this.lstDetalleImpExp = lstDetalleImpExp;
	}

}
