package repository;

import model.AccountDTO;

public interface AccountRepository {

    public AccountDTO getByUserNameAndPassWord(String userName, String password);
}
