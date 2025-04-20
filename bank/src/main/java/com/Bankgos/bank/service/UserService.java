package com.Bankgos.bank.service;

import com.Bankgos.bank.model.User;

public interface UserService {


    public  User login(String username, String password);

   public User register(User user);

   public double getBalance(Long userId);
}
