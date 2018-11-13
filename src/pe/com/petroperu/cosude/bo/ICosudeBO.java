package pe.com.petroperu.cosude.bo;

import java.util.List;

import pe.com.petroperu.cosude.entity.DatosCosude;
import pe.com.petroperu.cosude.entity.DatosEspecificacion;

public interface ICosudeBO {
	
	public DatosCosude obtenerDatosCosude(List<String> lstNroAcuerdosCosude) throws Exception;
	
	public DatosEspecificacion obtenerEspecificacionProducto(List<String> lstCodProductos) throws Exception;

}
