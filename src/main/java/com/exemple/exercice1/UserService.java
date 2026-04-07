package com.exemple.exercice1;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(long id) {
        // Appelle le repository pour récupérer l'utilisateur
        return userRepository.findUserById(id);
    }
}