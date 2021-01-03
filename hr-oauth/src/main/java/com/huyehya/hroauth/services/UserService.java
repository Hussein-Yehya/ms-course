package com.huyehya.hroauth.services;

import com.huyehya.hroauth.entities.User;
import com.huyehya.hroauth.feignClients.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();

        if (Objects.isNull(user)){
            log.error("E-mail not found: ".concat(email));
            throw new IllegalArgumentException("E-mail not found");
        }
        log.info("E-mail found: ".concat(email));
        return user;
    }
}
