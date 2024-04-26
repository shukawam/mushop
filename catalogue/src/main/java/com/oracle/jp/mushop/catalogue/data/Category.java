package com.oracle.jp.mushop.catalogue.data;

import java.util.List;

import jakarta.validation.constraints.NotNull;

/**
 * Response object for Category.
 * 
 * @author shukawam
 */
public class Category {

    @NotNull
    private List<String> categories;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> items) {
        this.categories = items;
    }

    @Override
    public String toString() {
        return "Categories [items=" + categories + "]";
    }

}
