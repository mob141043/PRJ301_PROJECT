package repository.impl;

import hibernate.ConnectionUtil;
import java.math.BigInteger;
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
            queryBuilder.append("SELECT A.ACCOUNT_NO,A.USER_NAME,T.TEACHER_NO FROM ACCOUNT A ");
            queryBuilder.append("JOIN TEACHER T ON T.TEACHER_NO = A.TEACHER_NO ");
            queryBuilder.append("WHERE A.USER_NAME = :username AND A.PASSWORD = :password");
            Query query = session.createSQLQuery(queryBuilder.toString());
            query.setParameter("username", username);
            query.setParameter("password", password);
            List<Object[]> datas = query.list();
            if (CollectionUtils.isNotEmpty(datas)) {
                for (Object[] data : datas) {
                    accountDTO = new AccountDTO();
                    accountDTO.setAccountNo(((BigInteger) data[0]).longValue());
                    accountDTO.setUsername((String) data[1]);
                    accountDTO.setTeacherNo(((BigInteger) data[2]).longValue());
                }
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } finally {
            ConnectionUtil.finish(session);
        }
        return accountDTO;
    }
}
