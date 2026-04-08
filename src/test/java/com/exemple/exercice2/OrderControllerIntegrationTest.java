package com.exemple.exercice2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderControllerIntegrationTest {

    @Mock
    private OrderService orderService;   // Mock du service

    @InjectMocks
    private OrderController orderController; // Le contrôleur utilise le mock

    @Test
    public void testCreateOrder() {
        // Préparation
        Order order = new Order(1L, "Laptop");

        // Exécution
        orderController.createOrder(order);

        // Vérification que OrderService.createOrder a été appelé avec le bon order
        verify(orderService, times(1)).createOrder(order);
    }
    @Test
    public void testFullIntegration() {
        OrderDao mockDao = mock(OrderDao.class);
        OrderService realService = new OrderService(mockDao);
        OrderController controller = new OrderController(realService);
        Order order = new Order(2L, "Mouse");

        controller.createOrder(order);

        verify(mockDao, times(1)).saveOrder(order);
    }
}