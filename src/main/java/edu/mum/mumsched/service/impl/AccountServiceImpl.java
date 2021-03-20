package edu.mum.mumsched.service.impl;

import edu.mum.mumsched.dao.AccountDao;
import edu.mum.mumsched.domain.Account;
import edu.mum.mumsched.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public Account getAccountById(long id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountDao.findAll();
    }

    @Override
    public Account getAccountByEmail(String email) {
        return accountDao.findAccountByEmail(email);
    }

    @Override
    public void deleteAccountById(Long id) {
               accountDao.deleteById(id);
    }

    @Override
    public void deleteAccountByEmail(String email) {
             accountDao.deleteAccountByEmail(email);
    }
}
