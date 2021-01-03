package com.huyehya.hrworker.resources;

import com.huyehya.hrworker.entities.Worker;
import com.huyehya.hrworker.repositories.WorkerRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@Slf4j
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment environment;

    @Autowired
    private WorkerRespository workerRespository;

    @GetMapping(value = "/configs")
    public ResponseEntity<?> configs() {
        log.info("Test Config: ".concat(testConfig));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        final List<Worker> workers = workerRespository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

//        try {
//            Thread.sleep(3000l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        log.info("PORT =".concat(environment.getProperty("local.server.port")));

        Worker worker = workerRespository.findById(id).get();
        return ResponseEntity.ok(worker);
    }

}
