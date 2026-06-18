package com.dushyant.myapp.controller;

import com.dushyant.myapp.model.Staff;
import com.dushyant.myapp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @PostMapping
    public Staff addStaff(@RequestBody Staff staff) {
        return staffRepository.save(staff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable String id, @RequestBody Staff updatedStaff) {
        Staff staff = staffRepository.findById(id).orElse(null);
        staff.setName(updatedStaff.getName());
        staff.setRole(updatedStaff.getRole());
        staff.setMonthlySalary(updatedStaff.getMonthlySalary());
        return staffRepository.save(staff);
    }

    @DeleteMapping("/{id}")
    public String deleteStaff(@PathVariable String id) {
        staffRepository.deleteById(id);
        return "Staff deleted successfully";
    }
}