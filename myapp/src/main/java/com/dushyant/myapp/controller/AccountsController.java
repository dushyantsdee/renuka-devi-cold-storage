package com.dushyant.myapp.controller;

import com.dushyant.myapp.repository.StorageEntryRepository;
import com.dushyant.myapp.repository.PaymentRepository;
import com.dushyant.myapp.model.StorageEntry;
import com.dushyant.myapp.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    @Autowired
    private StorageEntryRepository storageEntryRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/summary")
    public Map<String, Object> getSummary() {
        List<StorageEntry> allEntries = storageEntryRepository.findAll();
        List<Payment> allPayments = paymentRepository.findAll();

        double totalIncome = 0;
        for (StorageEntry entry : allEntries) {
            if ("OUT".equals(entry.getStatus())) {
                totalIncome += entry.getBags() * entry.getRatePerBag();
            }
        }

        double totalExpense = 0;
        for (Payment payment : allPayments) {
            totalExpense += payment.getAmount();
        }

        double netProfit = totalIncome - totalExpense;

        Map<String, Object> summary = new HashMap<>();
        summary.put("totalIncome", totalIncome);
        summary.put("totalExpense", totalExpense);
        summary.put("netProfit", netProfit);

        return summary;
    }
}