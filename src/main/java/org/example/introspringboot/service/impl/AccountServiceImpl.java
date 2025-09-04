package org.example.introspringboot.service.impl;

import jakarta.transaction.Transactional;
import org.example.introspringboot.entity.Account;
import org.example.introspringboot.repository.AccountRepository;
import org.example.introspringboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public void transferMoney(Long from, Long to, Double amount) {
        Account accountFrom = accountRepository.findById(from).orElse(null);
        Account accountTo = accountRepository.findById(to).orElse(null);
        accountFrom.setBalance(accountFrom.getBalance() - amount);
        accountRepository.save(accountFrom);

        if (false) {
            throw new RuntimeException("Nequi lo ha hecho de nuevo!");
        }

        accountTo.setBalance(accountTo.getBalance() + amount);
        accountRepository.save(accountTo);

    }
}
