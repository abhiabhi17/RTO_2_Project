package com.rto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rto.model.VehicleSummary;
import com.rto.service.RtoServiceMgmt;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;




/*vehicle  rest controller is used to
 * 
 *  register owner register details
 *  */
@RestController
@Api("this is welcome Controller")
public class VehicleRestController {
	
	@Autowired
	private RtoServiceMgmt service;
	
	/*
	 * @GetMapping(value="/getVehicleSummary", produces = {
	 * 
	 * "application/xml", "application/json" } )
	 */
	@GetMapping(value="/getVehicleSummary",produces= {"application/json","application/xml"})
	@ApiOperation("Method descrpition")
	@ApiResponse(response = VehicleSummary.class, code = 200, message = "String value")
	public VehicleSummary getAllDetailsOfVehicleAndOwner(
			                   @RequestParam("regNo") String regNo
			                   ){
		//use service class object
		return service.getAllDetailsOfVehicleAndOwner(regNo);
	}
	

	
}
