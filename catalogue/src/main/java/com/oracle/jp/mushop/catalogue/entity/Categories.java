package com.oracle.jp.mushop.catalogue.entity;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Categories entity.
 * 
 * @author shukawam
 */
@Entity(name = "Categories")
@Table(name = "CATEGORIES")
@Access(AccessType.FIELD)
public class Categories {
    @Id
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;
    @Column(name = "NAME", length = 30)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Products.class)
    @JoinTable(name = "PRODUCT_CATEGORY", joinColumns = {
            @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID") }, inverseJoinColumns = {
                    @JoinColumn(name = "SKU", referencedColumnName = "SKU") })
    private Products products;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + "]";
    }

}
