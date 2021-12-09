package service.impl;

import model.AccountDTO;
import repository.AccountRepository;
import repository.impl.AccountRepositoryImpl;
import service.AccountService;


public class AccountServiceImpl implements AccountService{
    
    private final AccountRepository accountRepository = new AccountRepositoryImpl();

    @Override
    public AccountDTO getByUserNameAndPassWord(String userName, String password) {
        return accountRepository.getByUserNameAndPassWord(userName, password);
    }
    
    
}
