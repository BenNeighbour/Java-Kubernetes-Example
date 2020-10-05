package com.benneighbour.javakubernetes.gatewayservice.controller;

import com.benneighbour.javakubernetes.gatewayservice.exception.ResourceNotFoundException;
import com.benneighbour.javakubernetes.gatewayservice.model.User;
import com.benneighbour.javakubernetes.gatewayservice.repository.UserRepository;
import com.benneighbour.javakubernetes.gatewayservice.security.CurrentUser;
import com.benneighbour.javakubernetes.gatewayservice.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getUserId()));
    }
}
