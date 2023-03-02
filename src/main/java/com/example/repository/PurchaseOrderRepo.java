package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Order;
import static com.example.repository.Queries.*;

@Repository
public class PurchaseOrderRepo {
    @Autowired
    private JdbcTemplate template;

    public boolean insertPO(Order ord){
        return template.update(SQL_INSERT_PO_TABLE, 
                ord.getOrderId(),
                ord.getNotes(), 
                ord.getCustomerName(),
                ord.getShippingAddress(),
                ord.getTax() ) > 0;
    }

    public int getPOByOrderId(){
        return 0; 
    }
}
