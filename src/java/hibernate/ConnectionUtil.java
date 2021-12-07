package hibernate;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {
  private static SessionFactory factory = null;

  private ConnectionUtil() {

  }

  /**
   * use Configuration to create a SessionFactory.
   * 
   * @return a SessionFactory
   */
  public static SessionFactory getSessionFactory() {
    if (factory == null) {
      Configuration config = new Configuration();
      config.configure("hibernate\\hibernate.cfg.xml");
      
      factory = config.buildSessionFactory();
    }
    return factory;
  }
  
    public static void main(String[] args) {
        getSessionFactory();
    }

}
