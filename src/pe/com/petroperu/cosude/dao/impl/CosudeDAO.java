package pe.com.petroperu.cosude.dao.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.validator.internal.engine.messageinterpolation.parser.EscapedState;

import pe.com.petroperu.cosude.dao.ICosudeDAO;
import pe.com.petroperu.cosude.entity.Acuerdo;
import pe.com.petroperu.cosude.entity.Cosude;
import pe.com.petroperu.cosude.entity.DatosCosude;
import pe.com.petroperu.cosude.entity.DatosEspecificacion;
import pe.com.petroperu.cosude.entity.Especificacion;
import pe.com.petroperu.cosude.jpa.core.EntityManagerProvider;
import pe.com.petroperu.cosude.resource.Base;
import pe.com.petroperu.cosude.util.Constantes;
import pe.com.petroperu.cosude.util.Utilidades;

public class CosudeDAO extends Base implements ICosudeDAO{
	
	private static final Logger LOGGER = Logger.getLogger(CosudeDAO.class);

	@SuppressWarnings("unchecked")
	@Override
	public DatosCosude obtenerDatosCosude(String nroAcuerdosCosude) throws Exception{
		
		LOGGER.info("[inicio] obtenerDatosCosude");
		
		Integer nroCosude;
		Integer anio;
		Integer nroAcuerdo;
		
		List<Object[]> results;
		Cosude cosude;
		Acuerdo acuerdo;
		DatosCosude datosCosude;
		StringBuilder strQry = new StringBuilder();
		
		strQry.append("select * from cosude.cosude_obtener_data( '" + nroAcuerdosCosude + "' )");
		
		try{
			
			EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
			
			Query query = em.createNativeQuery(strQry.toString());
			
			results = (List<Object[]>) query.getResultList();
			
			if(results.isEmpty()){
				LOGGER.error("[error] obtenerDatosCosude: No existe data para los datos enviados");
				throw new Exception("No existe data para los datos enviados");
			}
			
			datosCosude = new DatosCosude();
			datosCosude.setLstCosude(new ArrayList<Cosude>());
			
			for(Object[] obj : results){
				cosude = new Cosude();
				
				anio = (Integer) obj[0];
				cosude.setAnio(anio);
				cosude.setDescripcion((String) obj[1]);
				
				Character estadoCosude = (Character) obj[2];
				cosude.setEstado(estadoCosude.toString());
				
				Timestamp fecha = (Timestamp) obj[3];
				
				Date date = new Date();
				date.setTime(fecha.getTime());
				
				cosude.setFecha(new SimpleDateFormat("dd/MM/yyyy").format(date));
				
				nroCosude = (Integer) obj[4];
				cosude.setNumero(nroCosude);
				
				acuerdo = new Acuerdo();
				acuerdo.setDesMas((BigDecimal) obj[5]);
				acuerdo.setDesMenos((BigDecimal) obj[6]);
				acuerdo.setDuracion((Integer) obj[7]);
				
				Character duracionUnidad = (Character) obj[8];
				acuerdo.setDuracionUnidad(duracionUnidad.toString());
				
				Character estadoAcuerdo = (Character) obj[9];
				acuerdo.setEstado(estadoAcuerdo.toString());
				
				Date fecReq = (Date) obj[10];
				
				if(fecReq != null){
					acuerdo.setFecRequerimiento(new SimpleDateFormat("dd/MM/yyyy").format(fecReq));
				}
				
				acuerdo.setProducto((String) obj[11]);
				
				nroAcuerdo = (Integer) obj[12];
				acuerdo.setNumero(nroAcuerdo);
				acuerdo.setNumeroStr(Utilidades.cerosIzquierda(nroAcuerdo, Constantes.CEROS_IZQUIERDA_ACUERDO));
				
				acuerdo.setPlazoAnio((Integer) obj[13]);
				
				acuerdo.setPlazoMes((String) obj[14]);
				
				acuerdo.setSaldo((BigDecimal) obj[15]);
				
				Character tender = (Character) obj[16];
				acuerdo.setTender(tender.toString());
				
				acuerdo.setVolumen((BigDecimal) obj[17]);
				
				cosude.setAcuerdo(acuerdo);
				
				cosude.setNumeroStr(Utilidades.cerosIzquierda(nroCosude, Constantes.CEROS_IZQUIERDA_COSUDE) + "-" + anio);
				cosude.setNroAcuerdoCosude(Utilidades.obtenerNroAcuerdoCosude(nroCosude, anio, nroAcuerdo));
				
				datosCosude.getLstCosude().add(cosude);	
				
			}
			
		}catch(NoResultException nre){
			LOGGER.error("[error] obtenerDatosCosude: " + nre.getMessage());
			throw new Exception("No existe data para los datos enviados");
		}catch(Exception ex){
			LOGGER.error("[error] obtenerDatosCosude: " + ex.getMessage());
			throw new Exception(ex.getMessage());
		}
		
		LOGGER.info("[fin] obtenerDatosCosude");
		return datosCosude;
	}

	@Override
	public DatosEspecificacion obtenerEspecificacionProducto(String codProductos) throws Exception {
		LOGGER.info("[inicio] obtenerEspecificacionProducto");
		
		List<Object[]> results;
		Especificacion especificacion;
		DatosEspecificacion datosEspecificacion;
		
		StringBuilder strQry = new StringBuilder();
		
		strQry.append("select * from cosude.cosude_obtener_especificaciones_prod( '" + codProductos + "' )");
		
		try{
			
			EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
			
			Query query = em.createNativeQuery(strQry.toString());
			
			results = (List<Object[]>) query.getResultList();
			
			if(results.isEmpty()){
				LOGGER.error("[error] obtenerEspecificacionProducto: No existe data para los datos enviados");
				throw new Exception("No existe data para los datos enviados");
			}
			
			datosEspecificacion = new DatosEspecificacion();
			datosEspecificacion.setLstEspecificaciones(new ArrayList<Especificacion>());
			
			for(Object[] obj : results){
				especificacion = new Especificacion();
				
				Character estado = (Character) obj[0];
				especificacion.setEstado(estado.toString());
				
				especificacion.setCodProducto((String) obj[1]);
				
				especificacion.setNombre((String) obj[2]);
				
				especificacion.setNota((String) obj[3]);
				
				especificacion.setTypical((BigDecimal) obj[4]);
				
				especificacion.setValMax((BigDecimal) obj[5]);
				
				especificacion.setValMin((BigDecimal) obj[6]);
				
				especificacion.setMetodo((String) obj[7]);
				
				especificacion.setPartidaAra((String) obj[8]);
				
				Boolean esReporte = (Boolean) obj[9];
				
				if(esReporte){
					especificacion.setEsReporte("0");
				}else{
					especificacion.setEsReporte("1");
				}
				
				datosEspecificacion.getLstEspecificaciones().add(especificacion);
			}
			
		}catch(Exception ex){
			LOGGER.error("[error] obtenerEspecificacionProducto: " + ex.getMessage());
			throw new Exception(ex.getMessage());
		}
		
		LOGGER.info("[fin] obtenerEspecificacionProducto");
		return datosEspecificacion;
	}

}
