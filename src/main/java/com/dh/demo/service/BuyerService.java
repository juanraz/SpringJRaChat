package com.dh.demo.service;

import com.dh.demo.domain.Buyer;
import com.dh.demo.repository.BuyerRepository;
import com.dh.demo.web.BuyerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Zapata on 6/18/2017.
 */
@Service
public class BuyerService {
    @Autowired
    BuyerRepository buyerRepository;

    public List<Buyer> getAll(){
        return buyerRepository.findAll();
    }

    public void addBuyer(BuyerController.BuyerRequestDTO buyerDTO){
        Buyer buyer = new Buyer();

        buyer.setCel(buyerDTO.getCel());
        buyer.setProfession(buyerDTO.getProfession());
        buyer.setName(buyerDTO.getName());
        buyer.setCi(buyerDTO.getCi());

        buyerRepository.save(buyer);
    }

    public void removeCar(Buyer buyer){
        buyerRepository.delete(buyer);
    }

    public void update(Buyer buyer){
        buyerRepository.save(buyer);
    }

    public Buyer getByID(String id){
        return buyerRepository.findOne(id);
    }


}
