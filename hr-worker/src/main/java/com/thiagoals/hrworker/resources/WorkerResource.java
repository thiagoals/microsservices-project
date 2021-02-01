package com.thiagoals.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiagoals.hrworker.entities.Worker;
import com.thiagoals.hrworker.repositories.WorkerRepository;

@RestController
@RefreshScope
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	@Value("${test.config}")
	private String testConfig;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> workersList = repository.findAll();
		return ResponseEntity.ok(workersList);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Worker> findById(@PathVariable("id") Long id){
		try {
			Thread.sleep(3000L);
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		logger.info("PORT = "+env.getProperty("local.server.port"));
		Worker workersList = repository.findById(id).get();
		return ResponseEntity.ok(workersList);
	}
	
	@GetMapping(value="/configs")
	public ResponseEntity<Void> getConfigs(){
		logger.info("CONFIG = "+testConfig);
		return ResponseEntity.noContent().build();
	}
}
