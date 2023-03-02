package com.example.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.OrderException;
import com.example.model.Order;
import com.example.model.OrderResult;
import com.example.repository.LineItemRepo;
import com.example.repository.PurchaseOrderRepo;

@Service
public class PurchaseOrderService {
    
    @Autowired
    private PurchaseOrderRepo poRepo;

    @Autowired
    private LineItemRepo lineRepo;

    @Transactional(rollbackFor = OrderException.class)
    public OrderResult createPurchaseOrder(Order ord) throws OrderException{
        String orderId= UUID.randomUUID().toString()
            .substring(0, 8);
        ord.setOrderId(orderId);
        
        poRepo.insertPO(ord);
        // check order > 3 throw exception
        if(ord.getLineItems().size() > 3){
            throw new OrderException();
        }
        lineRepo.addLineItems(ord.getLineItems(), orderId);
        OrderResult r =new OrderResult();
        return r;
    }
}