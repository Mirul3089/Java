package com.humber.eap.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.humber.eap.model.Owner;
import com.humber.eap.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer>{

}
