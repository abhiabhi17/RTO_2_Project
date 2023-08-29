package com.rto.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class AppExceptions {

	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Model model)
	{
		model.addAttribute("errMsg", "No Data Found With that Record !! Please Enter Valid Vehicle RegistrationNumber");
		return "error";
		
	}
}
