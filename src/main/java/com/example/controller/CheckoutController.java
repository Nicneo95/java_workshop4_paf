package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exception.OrderException;
import com.example.model.LineItem;
import com.example.model.Order;
import com.example.model.OrderResult;
import com.example.service.PurchaseOrderService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path= "/checkout")
public class CheckoutController {
    @Autowired
    private PurchaseOrderService poSvc;

    @PostMapping
    public String confirmCheckout(Model model, HttpSession sess)
        throws OrderException{
        List<LineItem> lineItems = (List<LineItem>)
                        sess.getAttribute("cart");
        Order ord = (Order)sess.getAttribute("checkoutCart");
        OrderResult r = poSvc.createPurchaseOrder(ord);  
        sess.invalidate();
        model.addAttribute("total", lineItems.size());
        return "checkout";
    }
}