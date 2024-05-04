package com.oracle.jp.mushop.catalogue.entity;

import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Products entity.
 *
 * @author shukawam
 */
@Entity(name = "Products")
@Table(name = "PRODUCTS")
@Access(AccessType.FIELD)
@NamedQueries({ @NamedQuery(name = "getAllProducts", query = "SELECT p FROM Products p"),
        @NamedQuery(name = "getProductById", query = "SELECT p FROM Products p WHERE p.sku = :sku"),
        @NamedQuery(name = "getTotalNumberOfProducts", query = "SELECT COUNT(*) FROM Products p") })
public class Products {
    @Id
    @Column(name = "SKU", length = 20)
    private String sku;

    @Column(name = "BRAND", length = 20)
    private String brand;

    @Column(name = "TITLE", length = 40)
    private String title;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @Column(name = "WEIGHT", length = 10)
    private String weight;

    @Column(name = "PRODUCT_SIZE", length = 25)
    private String productSize;

    @Column(name = "COLORS", length = 20)
    private String colors;

    @Column(name = "QTY")
    private Integer qty;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "IMAGE_URL_1")
    private String imageUrl1;

    @Column(name = "IMAGE_URL_2")
    private String imageUrl2;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Categories.class)
    @JoinTable(name = "PRODUCT_CATEGORY", joinColumns = {
            @JoinColumn(name = "SKU", referencedColumnName = "SKU") }, inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID"))
    private List<Categories> categories;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl1() {
        return imageUrl1;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }

    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Product [sku=" + sku + ", brand=" + brand + ", title=" + title + ", description=" + description
                + ", weight=" + weight + ", productSize=" + productSize + ", colors=" + colors + ", qty=" + qty
                + ", price=" + price + ", imageUrl1=" + imageUrl1 + ", imageUrl2=" + imageUrl2 + "]";
    }
}
