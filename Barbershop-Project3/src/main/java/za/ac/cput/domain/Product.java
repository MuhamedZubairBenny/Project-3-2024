package za.ac.cput.domain;

import java.util.Objects;

public class Product {
    public String productId;
    private String productName;
    private String productDescription;
    private double price;
    private int stock;

    protected Product(){}

    public Product(Builder builder){
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.productDescription = builder.productDescription;
        this.price= builder.price;
        this.stock = builder.stock;

    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && stock == product.stock && Objects.equals(productId, product.productId) && Objects.equals(productName, product.productName) && Objects.equals(productDescription, product.productDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productDescription, price, stock);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
    public static class Builder{
        public String productId;
        private String productName;
        private String productDescription;
        private double price;
        private int stock;

        public Builder setProductId(String productId){
            this.productId = productId;
            return this;
        }
        public Builder setProductName(String productName){
            this.productName = productName;
            return this;
        }
        public Builder setProductDescription(String productDescription){
            this.productDescription = productDescription;
            return this;
        }
        public Builder setPrice(double price){
            this.price=price;
            return this;
        }
        public Builder setStock(int stock){
            this.stock = stock;
            return this;
        }
        public Builder copy(Product product){
            this.productId = product.productId;
            this.productName = product.productName;
            this.productDescription = product.productDescription;
            this.price = product.price;
            this.stock = product.stock;
            return this;
        }
        public Product build(){return new Product(this);}
    }
}


