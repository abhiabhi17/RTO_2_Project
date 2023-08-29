package com.rto.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rto.entity.VehicleOwnerRegistrationEntity;

public interface RtoOwnerDtlsRepository extends CrudRepository<VehicleOwnerRegistrationEntity,Serializable>{

	
	
}
