package repository.impl;

import entity.Account;
import hibernate.ConnectionUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AccountDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Query;
import repository.AccountRepository;

public class AccountRepositoryImpl extends BaseRepository implements AccountRepository {
    
    private static final Logger LOGGER = Logger.getLogger(AccountRepositoryImpl.class.getName());
    
    @Override
    public AccountDTO getByUserNameAndPassWord(String username, String password) {
        AccountDTO accountDTO = null;
        try {
            session = sessionFactory.openSession();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT a FROM Account a ");
            queryBuilder.append("WHERE a.username = :username AND a.password = :password");
            Query query = session.createQuery(queryBuilder.toString());
            query.setParameter("username", username);
            query.setParameter("password", password);
            List<Account> accounts = query.list();
            if (CollectionUtils.isNotEmpty(accounts)) {
                Account account = accounts.get(0);
                accountDTO = new AccountDTO();
                accountDTO.setUsername(account.getUsername());
                accountDTO.setPassword(account.getPassword());
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } finally {
            ConnectionUtil.finish(session);
        }
        return accountDTO;
    }
}
