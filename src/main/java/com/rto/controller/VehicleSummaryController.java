package com.rto.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rto.repo.RtoOwnerDtlsRepository;
import com.rto.repo.RtoRepoOAddress;
import com.rto.repo.RtoRepoVDetails;
import com.rto.repo.RtoRepoVRegistration;


/*for displaying vehicle summary */
public class VehicleSummaryController {


	final static Logger Log = Logger.getLogger(VehicleSummaryController.class);
	@Autowired
	private RtoOwnerDtlsRepository OwnerDtlsRepo;
	
	@Autowired
	private RtoRepoVDetails vehicleDtlsRepo;
	
	@Autowired
	private RtoRepoOAddress ownerAddRepo;
	
	@Autowired
	private RtoRepoVRegistration vregiRepo;
	
	
	//@RequestMapping(value= "/sendVSummary",method=RequestMethod.GET)
	
}
