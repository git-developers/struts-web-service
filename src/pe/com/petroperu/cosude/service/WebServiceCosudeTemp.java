package pe.com.petroperu.cosude.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import pe.com.petroperu.cosude.entity.ReporteDetalladoImpExp;

@WebService()
public class WebServiceCosudeTemp {
	
	@WebMethod()
	public @WebResult(name="reporteDetalladoImpExp") ReporteDetalladoImpExp obtenerReporteDetallado() throws Exception{
		
		
		return new ReporteDetalladoImpExp();
	}

}
