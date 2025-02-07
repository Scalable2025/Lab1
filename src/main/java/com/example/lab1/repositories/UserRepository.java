package com.example.lab1.repositories;

import com.example.lab1.models.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    public List<User> findAll() {
        try {

        ObjectMapper objectMapper = new ObjectMapper();
        String FILE_PATH = "src/main/resources/users.json";
        File file = new ClassPathResource("users.json").getFile();
        List<User> users = objectMapper.readValue(file, new TypeReference<List<User>>() {});

        return users;
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to read users.json");
        }
    }

    public Optional<User> findById(String id) {
        try {
            return findAll().stream()
                    .filter(user -> user.getId().equals(id))
                    .findFirst();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to read users.json");
        }
    }

    public User save(User user){
        user.setId(UUID.randomUUID().toString());
        return user;
    }
}
