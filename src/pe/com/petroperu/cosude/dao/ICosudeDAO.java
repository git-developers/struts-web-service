package pe.com.petroperu.cosude.dao;

import pe.com.petroperu.cosude.entity.DatosCosude;
import pe.com.petroperu.cosude.entity.DatosEspecificacion;

public interface ICosudeDAO {
	
	public DatosCosude obtenerDatosCosude(String nroAcuerdosCosude) throws Exception;
	
	public DatosEspecificacion obtenerEspecificacionProducto(String codProductos) throws Exception;

}
