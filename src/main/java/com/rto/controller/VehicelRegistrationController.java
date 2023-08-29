package com.rto.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rto.constants.AppConstants;
import com.rto.entity.OwnerAddressEntity;
import com.rto.entity.VehicleDetailsEntity;
import com.rto.entity.VehicleOwnerRegistrationEntity;
import com.rto.entity.VehicleRegistrationNoEntity;
import com.rto.model.VehicleRegistrationNoModel;
import com.rto.service.RtoServiceMgmt;


/*vehicle  register controller is used to
 * 
 *  register owner register details
 *  */
@Controller
public class VehicelRegistrationController{

	final static Logger Log = Logger.getLogger(VehicelRegistrationController.class);
	@Autowired
	private RtoServiceMgmt service;
	

/*vehicle  register controller is used to
 * 
 *  register display register details
 *  */
	
	@RequestMapping(value= AppConstants.REG_NO,method=RequestMethod.POST)
	public String showForm(Model model,@ModelAttribute("regNo") VehicleRegistrationNoModel regiModel) {
		Log.info(" register form  method loaded ");
		return "GenerateRegNo";
	}
	

/*method is for is used to
 * 
 *  generate vehicle no
 *  */
	@RequestMapping(value= AppConstants.GEN_REPORT_URL,method=RequestMethod.POST)
	public String showRegisterForm(Model model,@ModelAttribute("regNo") VehicleRegistrationNoModel regiModel) {
		VehicleOwnerRegistrationEntity voEntity=null;
		VehicleRegistrationNoEntity listForReg=null;
		VehicleDetailsEntity listForVehicle=null;
		OwnerAddressEntity listForAdd=null;
		//use service
		String result=service.generateRegistrationNo(regiModel);
		
		//get data from service
		voEntity=service.getAllVehicleOwnerDetailsById();
		listForVehicle=service.getAllVehicleDetailsById();
		listForAdd=service.getAllOwnerAddressDetailsById();
		listForReg=service.getAllRegistrationDetailsById();
		
		model.addAttribute("msg",result);
		model.addAttribute("Vowner",voEntity);
		model.addAttribute("listForAdd",listForAdd);
		model.addAttribute("listForReg",listForReg);
		model.addAttribute("listForVehicle",listForVehicle);
		
		return AppConstants.VEHCLE_SUMMARY;
	}
}
