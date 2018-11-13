package pe.com.petroperu.cosude.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import org.apache.log4j.Logger;

import pe.com.petroperu.cosude.bo.ICosudeBO;
import pe.com.petroperu.cosude.entity.DatosCosude;
import pe.com.petroperu.cosude.entity.DatosEspecificacion;
import pe.com.petroperu.cosude.resource.ServiceProvider;
import pe.com.petroperu.cosude.util.Constantes;

@WebService()
public class WebServiceCosude {
	
	private static final Logger LOGGER = Logger.getLogger(WebServiceCosude.class);
	
	private String validarDatosAcuerdoCosude(String nroCosude, String anioCosude, String numAcuerdo) throws Exception{
		
		LOGGER.info("[inicio] validarDatosAcuerdoCosude");
		
		String mensajeError;
		
		String nroCosudeTemp;
		String nroAcuerdoTemp;
		
		try{
			nroCosudeTemp = Integer.parseInt(nroCosude) + "" ;
		}catch(NumberFormatException nfe){
			mensajeError = "El numero de reunión debe ser numérico y se envió " + nroCosude;
			LOGGER.error("[error] validarDatosAcuerdoCosude: " + mensajeError);
			throw new Exception(mensajeError);
		}
		
		try{
			Integer.parseInt(anioCosude);
		}catch(NumberFormatException nfe){
			mensajeError = "El año de reunión debe ser numérico y se envió " + anioCosude;
			LOGGER.error("[error] validarDatosAcuerdoCosude: " + mensajeError);
			throw new Exception(mensajeError);
		}
		
		try{
			nroAcuerdoTemp = Integer.parseInt(numAcuerdo) + "";
		}catch(NumberFormatException nfe){
			mensajeError = "El numero de acuerdo debe ser numérico y se envió " + numAcuerdo;
			LOGGER.error("[error] validarDatosAcuerdoCosude: " + mensajeError);
			throw new Exception(mensajeError);
		}
		
		LOGGER.info("[fin] validarDatosAcuerdoCosude");
		return nroCosudeTemp + "-" + anioCosude + "-" + nroAcuerdoTemp;	
	}
	
	@WebMethod()
	public  @WebResult(name="datosCosude") DatosCosude obtenerDatosCosude(	@XmlElement(required=true) @WebParam(name = "lstNroAcuerdosCosude") List<String> lstNroAcuerdosCosude ) throws Exception{
		
		LOGGER.info("[inicio] obtenerDatosCosude");
		
		String[] parseTemp;
		String nroAcuerdoCosudeReal;
		DatosCosude respuesta = new DatosCosude();
		List<String> lstNroAcuerdosCosudeNueva = new ArrayList<String>();
		
		try{
			
			for(String nroAcuerdoCosude : lstNroAcuerdosCosude){
				
				parseTemp = nroAcuerdoCosude.split("-");
				
				if(parseTemp.length != 3){
					throw new Exception("Se debe enviar el formato nroCosude-anioCosude-nroAcuerdo");
				}
				
				nroAcuerdoCosudeReal = validarDatosAcuerdoCosude(parseTemp[0], parseTemp[1], parseTemp[2]);
				lstNroAcuerdosCosudeNueva.add(nroAcuerdoCosudeReal);
				
			}
			
			ICosudeBO cosudeBO = ServiceProvider.getInstance().obtenerCosudeBO();
			respuesta = cosudeBO.obtenerDatosCosude(lstNroAcuerdosCosudeNueva);
			respuesta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_EXITO);
			
		}catch(Exception ex){
			respuesta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_ERROR);
			respuesta.setMensajeRespuesta(ex.getMessage());
			LOGGER.error("[error] obtenerDatosCosude: " + ex.getMessage());
		}
		LOGGER.info("[fin] obtenerDatosCosude");
		return respuesta;
	}
	
	@WebMethod()
	public @WebResult(name="especificacionesProd") DatosEspecificacion obtenerEspecificacionesProducto(@XmlElement(required=true) @WebParam(name = "lstCodProductos") List<String> lstCodProductos) throws Exception{
		LOGGER.info("[inicio] obtenerEspecificacionesProducto");
		DatosEspecificacion respuesta = new DatosEspecificacion();
		
		try{
			
			ICosudeBO cosudeBO = ServiceProvider.getInstance().obtenerCosudeBO();
			respuesta = cosudeBO.obtenerEspecificacionProducto(lstCodProductos);
			respuesta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_EXITO);
			
		}catch(Exception ex){
			respuesta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_ERROR);
			respuesta.setMensajeRespuesta(ex.getMessage());
			LOGGER.error("[error] obtenerEspecificacionesProducto: " + ex.getMessage());
		}
		
		LOGGER.info("[fin] obtenerEspecificacionesProducto");
		return respuesta;
	}

}
