package com.Bankgos.bank.service;

import com.Bankgos.bank.model.Payee;

import java.util.List;

public interface PayeeService {
   public Payee addPayee(Long userId, Payee payee);


    public List<Payee> getPayees(Long userId);
}
