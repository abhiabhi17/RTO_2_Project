package com.rto.repo;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rto.entity.OwnerAddressEntity;
import com.rto.entity.VehicleDetailsEntity;

public interface RtoRepoOAddress extends CrudRepository<OwnerAddressEntity,Serializable>{

	@Query(value ="select city,hno,streetno,zip from OwnerAddressEntity where v_own_id=:ownerId")
	public List<Object> getVehicleOwnerAddDeatailsByOid(Integer ownerId);

	@Query(value ="select e from OwnerAddressEntity  e where e.vihcleOwnEntity.oid=:ownerId")
	public OwnerAddressEntity getVehicleOwnerAddDeatailsByOidForRest(Integer ownerId);

	
}
