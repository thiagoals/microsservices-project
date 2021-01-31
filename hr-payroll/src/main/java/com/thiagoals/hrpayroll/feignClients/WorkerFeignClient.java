package com.thiagoals.hrpayroll.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thiagoals.hrpayroll.entities.Worker;

@Component
@FeignClient(name="hr-worker", path = "/workers")
public interface WorkerFeignClient {
	@RequestMapping(value="/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
}
