package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.LineItem;
import com.example.model.Order;
import static com.example.repository.Queries.*;


@Repository
public class LineItemRepo {
    
    @Autowired
    private JdbcTemplate template;

    public void addLineItems(List<LineItem> lineItems, 
        String orderId){
        List<Object[]> arrData =  lineItems.stream()
        .map( li -> {
            Object[] l = new Object[5];
            l[0] = li.getProduct();
            l[1] = li.getQuantity();
            l[2] = orderId;
            l[3] = li.getUnitPrice();
            l[4] = li.getDiscount();
            return l;
        }).toList();
    
        template.batchUpdate(SQL_INSERT_LINEITEM_TABLE, arrData);

    }

    public int getLineItemsCountByOrderId(){
        return 0; 
    }
    
}