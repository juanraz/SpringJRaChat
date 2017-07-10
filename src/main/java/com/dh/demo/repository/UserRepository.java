package com.dh.demo.repository;

import com.dh.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Juan Zapata on 6/17/2017.
 */
public interface UserRepository extends MongoRepository<User,String> {
}