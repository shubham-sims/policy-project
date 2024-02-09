package com.sims.policyproject.repository;

import org.springframework.stereotype.Repository;
import com.sims.policyproject.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, String>{

}
