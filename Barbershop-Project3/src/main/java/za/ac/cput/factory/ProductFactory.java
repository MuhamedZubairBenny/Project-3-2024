package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class ProductFactory {
    public static Product buildProduct(String productId,String productName,String productDescription,double price,int stock) {
        if (Helper.isNullOrEmpty(productId) || Helper.isNullOrEmpty(productName) || Helper.isLessZero(price) || Helper.isLessThanZero(stock))
            return null;
        return new Product.Builder().setProductId(productId)
                .setProductName(productName)
                .setProductDescription(productDescription)
                .setPrice(price)
                .setStock(stock)
                .build();
    }
    public static Product buildProduct(String productName, String productDescription, double price, int stock){
        if (Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(productDescription) || Helper.isLessZero(price) | Helper.isLessThanZero(stock))
            return null;
        String productId = Helper.generateId();
        return new Product.Builder().setProductId(productId)
                .setProductName(productName)
                .setProductDescription(productDescription)
                .setPrice(price)
                .setStock(stock)
                .build();
    }
}

