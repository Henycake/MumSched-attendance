package edu.mum.mumsched.service;

import edu.mum.mumsched.domain.Account;
import edu.mum.mumsched.domain.Block;

import java.time.LocalDate;
import java.util.List;

public interface AccountService {
    public void save(Account account);
    public Account getAccountById( long id);
    public List<Account> getAllAccount();
    public Account getAccountByEmail(String email);

    public void deleteAccountById(Long id);
    public void deleteAccountByEmail(String email);

}
