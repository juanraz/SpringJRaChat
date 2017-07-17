package com.dh.demo.service;

import com.dh.demo.domain.DestinationMessage;
import com.dh.demo.domain.Message;
import com.dh.demo.domain.Status;
import com.dh.demo.domain.User;
import com.dh.demo.jraexception.UserAlreadyExists;
import com.dh.demo.repository.MessageRepository;
import com.dh.demo.repository.UserRepository;
import com.dh.demo.web.MessageController;
import com.dh.demo.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Juan Zapata on 6/17/2017.
 */
@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserService userService;
    @Autowired
    DestinationMessageService destinationMessageService;


//    @Transactional
    public DestinationMessage createMessage(String from,String to,String message){
        Message m = new Message();
        DestinationMessage dm = new DestinationMessage();

        m.setContent(message);
        m.setUser(userService.getByID(from));
        m.setCreationDate(new Date());

        createMessage(m);

        Status s = null;

        m.setStatus(s);

        dm.setUser(userService.getByID(from));
        dm.setOtherUser(userService.getByID(to));

        dm.setMessage(m);

        destinationMessageService.createDestinaionMessage(dm);

        dm = new DestinationMessage();

        dm.setUser(userService.getByID(to));
        dm.setOtherUser(userService.getByID(from));

        dm.setMessage(m);

        destinationMessageService.createDestinaionMessage(dm);

        return dm;
    }

    public void createMessage(Message message){
        messageRepository.save(message);
    }



}
