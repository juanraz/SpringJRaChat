package com.dh.demo.service;

import com.dh.demo.domain.Group;
import com.dh.demo.domain.User;
import com.dh.demo.repository.GroupRepository;
import com.dh.demo.web.GroupController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Zapata on 6/17/2017.
 */
@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    UserService userService;

    public List<Group> getAll(){
        return groupRepository.findAll();
    }

    public void addGroup(GroupController.GroupRequestDTO groupDTO){
        Group group = new Group();

        group.setCreation_date(groupDTO.getCreation_date());
        group.setLogo(groupDTO.getLogo());
        group.setName(groupDTO.getName());
        User user = userService.getByID(groupDTO.getOwnerId());
        group.setOwner(user);

        groupRepository.save(group);
    }

}
