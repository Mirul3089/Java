package com.humber.eap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.humber.eap.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer>{

}
