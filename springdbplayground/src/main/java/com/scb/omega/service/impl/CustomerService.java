package com.scb.omega.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.omega.dao.ICustomerDAO;
import com.scb.omega.entities.Customer;
import com.scb.omega.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	ICustomerDAO customerDAO;
	
	@Override
	public String addCustomer(Customer c) {
		
		String result=customerDAO.addCustomer(c);
		return result;
	}

	@Override
	public String updateCustomer(Customer c, int id) {
		
		String result=customerDAO.updateCustomer(c,id);
		return result;
	}

	@Override
	public String deleteCustomer(int id) {
		String result=customerDAO.deleteCustomer(id);
		return result;
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
