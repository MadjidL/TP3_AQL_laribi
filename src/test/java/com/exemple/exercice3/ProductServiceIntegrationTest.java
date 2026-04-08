package com.exemple.exercice3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceIntegrationTest {

    @Mock
    private ProductApiClient apiClient;

    @InjectMocks
    private ProductService productService;

    // Scénario 1 : Récupération réussie
    @Test
    public void testGetProductSuccess() throws ApiException {
        String productId = "P123";
        Product expectedProduct = new Product(productId, "Smartphone", 699.99);
        when(apiClient.getProduct(productId)).thenReturn(expectedProduct);

        Product actual = productService.getProduct(productId);

        assertEquals(expectedProduct, actual);
        verify(apiClient, times(1)).getProduct(productId);
    }

    // Scénario 2 : Échec d'appel API (ApiException)
    @Test
    public void testGetProductApiFailure() throws ApiException {
        String productId = "P456";
        when(apiClient.getProduct(productId)).thenThrow(new ApiException("API unreachable"));

        assertThrows(ApiException.class, () -> productService.getProduct(productId));
        verify(apiClient, times(1)).getProduct(productId);
    }

    // Scénario 3 : Format de donnée incompatible (par exemple, l'API retourne un produit null)
    @Test
    public void testGetProductIncompatibleData() throws ApiException {
        String productId = "P789";
        when(apiClient.getProduct(productId)).thenReturn(null);

        Product result = productService.getProduct(productId);
        assertNull(result); // Le service peut retourner null ou lever une exception selon le contrat
        verify(apiClient, times(1)).getProduct(productId);
    }

    // Test supplémentaire : argument invalide
    @Test
    public void testGetProductWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> productService.getProduct(null));
        assertThrows(IllegalArgumentException.class, () -> productService.getProduct(""));
        verifyNoInteractions(apiClient); // Le client API n'est jamais appelé
    }
}