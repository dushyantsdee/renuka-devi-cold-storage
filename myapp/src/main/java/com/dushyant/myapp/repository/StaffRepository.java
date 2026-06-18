package com.dushyant.myapp.repository;

import com.dushyant.myapp.model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {
}