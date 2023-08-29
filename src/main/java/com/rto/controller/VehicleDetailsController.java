package com.rto.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rto.constants.AppConstants;
import com.rto.model.VehicleDetailsModel;
import com.rto.service.RtoServiceMgmt;



/*vehicle  Details controller is used to
 * 
 *  register owner register details
 *  */
@Controller
public class VehicleDetailsController {

	final static Logger Log = Logger.getLogger(VehicleDetailsController.class);
	@Autowired
	private RtoServiceMgmt service;
	
	@RequestMapping(value= AppConstants.VEHCLE_DTLS_URL,method=RequestMethod.GET)
	public String showForm(Model model) {
		VehicleDetailsModel vDmodel=new VehicleDetailsModel();
		//type select box
		typeList(model);
		model.addAttribute("VehicleDetailsModel",vDmodel);
		return AppConstants.DSPLY_VHCLE_DTLS;
	}

	/* used to display 
	 * registraton form */
	@RequestMapping(value=AppConstants.REG_DTLS,method=RequestMethod.POST)
	public String showRegisterForm(Model model,@ModelAttribute("vdetails") VehicleDetailsModel vehicle) {
		//use service
		
		Log.info(" register form  method loaded ");
		
		String result=service.saveVehicleDetails(vehicle);
		
		//model.addAttribute("Rmsg",result);
		return "forward:/ownerAddress";
	}
	
	public String typeList(Model model){
		List<String> typeList=new ArrayList();
		typeList.add("2 Wheeler");
		typeList.add("4 Wheeler");
		typeList.add("8 Wheeler");
		typeList.add("Lodded vehicles");
		model.addAttribute("typeList",typeList);
		return AppConstants.DSPLY_VHCLE_DTLS;
	}
	
}
