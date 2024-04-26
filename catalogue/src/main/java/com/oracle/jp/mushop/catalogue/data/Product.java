package com.oracle.jp.mushop.catalogue.data;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Response object for Product.
 * 
 * @author shukawam
 */
public class Product {

    @NotNull
    @Max(value = 20)
    @Pattern(regexp = "^[A-Z]{2}-[A-Z]{2}-[0-9]{3,5}$")
    private String id;

    @NotNull
    @Max(value = 20)
    private String brand;

    @NotNull
    @Max(value = 40)
    private String title;

    @NotNull
    @Max(value = 500)
    private String description;

    @Max(value = 10)
    private String weight;

    @Max(value = 25)
    private String productSize;

    @Max(value = 20)
    private String colors;

    @NotNull
    @Pattern(regexp = "^[0-9]\\d*$")
    private Integer qty;

    @NotNull
    @Pattern(regexp = "^\\d+(,\\d{1,2})?$")
    private Double price;

    @Pattern(regexp = ".+\\.(gif|jpe?g|tiff?|png|webp|bmp)$")
    private List<String> imageUrl;

    @NotNull
    @Max(value = 50)
    private List<String> category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", brand=" + brand + ", title=" + title + ", description=" + description
                + ", weight=" + weight + ", productSize=" + productSize + ", colors=" + colors + ", qty=" + qty
                + ", price=" + price + ", imageUrl=" + imageUrl + ", category=" + category + "]";
    }

}
