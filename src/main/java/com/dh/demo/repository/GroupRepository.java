package com.dh.demo.repository;

import com.dh.demo.domain.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Juan Zapata on 6/17/2017.
 */
public interface GroupRepository extends MongoRepository<Group,String> {
}
