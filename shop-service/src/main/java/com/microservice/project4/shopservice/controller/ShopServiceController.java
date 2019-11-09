package com.microservice.project4.shopservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.project4.shopservice.delegate.ShopServiceDelegate;

@RestController
public class ShopServiceController {

	@Autowired
    ShopServiceDelegate shopServiceDelegate;
 
	//The annotation of RequestMapping can map HTTP request 
    //"http://host:port/" to this method
    @RequestMapping("/")
    public String home() {
        return "Welcome to shop service";
    }
    
    @RequestMapping(value = "/getShopDetails/{shopName}", method = RequestMethod.GET)
    public String getInventory(@PathVariable String shopName) {
    	
        System.out.println("Going to call inventory service to get data!");
        return shopServiceDelegate.callInventoryServiceAndGetData(shopName);
    }
}
