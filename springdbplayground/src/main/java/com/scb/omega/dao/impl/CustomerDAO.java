package com.scb.omega.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.scb.omega.dao.ICustomerDAO;
import com.scb.omega.entities.Customer;
import com.scb.omega.utils.Status;

@Repository
public class CustomerDAO implements ICustomerDAO {

	@Autowired
	JdbcTemplate template;
	
	@Override
	public String addCustomer(Customer c) {
		String status="";
		try
		{
			String query="Insert into customer_scb(name,email,phone,active,birthday) values (?,?,?,?,?);";
			int rowInserted=template.update(query, c.getName(), c.getEmail(), c.getPhone(), c.isActive(), c.getBirthday());
			
			if(rowInserted==1)
			{
				status=Status.SUCCESS;
			}
			else {
				status=Status.NOT_FOUND;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String updateCustomer(Customer c, int id) {
		String status="";
		try
		{
			String query="Update customer_scb set name=?,email=?,phone=?,active=?,birthday=? where id=?;";
			int rowUpdated=template.update(query, c.getName(), c.getEmail(), c.getPhone(), c.isActive(), c.getBirthday());
			
			if(rowUpdated==1)
			{
				status=Status.SUCCESS;
			}
			else {
				status=Status.NOT_FOUND;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteCustomer(int id) {
		String status="";
		try
		{
			String query="Delete from customer_scb where id=?;";
			int rowDeleted=template.update(query, id);
			
			if(rowDeleted==1)
			{
				status=Status.SUCCESS;
			}
			else {
				status=Status.NOT_FOUND;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
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
