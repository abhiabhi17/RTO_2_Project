package com.rto.service;


import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entity.OwnerAddressEntity;
import com.rto.entity.VehicleDetailsEntity;
import com.rto.entity.VehicleOwnerRegistrationEntity;
import com.rto.entity.VehicleRegistrationNoEntity;
import com.rto.model.OwnerAddressModel;
import com.rto.model.VehicleDetailsModel;
import com.rto.model.VehicleOwnerRegistrationModel;
import com.rto.model.VehicleRegistrationNoModel;
import com.rto.model.VehicleSummary;
import com.rto.repo.RtoOwnerDtlsRepository;
import com.rto.repo.RtoRepoOAddress;
import com.rto.repo.RtoRepoVDetails;
import com.rto.repo.RtoRepoVRegistration;

@Service
public class RtoServiceMgmtImpl implements RtoServiceMgmt {

	@Autowired
	private RtoOwnerDtlsRepository OwnerDtlsRepo;

	@Autowired
	private RtoRepoVDetails vehicleDtlsRepo;

	@Autowired
	private RtoRepoOAddress ownerAddRepo;

	@Autowired
	private RtoRepoVRegistration vregiRepo;

	private VehicleOwnerRegistrationEntity vownerEntity = null, savedvownerEntity = null;

	public String saveVehicleOwnerDetails(VehicleOwnerRegistrationModel vorModel) {
		String msg = null;
		vownerEntity = new VehicleOwnerRegistrationEntity();
		// copy model to source
		BeanUtils.copyProperties(vorModel, vownerEntity);
		// use repo
		savedvownerEntity = OwnerDtlsRepo.save(vownerEntity);
		if (savedvownerEntity.getOid() != null) {
			msg = "successfully done";
		} else {
			msg = "failed";
		}

		return msg;
	}

	@Override
	public String saveVehicleDetails(VehicleDetailsModel vehicle) {
		VehicleDetailsEntity entity = null, savedEntity = null;
		String msg = null;
		entity = new VehicleDetailsEntity();

		// copy model to entity
		BeanUtils.copyProperties(vehicle, entity);
		entity.setVehicleOwn(vownerEntity);
		System.out.println(entity);

		savedEntity = vehicleDtlsRepo.save(entity);
		if (savedEntity.getVid() != null) {
			msg = "successfully done";
		} else {
			msg = "failed";
		}

		return msg;
	}

	@Override
	public String saveOwnerAddress(OwnerAddressModel address) {
		OwnerAddressEntity oAEntity = null, savedEntity = null;
		String msg = null;
		oAEntity = new OwnerAddressEntity();

		System.out.println("address data " + address);
		// copy model to entity
		BeanUtils.copyProperties(address, oAEntity);
		oAEntity.setVihcleOwnEntity(vownerEntity);
		System.out.println("address entity data " + oAEntity);

		savedEntity = ownerAddRepo.save(oAEntity);
		if (savedEntity.getOaid() != null) {
			msg = "successfully done";
		} else {
			msg = "failed";
		}

		return msg;
	}

	@Override
	public String generateRegistrationNo(VehicleRegistrationNoModel regNoModel) {
		VehicleRegistrationNoEntity entity = null, savedEntity = null;
		String msg = null;
		String regNo=null;
		
		entity = new VehicleRegistrationNoEntity();
		//regNoModel.setRegNo("BCD123");
		regNo=generateRegistrationNumber();
		regNoModel.setRegNo(regNo);
		// copy model to entity
		BeanUtils.copyProperties(regNoModel, entity);
		entity.setVihcleOwnEntity(vownerEntity);
		System.out.println(entity);
		System.out.println(entity.getVihcleOwnEntity().getOid());

		savedEntity = vregiRepo.save(entity);
		if (savedEntity.getVregid() != null) {
			msg = "VehicleRegistration Number is " + savedEntity.getRegNo();
		} else {
			msg = "failed";
		}
		return msg;
	}

	// methos for restApi
	@Override
	public VehicleSummary getAllDetailsOfVehicleAndOwner(String regNo) {
       // creates objects for entity classes
		VehicleSummary vsummery = new VehicleSummary();
		Integer ownerId=null;

		//get OwnerId for all tables
        VehicleRegistrationNoEntity vregForOId=vregiRepo.getOidForRest(regNo);
		System.out.println(vregForOId.getVihcleOwnEntity().getOid());
		ownerId=vregForOId.getVihcleOwnEntity().getOid();
		
		
		//get data from tables
		Optional<VehicleOwnerRegistrationEntity> ownerDtls = OwnerDtlsRepo.findById(ownerId);
		VehicleOwnerRegistrationEntity vownerDtls = ownerDtls.get();

		VehicleDetailsEntity vDtls = vehicleDtlsRepo.getVehicleDeatailsByOidForRest(ownerId);
		OwnerAddressEntity ownAdd = ownerAddRepo.getVehicleOwnerAddDeatailsByOidForRest(ownerId);
		VehicleRegistrationNoEntity vRegNo = vregiRepo.getVehicleRegDeatailsByOidForRest(ownerId);
		
		// set data to vsummey
		/*
		 * vsummery.setFname(vownerDtls.getFname());
		 * vsummery.setLname(vownerDtls.getLname());
		 * vsummery.setEmail(vownerDtls.getEmail());
		 * vsummery.setDob(vownerDtls.getDob()); vsummery.setSsn(vownerDtls.getSsn());
		 * 
		 * 
		 * vsummery.setHno(ownAdd.getHno()); vsummery.setStreetno(ownAdd.getStreetno());
		 * vsummery.setCity(ownAdd.getCity()); vsummery.setZip(ownAdd.getZip());
		 * 
		 * vsummery.setVcompanyname(vDtls.getVcompanyname());
		 * vsummery.setType(vDtls.getType());
		 */
		
		// set data to vsummey
		
		
				vsummery.setOwnerDtls(vownerDtls);
				vsummery.setVhclDtls(vDtls);
				vsummery.setAdrsDtls(ownAdd);
				vsummery.setRegDtls(vRegNo);
				
		return vsummery;
	}


	@Override
	public VehicleOwnerRegistrationEntity getAllVehicleOwnerDetailsById() {
		Optional<VehicleOwnerRegistrationEntity> list = OwnerDtlsRepo.findById(vownerEntity.getOid());
		VehicleOwnerRegistrationEntity vownerDtls =list.get();
		System.out.println(vownerDtls);
		return vownerDtls;
	}

	@Override
	public OwnerAddressEntity getAllOwnerAddressDetailsById() {
		
		return ownerAddRepo.getVehicleOwnerAddDeatailsByOidForRest(vownerEntity.getOid());
	}

	@Override
	public VehicleRegistrationNoEntity getAllRegistrationDetailsById() {
		
		return vregiRepo.getVehicleRegDeatailsByOidForRest(vownerEntity.getOid());
	}

	@Override
	public VehicleDetailsEntity getAllVehicleDetailsById() {
		
		return vehicleDtlsRepo.getVehicleDeatailsByOidForRest(vownerEntity.getOid());
	}
	public static String generateRegistrationNumber() {
		Random random = new Random();
		int initial_2 = random.nextInt(100);
		System.out.println(initial_2);
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String randomString = "";

		char[] text = new char[4];
		for (int i = 0; i < 4; i++) {
		text[i] = chars.charAt(random.nextInt(chars.length()));
		}
		for (int i = 0; i < text.length; i++) {
		randomString = randomString + text[i];
		}
		System.out.print(randomString);
		int last_3 = random.nextInt(1000);
		System.out.println(last_3);
		String RegistrationNumber = initial_2 + randomString + last_3;
		System.out.println(RegistrationNumber);
		return RegistrationNumber;
		}

		
}
