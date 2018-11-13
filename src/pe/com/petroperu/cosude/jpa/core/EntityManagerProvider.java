package pe.com.petroperu.cosude.jpa.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;


public class EntityManagerProvider {
	private static final Logger LOGGER = Logger.getLogger(EntityManagerProvider.class);
	
	private static EntityManagerProvider i = null;
	
	private EntityManagerFactory entityManagerFactory=null;
	
	private EntityManagerProvider() {
		i = this;
		LOGGER.debug("emf: ini");
		entityManagerFactory = Persistence.createEntityManagerFactory("COSUDEDS");
		LOGGER.info("emf: creado " + entityManagerFactory);
	}
	public static EntityManagerProvider getInstance(){
		return i==null?new EntityManagerProvider():i;
	}
	
	public EntityManager getEntityManager(){
		EntityManager entityManager = null;
		LOGGER.debug( "em:ini ");
		entityManager =entityManagerFactory.createEntityManager();
		LOGGER.info("em:creado ");
		return entityManager;
	}
	
	public void cerrarEMF() {
		if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
			entityManagerFactory.close();
		}
	}
	
	@Deprecated
	public EntityManager getEntityManager(boolean recreate){
		EntityManager entityManager = null;
		if(entityManager==null ){
			LOGGER.debug( "em:ini ");
			entityManager =entityManagerFactory.createEntityManager();
			LOGGER.info("em:creado " +entityManager);
		}
		if(recreate){
			LOGGER.info("Recreando....");
			if(entityManager.isOpen()){
				LOGGER.info("Cerrando");
				entityManager.close();
			}
			entityManager =entityManagerFactory.createEntityManager();
			LOGGER.info("Recreado");
		}
		return entityManager;
	}
	
}
