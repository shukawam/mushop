package com.oracle.jp.mushop.catalogue;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.tags.Tags;

import com.oracle.jp.mushop.catalogue.data.Product;
import com.oracle.jp.mushop.catalogue.data.SizeProduct;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/catalogue")
public class CatalogueResource {
    private final CatalogueService catalogService;

    @Inject
    public CatalogueResource(CatalogueService productCatalogService) {
        this.catalogService = productCatalogService;
    }

    @GET
    @Operation(operationId = "listProducts", summary = "ist All Products", description = "Returns all products on the catalogue with details")
    @APIResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Product.class)))
    @Tags(value = @Tag(name = "Catalogue"))
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllProduct() {
        return Response.ok().entity(catalogService.listAllProductCategory()).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/size")
    @Operation(operationId = "getTotalNumberOfProducts", summary = "Get the number of products", description = "Returns the total number of products in the catalogue")
    @APIResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = SizeProduct.class)))
    @Tags(value = @Tag(name = "Catalogue"))
    public Response getTotalNumberOfProducts() {
        return Response.ok().entity(catalogService.getTotalNumberOfProducts()).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    @Operation(operationId = "getProduct", summary = "Get a product by ID", description = "Returns a single product")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Product.class))),
            @APIResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
            @APIResponse(responseCode = "404", description = "Product not found", content = @Content(mediaType = MediaType.APPLICATION_JSON)) })
    @Tags(value = @Tag(name = "Catalogue"))
    public Response getProduct(@PathParam("id") String id) {
        return Response.ok().entity(catalogService.getProductById(id)).type(MediaType.APPLICATION_JSON).build();
    }

}
