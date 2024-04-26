package com.oracle.jp.mushop.catalogue.exception;

/**
 * Wrapped Exception for Catalogue Service.
 * 
 * @author shukawam
 */
public class CatalogueNotFoundException extends RuntimeException {

    public CatalogueNotFoundException() {
        super();
    }

    public CatalogueNotFoundException(String message) {
        super(message);
    }

    public CatalogueNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatalogueNotFoundException(Throwable cause) {
        super(cause);
    }
}
