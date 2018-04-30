package com.asher.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.asher.domain.Customer;
import com.asher.utils.C3P0Util;

public class CustomerDao {
	private QueryRunner query = new QueryRunner(C3P0Util.getDataSource());

	/**
	 * 添加客户
	 * 
	 * @param customer
	 * @throws SQLException
	 */
	public void addCustomer(Customer customer) throws SQLException {
		String sql = "insert into customer(name,gender,phone,email,description) values (?,?,?,?,?)";
		query.update(sql, customer.getName(), customer.getGender(), customer.getPhone(), customer.getEmail(),
				customer.getDescription());
	}

	/**
	 * 查询所有客户
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Customer> selectAll() throws SQLException {
		String sql = "select * from customer";
		return query.query(sql, new BeanListHandler<Customer>(Customer.class));
	}

	/**
	 * 根据id查询客户
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Customer selectCustomerById(int id) throws SQLException {
		String sql = "select * from customer where id=?";
		return query.query(sql, new BeanHandler<Customer>(Customer.class), id);
	}

	/**
	 * 删除客户
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public void deleteCustomer(int id) throws SQLException {
		String sql = "delete from customer where id=?";
		query.update(sql, id);
	}
	/**
	 * 修改客户信息
	 * @param customer
	 * @throws SQLException
	 */
	public void updateCustomer(Customer customer) throws SQLException {
		String sql = "update customer set name=?,gender=?,phone=?,email=?,description=? where id=?";
		query.update(sql, customer.getName(), customer.getGender(), customer.getPhone(), customer.getEmail(),
				customer.getDescription(), customer.getId());
	}
	/**
	 * 多条件查询客户
	 * @param name
	 * @param gender
	 * @param phone
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public List<Customer> selectCustomers(String name, String gender, String phone, String email) throws SQLException {
		String sql = "select * from customer where 1=1";
		List params = new ArrayList();
		if(name!=null && !"".equals(name.trim())){
			sql+=" and name like ?"; 
			params.add("%"+name.trim()+"%");
		}
		if(gender!=null && !"".equals(gender.trim())){
			sql+=" and gender=?"; 
			params.add(gender);
		}
		if(phone!=null && !"".equals(phone.trim())){
			sql+=" and phone like ?"; 
			params.add("%"+phone.trim()+"%");
		}
		if(email!=null && !"".equals(email.trim())){
			sql+=" and email like ?"; 
			params.add("%"+email.trim()+"%");
		}
		return query.query(sql, new BeanListHandler<Customer>(Customer.class), params.toArray());
	}

}
