package com.microservice.project4.shopservice.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShopServiceDelegate {

	@Autowired
    RestTemplate restTemplate;
     
    public String callInventoryServiceAndGetData(String shopName) {
    	
        System.out.println("Getting shop details for " + shopName);
 
        String response = restTemplate.exchange("http://inventory-service/getInventoryForShop/{shopName}",
        		HttpMethod.GET, null, new ParameterizedTypeReference<String>() {},
        		shopName.toLowerCase()).getBody();
         
        System.out.println("Response Received as " + response + " -  " + new Date());
 
        return "Shop Name -  " + shopName + " :::  Inventory Details " + response + " -  " + new Date();
    }
     
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
