package com.dh.demo.web;

import com.dh.demo.common.Response;
import com.dh.demo.domain.User;
import com.dh.demo.jraexception.UserAlreadyExists;
import com.dh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by Juan Zapata on 6/17/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired(required = true)
    Response res;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response getAll(){
        res.setSuccess(true);
        res.setResponseObject(userService.getAll());
        return res;
    }

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public Response getAllBut(@PathVariable("user") String user){
        res.setSuccess(true);
        res.setResponseObject(userService.getAllBut(user));
        return res;
    }

    @RequestMapping(value = "/login/{user}/{password}", method = RequestMethod.GET)
    @Produces
    public Response login(  @PathVariable("user") String user,
                            @PathVariable("password") String password){

        UserRequestDTO userDto = null;
        User u = userService.getByID(user);

        if(null != u){
            if(u.getPassword().equals(password)){
                userDto.setUserName(u.getUserName());
                userDto.setFirstName(u.getFirstName());
                userDto.setLastName(u.getLastName());
                userDto.setEmail(u.getEmail());
                userDto.setPremium(u.isPremium());
            }
        }
        res.setSuccess(true);
        res.setResponseObject(userDto);
        return res;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Response addUser(@RequestBody UserRequestDTO userDTO){
        res.setSuccess(true);
        res.setMessage("User created.");
        try{
            userService.addUser(userDTO);
        }catch(UserAlreadyExists e){
            res.setMessage("User already exists.");
            res.setSuccess(false);
        }catch (Exception e){
            System.out.println(e);
            res.setMessage("User was not created.");
            res.setSuccess(false);
        }finally {
            return res;
        }
    }

    public static class UserRequestDTO {

        private String firstName;
        private String lastName;
        private String email;
        private String userName;
        private String password;
        private String Status;
        private boolean isPremium;

        public boolean isPremium() {
            return isPremium;
        }

        public void setPremium(boolean premium) {
            isPremium = premium;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String status) {
            Status = status;
        }
    }
}
