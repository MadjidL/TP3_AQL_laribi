package com.exemple.exercice1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceIntegrationTest {

    @Mock
    private UserRepository userRepository;  // Mock de la dépendance

    @InjectMocks
    private UserService userService;        // Injection du mock dans le service

    @Test
    public void testGetUserById() {
        // Préparation : on définit le comportement du mock
        long userId = 123L;
        User expectedUser = new User(userId, "Alice");
        when(userRepository.findUserById(userId)).thenReturn(expectedUser);

        // Exécution
        User actualUser = userService.getUserById(userId);

        // Vérification
        assertEquals(expectedUser, actualUser);
        // Vérifie que la méthode findUserById a été appelée exactement une fois avec l'id 123
        verify(userRepository, times(1)).findUserById(userId);
    }
}