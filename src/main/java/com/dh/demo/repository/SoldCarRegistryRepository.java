package com.dh.demo.repository;

import com.dh.demo.domain.SoldCarRegistry;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Juan Zapata on 6/20/2017.
 */
public interface SoldCarRegistryRepository extends MongoRepository<SoldCarRegistry,String> {
}
