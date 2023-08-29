package com.rto.repo;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rto.entity.OwnerAddressEntity;
import com.rto.entity.VehicleDetailsEntity;

public interface RtoRepoVDetails extends CrudRepository<VehicleDetailsEntity,Serializable>{

	@Query(value ="select type,vcompanyname,year from VehicleDetailsEntity where v_own_id=:ownerId")
	public List<Object> getVehicleDeatailsByOid(Integer ownerId);
	
	
//	@Query(value ="select type,vcompanyname,year from VehicleDetailsEntity where v_own_id=:ownerId")
//	public Optional<VehicleDetailsEntity> getVehicleDeatailsByOidForRest(Integer ownerId);

	
	@Query(value ="select e from VehicleDetailsEntity  e where e.vehicleOwn.oid=:ownerId")
	public VehicleDetailsEntity getVehicleDeatailsByOidForRest(Integer ownerId);

}

