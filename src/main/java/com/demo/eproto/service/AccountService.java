package com.demo.eproto.service;

import com.demo.eproto.exception.AccountNotFoundException;
import com.demo.eproto.model.Account;
import com.demo.eproto.model.AccountDTO;
import com.demo.eproto.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public Account getAccount(Long id) {
        return repository.findById(id).orElseThrow(AccountNotFoundException::new);
    }

    public void createAccount(Account account) {
        repository.save(account);
    }

    public boolean login(AccountDTO accountDTO) {
        Account existingAccount = repository.getAccountByLogin(accountDTO.getLogin()).orElseThrow(AccountNotFoundException::new);
        return existingAccount.getPassword().equals(accountDTO.getPassword());
    }

    public boolean isTeacher (String login) {
        return repository.getAccountByLogin(login)
                .map(Account::isTeacher)
                .orElseThrow(AccountNotFoundException::new);
    }

}
