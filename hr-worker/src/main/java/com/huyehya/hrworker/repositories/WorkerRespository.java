package com.huyehya.hrworker.repositories;

import com.huyehya.hrworker.entities.Worker;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WorkerRespository extends JpaRepository<Worker, Long> {
}
