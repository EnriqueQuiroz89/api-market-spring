package com.mexicode.market.domain;

public class Product {
    /**Atributos que quiero en mi api**/
    private int productId;
    private  String name;
    private  int categoryId;
    private  double price;
    private  double stock;
    private  boolean active;
    /**Categoria relacion con Peristencia NO USAR*/
    /**Category  relacion con Dominio Si usuar**/
    private  Category category;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
