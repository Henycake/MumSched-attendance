package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Account;
import edu.mum.mumsched.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AccountDao extends JpaRepository<Account,Long> {
    Account findAccountById(long id);

    Account findAccountByEmail(String email);

    void deleteAccountByEmail(String email);
}
