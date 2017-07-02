package com.dh.demo.web;

import com.dh.demo.domain.Seller;
import com.dh.demo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Juan Zapata on 6/18/2017.
 */
@RestController
@RequestMapping("/sellers")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Seller> getAll(){
        return sellerService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addSeller(@RequestBody  SellerRequestDTO seller){
        sellerService.addSeller(seller);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public void updateCar(@RequestBody Seller seller){
        sellerService.update(seller);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeCar(@RequestBody String id){
        Seller car = sellerService.getByID(id);
        sellerService.removeCar(car);
    }

    public static class SellerRequestDTO{
        private String name;
        private String ci;
        private int num_cars_sold;

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

        public int getNum_cars_sold() {
            return num_cars_sold;
        }

        public void setNum_cars_sold(int num_cars_sold) {
            this.num_cars_sold = num_cars_sold;
        }
    }
}
