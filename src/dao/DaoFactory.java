package dao;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @author Barry
 * The Factory responsible for creating proper dao 
 *
 */
public class DaoFactory {

	private static DaoFactory df;
	private PersonDao pDao = null;
	static Log log = LogFactory.getLog(DaoFactory.class);

	private DaoFactory(){
	}
	
	public static DaoFactory getInstance(){
		if (df == null)
			df = new DaoFactory();
		return df;
	}
	
	public PersonDao getProductDao(){
		if (pDao == null){
			Properties properties = new Properties() ;
			try{
				properties.load(this.getClass().getResourceAsStream("/simplespring.properties"));
				String className = properties.getProperty("dao.PersonDaoName");
				if (className!=null){
					pDao = (PersonDao)Class.forName(className).newInstance();
					log.info("Using " + className + " to get Person Info...");
				}else{
					log.info("property not found, using default implementation");
					System.out.println("property not found, using default implementation");
					pDao = new PersonDaoMemImpl();
				}
			}catch (Exception e){ 
				log.info(e.getMessage());
				e.printStackTrace();
				pDao =  new PersonDaoMemImpl();
				System.out.println("Exception, using default implementation");
				return pDao;
			}
		}
		return pDao;
	}	
	
}

