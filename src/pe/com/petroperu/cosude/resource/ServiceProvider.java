package pe.com.petroperu.cosude.resource;

import java.util.HashMap;

import pe.com.petroperu.cosude.bo.ICosudeBO;
import pe.com.petroperu.cosude.bo.impl.CosudeBO;
import pe.com.petroperu.cosude.dao.ICosudeDAO;
import pe.com.petroperu.cosude.dao.impl.CosudeDAO;

public class ServiceProvider {

	private HashMap<String, IBase> bos= new HashMap<String, IBase>(); 
	private static ServiceProvider i=null;
	
	private ServiceProvider() {
		i =this;
	}
	
	public static ServiceProvider getInstance(){
		return i==null?new ServiceProvider():i;
	}
	
	public ICosudeBO obtenerCosudeBO(){
		String name = ICosudeBO.class.getSimpleName();
		if (!bos.containsKey(name)) {
			bos.put(ICosudeBO.class.getSimpleName(), new CosudeBO());
		}
		return (ICosudeBO) bos.get(name);
	}
	
	public ICosudeDAO obtenerCosudeDAO(){
		String name = ICosudeDAO.class.getSimpleName();
		if (!bos.containsKey(name)) {
			bos.put(ICosudeDAO.class.getSimpleName(), new CosudeDAO());
		}
		return (ICosudeDAO) bos.get(name);
	}
}
