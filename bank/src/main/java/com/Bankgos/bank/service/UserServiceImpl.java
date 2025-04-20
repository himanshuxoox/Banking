package com.Bankgos.bank.service;

import com.Bankgos.bank.model.User;
import com.Bankgos.bank.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        return userDao.findByUsername(username).filter(user -> user.getPassword().equals(password)).orElseThrow(()->
                new RuntimeException("Invalid username or password"));
    }

    @Override
    public User register(User user) {

        if(userDao.findByUsername(user.getUsername()).isPresent())
        {

            throw new RuntimeException("Username alread exists");
        }
        return userDao.save(user);
    }

    @Override
    public double getBalance(Long userId) {
       User user=userDao.findById(userId).orElseThrow(()->new RuntimeException("user not found for which you are tyring to fech balance"));


        return user.getBalance();
    }
}
