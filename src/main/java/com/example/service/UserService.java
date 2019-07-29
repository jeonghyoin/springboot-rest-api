package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.domain.User;
import com.example.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getOneUserById(long id) {
		return userRepository.findById(id);
	}

	public void createUser(User user) {
        userRepository.save(user);
	}

	public void deleteUserById(long id) {
        userRepository.deleteById(id);
	}
}