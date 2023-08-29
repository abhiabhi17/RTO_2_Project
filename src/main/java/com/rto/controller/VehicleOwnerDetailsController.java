package com.rto.controller;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rto.constants.AppConstants;
import com.rto.model.VehicleOwnerRegistrationModel;
import com.rto.service.RtoServiceMgmt;

/*vehicle  owner details controller is used to
 * 
 *  register owner register details
 *  */
@Controller
public class VehicleOwnerDetailsController {


	final static Logger Log = Logger.getLogger(VehicleOwnerDetailsController.class);
	@Autowired
	private RtoServiceMgmt service;
	
	@RequestMapping(value=AppConstants.REQ_URL,method=RequestMethod.GET)
	public String showForm(Model model) {
		VehicleOwnerRegistrationModel vomodel=new VehicleOwnerRegistrationModel();
		
		model.addAttribute("owner",vomodel);
		/* return "VehicleOwnerDetails"; */
		return AppConstants.VEHCLE_OWNER_DTLS;
	}
	
	
	/* this method for registering owner form */
	
	@RequestMapping(value= AppConstants.OWNER_URL ,method=RequestMethod.POST)
	public String registerForm(Model model,@ModelAttribute("owner") VehicleOwnerRegistrationModel owner) {
		//user service
		String result=service.saveVehicleOwnerDetails(owner);
		
		model.addAttribute("msg",result);
	    return "redirect:/vdetails";
	}
}
