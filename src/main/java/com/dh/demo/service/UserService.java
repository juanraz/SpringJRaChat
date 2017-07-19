package com.dh.demo.service;

import com.dh.demo.domain.User;
import com.dh.demo.jraexception.UserAlreadyExists;
import com.dh.demo.repository.UserRepository;
import com.dh.demo.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Zapata on 6/17/2017.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByUserName(String userName){
        return  userRepository.findByUserName(userName);
    }

    public User getByID(String id){
        return userRepository.findOne(id);
    }

    public List<User> getAll(){
        return (List<User>)userRepository.findAll();
    }

    public List<User> getAllBut(String user){
        List<User> li = (List<User>)userRepository.findAllBut(user);
        /*List<User> res = new ArrayList<User>();
        for(User u : li){
            System.out.println(u.getId()+" "+user);
            if(!u.getId().equals(user)){
                res.add(u);
            }
        }*/
        return li;
    }

    public void updateUser(UserController.UserRequestDTO userDTO) {

        User user;
        user = this.getByID(userDTO.getUserName());

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword((userDTO.getPassword()));
        user.setPremium(userDTO.isPremium());

        userRepository.save(user);
    }

    public void deleteUser(String userId) {

        User user;
        user = this.getByID(userId);
        if(user!=null){
            user.setStatus("removed");
            userRepository.save(user);
        }
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
