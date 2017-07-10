package com.dh.demo.service;

import com.dh.demo.domain.User;
import com.dh.demo.jraexception.UserAlreadyExists;
import com.dh.demo.repository.UserRepository;
import com.dh.demo.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Zapata on 6/17/2017.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getByID(String id){
        return userRepository.findOne(id);
    }

    public List<User> getAll(){
        return (List<User>)userRepository.findAll();
    }

    public List<User> getAllBut(String user){
        List<User> li = (List<User>)userRepository.findAll();
        for(User u : li){
            if(u.getUserName().equals(user)){
                li.remove(u);
            }
        }
        return li;
    }

    public void addUser(UserController.UserRequestDTO userDTO) throws UserAlreadyExists {

        User user;
        user = this.getByID(userDTO.getUserName());
       if(null!=user){
           throw new UserAlreadyExists("The user "+user.getUserName()+" already exists");
       }
       user = new User();

       user.setFirstName(userDTO.getFirstName());
       user.setLastName(userDTO.getLastName());
       user.setEmail(userDTO.getEmail());
       user.setPassword((userDTO.getPassword()));
       user.setUserName(userDTO.getUserName());
       user.setPremium(userDTO.isPremium());

       userRepository.save(user);
    }
}
