package pe.com.petroperu.cosude.bo.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import pe.com.petroperu.cosude.bo.ICosudeBO;
import pe.com.petroperu.cosude.dao.ICosudeDAO;
import pe.com.petroperu.cosude.entity.DatosCosude;
import pe.com.petroperu.cosude.entity.DatosEspecificacion;
import pe.com.petroperu.cosude.resource.Base;
import pe.com.petroperu.cosude.resource.ServiceProvider;

public class CosudeBO extends Base implements ICosudeBO{
	
	private static final Logger LOGGER = Logger.getLogger(CosudeBO.class);

	@Override
	public DatosCosude obtenerDatosCosude(List<String> lstNroAcuerdosCosude) throws Exception{
		
		LOGGER.info("[inicio] obtenerDatosCosude");
		DatosCosude datosCosude;
		
		ICosudeDAO cosudeDAO = ServiceProvider.getInstance().obtenerCosudeDAO();
		
		String nroAcuerdosCosude = StringUtils.join(lstNroAcuerdosCosude, ',');
				
		datosCosude = cosudeDAO.obtenerDatosCosude(nroAcuerdosCosude);
		
		LOGGER.info("[fin] obtenerDatosCosude");
		return datosCosude;
	}

	@Override
	public DatosEspecificacion obtenerEspecificacionProducto(List<String> lstCodProductos) throws Exception {
		LOGGER.info("[inicio] obtenerEspecificacionProducto");
		DatosEspecificacion datosEspecificacion;
		
		ICosudeDAO cosudeDAO = ServiceProvider.getInstance().obtenerCosudeDAO();
		
		String codProductos = StringUtils.join(lstCodProductos, ',');
				
		datosEspecificacion = cosudeDAO.obtenerEspecificacionProducto(codProductos);
		
		LOGGER.info("[fin] obtenerEspecificacionProducto");
		return datosEspecificacion;
	}

}
