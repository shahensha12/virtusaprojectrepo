package org.virtusa.numbertowords.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.virtusa.numbertowords.service.NumberToWordService;

@RestController
@RequestMapping(value="numbertowordmapping",produces= {MediaType.APPLICATION_JSON_VALUE})
public class NumberToWordController  {
	
	@Autowired
	NumberToWordService numbertowordservice;
	
	@GetMapping(value = "{number}")
    public String numberToWord(@PathVariable("number") String number)   {
		if(number.equals("null")) {
			throw new NullPointerException();
		}else {
		return numbertowordservice.getNumberToWord(number);
		}
    }
		
	@ExceptionHandler(NumberFormatException.class)
	public String exceptionHandler(NumberFormatException n) {
		
		return "Enter value in valid Number Format";
	}
	@ExceptionHandler(NullPointerException.class)
	public String nullexceptionHandler(NullPointerException n) {
		
		return "null value";
	}
	
    @GetMapping
    public String health() {
        return "alive";
    }
}
