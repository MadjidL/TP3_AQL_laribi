package com.exemple.exercice3;

public interface ProductApiClient {
    Product getProduct(String productId) throws ApiException;
}

// Exception personnalisée pour les échecs d'appel
class ApiException extends Exception {
    public ApiException(String message) {
        super(message);
    }
}