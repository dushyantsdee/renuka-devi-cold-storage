package com.dushyant.myapp.repository;

import com.dushyant.myapp.model.Kisan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KisanRepository extends MongoRepository<Kisan, String> {
}