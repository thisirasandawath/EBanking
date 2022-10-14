//package com.example.ebanking.account;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//@Transactional
//public class AccountService {
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//
//    public AccountDto getAccDetailsById(String accountNo) {
//        Account account=accountRepository.getAccDetailsById(accountNo);
//        return modelMapper.map(account, AccountDto.class);
//    }
//
//    public AccountDto saveAccount(AccountDto accountDto) {
//
//        accountRepository.save(modelMapper.map(accountDto, Account.class));
//        return accountDto;
//    }
//}
