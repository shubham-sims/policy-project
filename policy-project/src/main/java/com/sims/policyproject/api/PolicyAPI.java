package com.sims.policyproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sims.policyproject.entity.Policy;
import com.sims.policyproject.exception.PolicyException;
import com.sims.policyproject.service.PolicyService;

@RestController
@RequestMapping("/policy")
@CrossOrigin(origins = {"http://localhost:3000/", "https://g8zztlp4-3000.inc1.devtunnels.ms/"})
@Validated
public class PolicyAPI {
	
	@Autowired
	private PolicyService policyService;
	
	@GetMapping("/get/{policyNumber}") 
	public ResponseEntity<Policy> getPolicy(@PathVariable String policyNumber) throws PolicyException{
		
		Policy policy = policyService.getPolicy(policyNumber);
		
		return new ResponseEntity<Policy>(policy, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Policy> updatePolicy(@RequestBody Policy updatedPolicy)
			throws PolicyException{
		
		Policy policy = policyService.updatePolicy(updatedPolicy);
		
		return new ResponseEntity<Policy>(policy, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) throws PolicyException{
		
		Policy createdPolicy = policyService.createPolicy(policy);
		
		return new ResponseEntity<Policy>(createdPolicy, HttpStatus.CREATED);
	}
}
