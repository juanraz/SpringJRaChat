package com.dh.demo.repository;

import com.dh.demo.domain.DestinationMessage;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Juan Zapata on 6/17/2017.
 */
public interface DestinationMessageRepository extends MongoRepository<DestinationMessage,String> {
    @Query("{'user':{'$ref':'user','$id':?0},'otherUser':{'$ref':'user','$id':?1}}")
    List<DestinationMessage> findByConversation(String userId,String otherUserId);
}
