package com.dh.demo.web;


import com.dh.demo.domain.Group;
import com.dh.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Juan Zapata on 6/17/2017.
 */
@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    GroupService groupService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Group> getGroupsAll(){
        return groupService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody GroupRequestDTO group){
        groupService.addGroup(group);
    }

    public static class GroupRequestDTO{

        private String name;
        private String logo;
        private String creation_date;
        private String ownerId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getCreation_date() {
            return creation_date;
        }

        public void setCreation_date(String creation_date) {
            this.creation_date = creation_date;
        }

        public String getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(String ownerId) {
            this.ownerId = ownerId;
        }
    }
}
