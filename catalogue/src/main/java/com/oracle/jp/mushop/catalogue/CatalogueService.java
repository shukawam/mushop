package com.oracle.jp.mushop.catalogue;

import java.util.List;
import java.util.stream.Stream;

import com.oracle.jp.mushop.catalogue.data.Product;
import com.oracle.jp.mushop.catalogue.data.SizeProduct;
import com.oracle.jp.mushop.catalogue.entity.Categories;
import com.oracle.jp.mushop.catalogue.entity.Products;
import com.oracle.jp.mushop.catalogue.exception.CatalogueNotFoundException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class CatalogueService {

    @PersistenceContext(name = "h2")
    private EntityManager entityManager;

    public List<Product> listAllProductCategory() {
        var results = entityManager.createNamedQuery("getAllProducts", Products.class).getResultStream();
        if (results == null) {
            throw new CatalogueNotFoundException("Product is not found.");
        }
        return results.map(result -> {
            var product = copy(result);
            return product;
        }).toList();
    }

    public SizeProduct getTotalNumberOfProducts() {
        var result = entityManager.createNamedQuery("getTotalNumberOfProducts", Long.class);
        if (result == null) {
            throw new CatalogueNotFoundException("Something went wrong.");
        }
        var sizeProducts = new SizeProduct();
        sizeProducts.setSize(result.getSingleResult());
        return sizeProducts;
    }

    public Product getProductById(String id) {
        var result = entityManager.createNamedQuery("getProductById", Products.class).setParameter("sku", id);
        if (result == null) {
            throw new CatalogueNotFoundException(String.format("Product: %s is not found.", id));
        }
        var product = copy(result.getSingleResult());
        return product;
    }

    private Product copy(Products p) {
        var product = new Product();
        product.setId(p.getSku());
        product.setBrand(p.getBrand());
        product.setTitle(p.getTitle());
        product.setDescription(p.getDescription());
        product.setWeight(p.getWeight());
        product.setProductSize(p.getProductSize());
        product.setColors(p.getColors());
        product.setQty(p.getQty());
        product.setPrice(p.getPrice());
        product.setImageUrl(
                Stream.of(p.getImageUrl1(), p.getImageUrl2())
                        .filter(url -> url != null && !url.isEmpty())
                        .toList());
        product.setCategory(p.getCategories().stream().map(Categories::getName).toList());
        return product;
    }
}
