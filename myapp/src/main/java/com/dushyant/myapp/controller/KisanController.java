package com.dushyant.myapp.controller;

import com.dushyant.myapp.model.Kisan;
import com.dushyant.myapp.repository.KisanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kisan")
public class KisanController {

    @Autowired
    private KisanRepository kisanRepository;

    @GetMapping
    public List<Kisan> getAllKisan() {
        return kisanRepository.findAll();
    }

    @PostMapping
    public Kisan addKisan(@RequestBody Kisan kisan) {
        return kisanRepository.save(kisan);
    }

    @DeleteMapping("/{id}")
    public String deleteKisan(@PathVariable String id) {
        kisanRepository.deleteById(id);
        return "Kisan deleted successfully";
    }
}