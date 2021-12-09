package hibernate;

import model.AccountDTO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.AccountRepository;
import repository.impl.AccountRepositoryImpl;

public class ConnectionUtil {

    private static SessionFactory factory = null;

    private ConnectionUtil() {

    }

    /**
     * use Configuration to create a SessionFactory.
     *
     * @return a SessionFactory
     */
    public static SessionFactory buildSessionFactory() {
        if (factory == null) {
            Configuration config = new Configuration();
            config.configure("hibernate\\hibernate.cfg.xml");

            factory = config.buildSessionFactory();
        }
        return factory;
    }

    public static void main(String[] args) {
        buildSessionFactory();
        AccountRepository accountRepository = new AccountRepositoryImpl();
        System.out.println(accountRepository.getByUserNameAndPassWord("son", "123"));
    }

}
