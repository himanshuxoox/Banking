package com.Bankgos.bank.controller;


import com.Bankgos.bank.model.Payee;
import com.Bankgos.bank.service.PayeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payess")
@CrossOrigin("*")
public class PayeeController {

    @Autowired
    private PayeeService payeeService;

    @PostMapping("/{userId}/add")
    public ResponseEntity<?>addPayee(@PathVariable Long userId,@RequestBody Payee payee)
    {
        try{
            Payee save = payeeService.addPayee(userId, payee);
            return ResponseEntity.ok(save);
        }
        catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


}
