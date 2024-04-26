package com.oracle.jp.mushop.catalogue;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.tags.Tags;

import com.oracle.jp.mushop.catalogue.data.Category;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/categories")
public class CategoryResource {

    private final CategoryService categoryService;

    @Inject
    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GET
    @Operation(operationId = "listProdgetCategoriesucts", summary = "Get categories", description = "Returns the categories on the catalogue")
    @APIResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Category.class)))
    @Tags(value = @Tag(name = "Category"))
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories() {
        return Response.ok().entity(categoryService.getAllCategories()).type(MediaType.APPLICATION_JSON).build();
    }
}
