package com.dh.demo.repository;

import com.dh.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Juan Zapata on 6/17/2017.
 */
public interface UserRepository extends MongoRepository<User,String> {
    @Query("{'userName':?0,'Status':{$ne:'removed'}}")
    User findByUserName(String userName);
    @Query("{'id':{$ne:?0},'Status':{$ne:'removed'}}")
    List<User> findAllBut(String id);

}
