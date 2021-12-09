package service;

import model.AccountDTO;

public interface AccountService {
    
    public AccountDTO getByUserNameAndPassWord(String userName, String password);
}
