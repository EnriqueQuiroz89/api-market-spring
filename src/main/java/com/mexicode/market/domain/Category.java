package com.mexicode.market.domain;

public class Category {

    /**Atributos que si ocupo en mi API*/
    private int categoryId;
    private String category;
    private boolean active;

    /***getters an setters*/
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
