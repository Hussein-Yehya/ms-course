package com.huyehya.hroauth.resources;

import com.huyehya.hroauth.entities.User;
import com.huyehya.hroauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/search")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {
        try {
            User user = userService.findByEmail(email);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

}
