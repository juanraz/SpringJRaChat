package com.dh.demo.repository;

import com.dh.demo.domain.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Juan Zapata on 6/18/2017.
 */
public interface SellerRepository extends MongoRepository<Seller,String> {
}
