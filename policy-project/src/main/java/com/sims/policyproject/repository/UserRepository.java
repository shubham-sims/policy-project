package com.sims.policyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sims.policyproject.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
