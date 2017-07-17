package com.dh.demo.repository;

import com.dh.demo.domain.Message;
import com.dh.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Zapata on 6/17/2017.
 */
public interface MessageRepository extends MongoRepository<Message,String> {
    //@Query("{'userName':?0},{'chatWith':?1}")
    @Query("{'user':{'$ref':'user','$id':?0}}")
    User getConversation(String userName,String chatWith);

    @Query(value = "{'user':{'$ref':'user','$id':?0}}" )
    ArrayList<Message> getMessageIDsByUser(String userId);
}
