package com.pranav.graphql.repository;

import com.pranav.graphql.model.Bestseller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestsellerRepository extends MongoRepository<Bestseller, String> {
    //Optional<Bestseller> findByCategory(String category);
}