package com.dh.demo.service;

import com.dh.demo.domain.DestinationMessage;
import com.dh.demo.domain.User;
import com.dh.demo.repository.DestinationMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Zapata on 6/17/2017.
 */
@Service
public class DestinationMessageService {

    @Autowired
    DestinationMessageRepository destinationMessageRepository;

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    public List<DestinationMessage> getAll(){
        return destinationMessageRepository.findAll();
    }

    public DestinationMessage getByID(String id){
        return destinationMessageRepository.findOne(id);
    }


    public List<DestinationMessage> getByConversation(String currentUser, String currentConversation){
        return destinationMessageRepository.findByConversation(currentUser,currentConversation);
    }


    public void createDestinaionMessage(DestinationMessage destinationMessage){
        destinationMessageRepository.save(destinationMessage);
    }


}
