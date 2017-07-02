package com.dh.demo.web;

import com.dh.demo.domain.Seller;
import com.dh.demo.domain.SoldCarRegistry;
import com.dh.demo.service.SellerService;
import com.dh.demo.service.SoldCarRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Juan Zapata on 6/20/2017.
 */
@RestController
@RequestMapping("/registries")
public class SoldCarRegistryController {

    @Autowired
    SoldCarRegistryService soldCarRegistryService;

    @Autowired
    SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<SoldCarRegistry> getAll(){
        return soldCarRegistryService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addRegistry(@RequestBody SoldCarRegistryRequestDTO soldCarRegistry){
        soldCarRegistryService.addRegistry(soldCarRegistry);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public void updateRegistry(@RequestBody SoldCarRegistry soldCarRegistry){
        soldCarRegistryService.update(soldCarRegistry);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeRegistry(@RequestBody String id){
        SoldCarRegistry soldCarRegistry = soldCarRegistryService.getByID(id);
        soldCarRegistryService.removeRegistry(soldCarRegistry);
    }

    @RequestMapping(value="/canCarsSoldBySeller/{sellerId}",method = RequestMethod.GET)
    public HashMap<String,Object> getSold(@PathVariable("sellerId") String sellerId){

        Seller seller = sellerService.getByID(sellerId);

        HashMap<String,Object> hm = new HashMap<String,Object>();
        hm.put("nameSeller",seller.getName());
        hm.put("QuantityCarsSold",seller.getNum_cars_sold());

        return hm;
    }


    public static class SoldCarRegistryRequestDTO{
        private Date sellingDate;
        private String carId;
        private String sellerId;
        private String buyerId;

        public Date getSellingDate() {
            return sellingDate;
        }

        public void setSellingDate(Date sellingDate) {
            this.sellingDate = sellingDate;
        }

        public String getCarId() {
            return carId;
        }

        public void setCarId(String carId) {
            this.carId = carId;
        }

        public String getSellerId() {
            return sellerId;
        }

        public void setSellerId(String sellerId) {
            this.sellerId = sellerId;
        }

        public String getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(String buyerId) {
            this.buyerId = buyerId;
        }


    }

}
