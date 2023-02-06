package com.learning.springsecurityproject.controller;

import com.learning.springsecurityproject.model.Loans;
import com.learning.springsecurityproject.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @GetMapping("/myLoans")
    @PostAuthorize("hasRole('ROOT')")
    public List<Loans> getLoanDetails(@RequestParam int id) {
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }
}
