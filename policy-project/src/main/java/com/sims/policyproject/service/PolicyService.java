package com.sims.policyproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.policyproject.entity.Policy;
import com.sims.policyproject.exception.PolicyException;
import com.sims.policyproject.repository.PolicyRepository;

@Service
@Transactional
public class PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	public Policy getPolicy(String policyNumber) throws PolicyException {
		
		Optional<Policy> optionalPolicy = policyRepository.findById(policyNumber);
		
		if(optionalPolicy.isEmpty()) {
			throw new PolicyException("policyService.POLICY_NOT_FOUND");
		}
		
		Policy policy = optionalPolicy.get();
		
		return policy;
	}

	public Policy updatePolicy(Policy updatedPolicy) throws PolicyException {
		
		Optional<Policy> optionalPolicy = policyRepository.findById(updatedPolicy.getPolicyNumber());
		
		if(optionalPolicy.isEmpty()) {
			throw new PolicyException("policyService.POLICY_NOT_FOUND");
		}
		
		Policy existingPolicy = optionalPolicy.get();
		
		existingPolicy.setPolicyNumber(updatedPolicy.getPolicyNumber());
		existingPolicy.setPolicyPerson(updatedPolicy.getPolicyPerson());
		existingPolicy.setPhoneNumber(updatedPolicy.getPhoneNumber());
		existingPolicy.setAddress(updatedPolicy.getAddress());
		existingPolicy.setTermDuration(updatedPolicy.getTermDuration());
		existingPolicy.setEffectiveDate(updatedPolicy.getEffectiveDate());
		existingPolicy.setExpirationDate(updatedPolicy.getExpirationDate());
		existingPolicy.setPremium(updatedPolicy.getPremium());
		
		existingPolicy = policyRepository.save(existingPolicy);
		
		return existingPolicy;
	}

	public Policy createPolicy(Policy policy) throws PolicyException{
		
		Optional<Policy> existingPolicy = policyRepository.findById(policy.getPolicyNumber());
		
		if(existingPolicy.isPresent()) {
			throw new PolicyException("policyService.POLICY_ALREADY_EXISTS");
		}
		Policy newPolicy = policyRepository.save(policy);
		
		return newPolicy;
	}
}
