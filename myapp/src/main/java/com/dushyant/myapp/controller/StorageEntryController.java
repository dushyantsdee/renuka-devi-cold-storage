package com.dushyant.myapp.controller;

import com.dushyant.myapp.model.StorageEntry;
import com.dushyant.myapp.repository.StorageEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storage")
public class StorageEntryController {

    @Autowired
    private StorageEntryRepository storageEntryRepository;

    @GetMapping
    public List<StorageEntry> getAllEntries() {
        return storageEntryRepository.findAll();
    }

    @GetMapping("/kisan/{kisanId}")
    public List<StorageEntry> getEntriesByKisan(@PathVariable String kisanId) {
        return storageEntryRepository.findByKisanId(kisanId);
    }

    @GetMapping("/status/{status}")
    public List<StorageEntry> getEntriesByStatus(@PathVariable String status) {
        return storageEntryRepository.findByStatus(status);
    }

    @PostMapping
    public StorageEntry addEntry(@RequestBody StorageEntry entry) {
        entry.setStatus("IN");
        return storageEntryRepository.save(entry);
    }

    @PutMapping("/{id}/checkout")
    public StorageEntry checkout(@PathVariable String id, @RequestBody StorageEntry updatedEntry) {
        StorageEntry entry = storageEntryRepository.findById(id).orElse(null);
        entry.setStatus("OUT");
        entry.setDateOut(updatedEntry.getDateOut());
        entry.setWithdrawalType(updatedEntry.getWithdrawalType());
        entry.setTraderName(updatedEntry.getTraderName());
        return storageEntryRepository.save(entry);
    }

    @DeleteMapping("/{id}")
    public String deleteEntry(@PathVariable String id) {
        storageEntryRepository.deleteById(id);
        return "Entry deleted successfully";
    }
}