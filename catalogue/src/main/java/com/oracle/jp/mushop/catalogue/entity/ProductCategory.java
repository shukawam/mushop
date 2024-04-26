package com.oracle.jp.mushop.catalogue.entity;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * Relational table for PRODUCT and CATEGORY
 * 
 * @author shukawam
 */
@Entity(name = "ProductCategory")
@Table(name = "PRODUCT_CATEGORY")
@Access(AccessType.FIELD)
@NamedQueries(@NamedQuery(name = "listAllProductCategory", query = "SELECT pc FROM ProductCategory pc"))
public class ProductCategory {
    @Id
    @Column(name = "PRODUCT_CATEGORY_ID")
    private Integer productCategoryId;

    @Column(name = "SKU")
    private String sku;
    
    @Column(name = "CATEGORY_ID")
    private String categoryId;

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

}
