package com.dh.demo.service;

import com.dh.demo.domain.Seller;
import com.dh.demo.repository.SellerRepository;
import com.dh.demo.web.SellerController;
import io.swagger.annotations.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Juan Zapata on 6/18/2017.
 */
@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;

    public List<Seller> getAll(){
        return sellerRepository.findAll();
    }

    public void addSeller(SellerController.SellerRequestDTO sellerDTO){
        Seller seller = new Seller();

        seller.setCi(sellerDTO.getCi());
        seller.setNum_cars_sold(sellerDTO.getNum_cars_sold());
        seller.setName(sellerDTO.getName());

        sellerRepository.save(seller);
    }

    public void removeCar(Seller seller){
        sellerRepository.delete(seller);
    }

    public void update(Seller seller){
        sellerRepository.save(seller);
    }

    public Seller getByID(String id){
        return sellerRepository.findOne(id);
    }
}
