package com.oracle.jp.mushop.catalogue;

import java.util.List;
import java.util.stream.Stream;

import com.oracle.jp.mushop.catalogue.data.Product;
import com.oracle.jp.mushop.catalogue.data.SizeProducts;
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
            var product = new Product();
            product.setId(result.getSku());
            product.setBrand(result.getBrand());
            product.setTitle(result.getTitle());
            product.setDescription(result.getDescription());
            product.setWeight(result.getWeight());
            product.setProductSize(result.getProductSize());
            product.setColors(result.getColors());
            product.setQty(result.getQty());
            product.setPrice(result.getPrice());
            product.setImageUrl(
                    Stream.of(result.getImageUrl1(), result.getImageUrl2())
                            .filter(url -> url != null && !url.isEmpty())
                            .toList());
            product.setCategory(result.getCategories().stream().map(Categories::getName).toList());
            return product;
        }).toList();
    }

    public SizeProducts getTotalNumberOfProducts() {
        var result = entityManager.createNamedQuery("getTotalNumberOfProducts", Long.class);
        if (result == null) {
            throw new CatalogueNotFoundException("Something went wrong.");
        }
        var sizeProducts = new SizeProducts();
        sizeProducts.setSize(result.getSingleResult());
        return sizeProducts;
    }
}
