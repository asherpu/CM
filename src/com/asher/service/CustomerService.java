package com.asher.service;

import java.sql.SQLException;
import java.util.List;

import com.asher.dao.CustomerDao;
import com.asher.domain.Customer;

public class CustomerService {
	private CustomerDao cd = new CustomerDao();
	
	public void addCustomer(Customer customer) throws SQLException {
		cd.addCustomer(customer);
	}

	public List<Customer> findAll() throws SQLException {
		return cd.selectAll();
	}

	public Customer findCustomerById(int id) throws SQLException {
		return cd.selectCustomerById(id);
	}

	public void deleteCustomer(int id) throws SQLException {
		cd.deleteCustomer(id);
	}

	public void modifyCustomer(Customer customer) throws SQLException {
		cd.updateCustomer(customer);
	}

	public List<Customer> findCustomers(String name, String gender, String phone, String email) throws SQLException {
		return cd.selectCustomers(name,gender,phone,email);
	}


}
