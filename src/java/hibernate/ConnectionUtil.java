package hibernate;

import model.AccountDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.AccountRepository;
import repository.impl.AccountRepositoryImpl;

public class ConnectionUtil {

    private static SessionFactory factory = null;

    private ConnectionUtil() {

    }

  
    public static SessionFactory buildSessionFactory() {
        if (factory == null) {
            Configuration config = new Configuration();
            config.configure("hibernate\\hibernate.cfg.xml");

            factory = config.buildSessionFactory();
        }
        return factory;
    }

    public static void finish(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public static void main(String[] args) {
        buildSessionFactory();
        AccountRepository accountRepository = new AccountRepositoryImpl();
        System.out.println(accountRepository.getByUserNameAndPassWord("son", "123"));
    }

}
