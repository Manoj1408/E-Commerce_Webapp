package com.webApplicaion.webApp.service;

import com.webApplicaion.webApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
//Service has Component which allows autowiring
public class ProductService {


    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101,"Iphone",5000),
            new Product(102,"Canon",6000),
            new Product(104,"mobile",6000)
    )
    );
    public List<Product> getProducts(){
        return products;
    }

    public Product getProductById(int prodId){
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst().orElse(new Product(100,"No Item",0));
    }

    public List<Product> addProduct(Product prod){
        products.add(prod);
        return products;
    }

    public Product updateProduct(Product prod){
        int index = 0;
        for(int i =0; i<products.size();i++)
            if(products.get(i).getProdId() == prod.getProdId())
                index = i;

        products.set(index,prod);
       return products.stream()
                .filter(p -> p.getProdId() == prod.getProdId())
                .findFirst().get();
    }

//    public List<Product> deleteProduct(int prodId) {
//
//        int index = 0;
//        for(int i =0; i<products.size();i++)
//            if(products.get(i).getProdId() == prodId)
//                index = i;
//
//        return products.remove(index);
//    }
public List<Product> deleteProduct(int prodId) {
    Product toRemove = null;

    for (Product p : products) {
        if (p.getProdId() == prodId) {
            toRemove = p;
            break;
        }
    }

    if (toRemove != null) {
        products.remove(toRemove);
    } else {
        System.out.println("Product not found!");
    }

    return products;
}

}
