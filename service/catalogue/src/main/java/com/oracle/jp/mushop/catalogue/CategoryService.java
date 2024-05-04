package com.oracle.jp.mushop.catalogue;

import com.oracle.jp.mushop.catalogue.data.Category;
import com.oracle.jp.mushop.catalogue.entity.Categories;
import com.oracle.jp.mushop.catalogue.exception.CatalogueNotFoundException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class CategoryService {

    @PersistenceContext(name = "h2")
    private EntityManager entityManager;

    public Category getAllCategories() {
        var results = entityManager.createNamedQuery("getAllCategories", Categories.class).getResultStream();
        if (results == null) {
            throw new CatalogueNotFoundException("Categories is not found.");
        }
        var category = new Category();
        category.setCategories(results.map(Categories::getName).toList());
        return category;
    }
}
