package com.Bankgos.bank.service;

import com.Bankgos.bank.model.Payee;
import com.Bankgos.bank.repository.PayeeDao;
import com.Bankgos.bank.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Bankgos.bank.model.User;

import java.util.List;

@Service
public class PayeeServiceImp implements PayeeService {

    @Autowired
    private PayeeDao payeeDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Payee addPayee(Long userId, Payee payee) {
        User user= userDao.findById(userId).orElseThrow(()-> new RuntimeException("user not found") );

        payee.setUser(user);
        return payeeDao.save(payee) ;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public List<Payee> getPayees(Long userId) {
        return payeeDao.findByUserId(userId);
    }
}
