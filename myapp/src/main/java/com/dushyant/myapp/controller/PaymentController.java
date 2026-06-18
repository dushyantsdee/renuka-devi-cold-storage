package com.dushyant.myapp.controller;

import com.dushyant.myapp.model.Payment;
import com.dushyant.myapp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/staff/{staffId}")
    public List<Payment> getPaymentsByStaff(@PathVariable String staffId) {
        return paymentRepository.findByStaffId(staffId);
    }

    @PostMapping
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable String id) {
        paymentRepository.deleteById(id);
        return "Payment deleted successfully";
    }
}