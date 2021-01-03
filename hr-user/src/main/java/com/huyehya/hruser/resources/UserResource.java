package com.huyehya.hruser.resources;

import com.huyehya.hruser.entities.User;
import com.huyehya.hruser.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        User user = userRepository.findById(id).get();

        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {
        User user = userRepository.findByEmail(email);

        return ResponseEntity.ok(user);
    }

}
