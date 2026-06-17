package com.dushyant.myapp.repository;

import com.dushyant.myapp.model.StorageEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageEntryRepository extends MongoRepository<StorageEntry, String> {
    List<StorageEntry> findByKisanId(String kisanId);
    List<StorageEntry> findByStatus(String status);
}