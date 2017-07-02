package com.dh.demo.web;

import com.dh.demo.domain.Buyer;
import com.dh.demo.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Juan Zapata on 6/18/2017.
 */
@RestController
@RequestMapping("/buyers")
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Buyer> getAll(){
        return buyerService.getAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addBuyer(@RequestBody BuyerRequestDTO buyer){
        buyerService.addBuyer(buyer);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public void updateCar(@RequestBody Buyer buyer){
        buyerService.update(buyer);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeCar(@RequestBody String id){
        Buyer buyer = buyerService.getByID(id);
        buyerService.removeCar(buyer);
    }


    public static class BuyerRequestDTO {
        private String name;
        private String ci;
        private String profession;
        private String cel;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCi() {
            return ci;
        }

        public void setCi(String ci) {
            this.ci = ci;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getCel() {
            return cel;
        }

        public void setCel(String cel) {
            this.cel = cel;
        }
    }
}
