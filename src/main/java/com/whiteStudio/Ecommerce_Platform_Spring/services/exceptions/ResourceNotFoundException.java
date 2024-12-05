package com.whiteStudio.Ecommerce_Platform_Spring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id)
    {
        super("Resource not found id: " + id);
    }
}
