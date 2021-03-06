package com.scb.omega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.omega.entities.Customer;
import com.scb.omega.service.ICustomerService;
import com.scb.omega.utils.Status;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController 
{
	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity addCustomer(@RequestBody Customer c)
	{
		ResponseEntity response=null;
		String result=customerService.addCustomer(c);
		
		if(result.equals(Status.SUCCESS))
		{
			response= new ResponseEntity<>(HttpStatus.CREATED);
		}
		else
		{
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	@PutMapping("/customer/{id}")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer c, @PathVariable int id)
	{
		ResponseEntity<Object> response=null;
		String result=customerService.updateCustomer(c, id);
		
		if(result.equals(Status.SUCCESS))
		{
			response= new ResponseEntity<>(HttpStatus.CREATED);
		}
		else
		{
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	@DeleteMapping("/customer/{id}")
	public ResponseEntity deleteCustomer(@PathVariable int id)
	{
		ResponseEntity response=null;
		String result=customerService.deleteCustomer(id);
		
		if(result.equals(Status.SUCCESS))
		{
			response= new ResponseEntity<>(HttpStatus.CREATED);
		}
		else
		{
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
}
