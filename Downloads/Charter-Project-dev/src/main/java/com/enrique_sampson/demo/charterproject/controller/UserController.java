package com.enrique_sampson.demo.charterproject.controller;

import com.enrique_sampson.demo.charterproject.model.Transaction;
import com.enrique_sampson.demo.charterproject.model.User;
import com.enrique_sampson.demo.charterproject.repository.TransactionRepository;
import com.enrique_sampson.demo.charterproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @GetMapping
    Iterable<User> list() {
        return userRepository.findAll();
    }



    private static int index=2;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestParam final String name,@RequestParam double transaction) {
        User createdUser = new User();

        Transaction createdTransaction = new Transaction();
        createdTransaction.setTotal(transaction);
        createdTransaction.setUser(createdUser);
        createdTransaction.setId(index++);
        Set<Transaction> transactions = new HashSet<>();
        transactions.add(createdTransaction);

        createdUser.setTransactions(transactions);
        createdUser.setName(name);
        userRepository.save(createdUser);
        transactionRepository.save(createdTransaction);
        return ;

    }


}
