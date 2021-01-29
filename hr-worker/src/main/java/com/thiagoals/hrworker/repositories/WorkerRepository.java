package com.thiagoals.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiagoals.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
