package com.dh.demo.service;

import com.dh.demo.domain.Buyer;
import com.dh.demo.domain.Car;
import com.dh.demo.domain.Seller;
import com.dh.demo.domain.SoldCarRegistry;
import com.dh.demo.repository.SoldCarRegistryRepository;
import com.dh.demo.web.SoldCarRegistryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Juan Zapata on 6/20/2017.
 */
@Service
public class SoldCarRegistryService {
    @Autowired
    SoldCarRegistryRepository soldCarRegistryRepository;
    @Autowired
    CarService carService;
    @Autowired
    SellerService sellerService;
    @Autowired
    BuyerService buyerService;

    public List<SoldCarRegistry> getAll(){
        return soldCarRegistryRepository.findAll();
    }

    @Transactional
    public void addRegistry(SoldCarRegistryController.SoldCarRegistryRequestDTO soldCarRegistryDTO){
        SoldCarRegistry soldCarRegistry = new SoldCarRegistry();

        Car     car =       carService.getByID(soldCarRegistryDTO.getCarId());
        Seller  seller =    sellerService.getByID(soldCarRegistryDTO.getSellerId());
        Buyer   buyer =     buyerService.getByID(soldCarRegistryDTO.getBuyerId());

        int carsSold = seller.getNum_cars_sold();
        carsSold++;
        System.out.println("vendidos "+carsSold);
        seller.setNum_cars_sold(carsSold);
        System.out.println("vendidos "+carsSold);

        sellerService.update(seller);

        soldCarRegistry.setBuyer(buyer);
        soldCarRegistry.setCar(car);
        soldCarRegistry.setSeller(seller);
        soldCarRegistry.setSellingDate(soldCarRegistryDTO.getSellingDate());

        soldCarRegistryRepository.save(soldCarRegistry);
    }

    public void removeRegistry(SoldCarRegistry soldCarRegistry){
        soldCarRegistryRepository.delete(soldCarRegistry);
    }



    public void update(SoldCarRegistry soldCarRegistry){
        soldCarRegistryRepository.save(soldCarRegistry);
    }

    public SoldCarRegistry getByID(String id){
        return soldCarRegistryRepository.findOne(id);
    }
}
