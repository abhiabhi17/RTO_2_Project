package com.rto.controller;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rto.constants.AppConstants;
import com.rto.model.OwnerAddressModel;
import com.rto.service.RtoServiceMgmt;


/*owner address controller is used to
 * 
 *  register owner adress details
 *  */
@Controller
public class OwnerAddressController {

	
	final static Logger Log = Logger.getLogger(OwnerAddressController.class); // NOPMD by pc on 1/11/19 12:34 PM
	
	@Autowired
	private RtoServiceMgmt service;
	

/*owner address controller is used to
 * 
 *  display  owner adress details
 *  */
	@RequestMapping(value= "/ownerAddress",method=RequestMethod.POST)
	public String showForm(Model model,@ModelAttribute("ownerAdd") OwnerAddressModel ownerAdd) {
	//	VehicleDetailsModel vDmodel=new VehicleDetailsModel();
		//type select box
	//	model.addAttribute("VehicleDetailsModel",vDmodel);
		
		Log.info("#------------------ register vehicle form loaded --------------------#");
		return AppConstants.OWNR_DTLS;
	}
	

	
	
/*owner address controller is used to
 * 
 *  register owner adress details
 *  */
	@RequestMapping(value= "/ownerAddresPost",method=RequestMethod.POST)
	public String showRegisterForm(Model model,@ModelAttribute("ownerAdd") OwnerAddressModel address) {
		
     Log.info(" register vehicle method ");
		//use service
		String result=service.saveOwnerAddress(address);
		model.addAttribute("msg",result);
		//return "OwnerAddress";
		return "forward:/genRegNo";
	}
	
	
}
