package com.asher.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.asher.domain.Customer;
import com.asher.service.CustomerService;

public class CustomerServlet extends BaseServlet {
	/**
	 * 添加客户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerService cs = new CustomerService();
		Customer customer = new Customer();
		try {
			BeanUtils.populate(customer, request.getParameterMap());
			cs.addCustomer(customer);
			request.setAttribute("msg", "添加成功！");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	/**
	 * 删除客户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerService cs = new CustomerService();
		try {
			cs.deleteCustomer(id);
			request.setAttribute("msg", "删除成功！");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有客户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		CustomerService cs = new CustomerService();
		try {
			List<Customer> customers = cs.findAll();
			request.setAttribute("cstmlist", customers);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 通过ID查询客户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findCustomerById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerService cs = new CustomerService();
		try {
			Customer customer = cs.findCustomerById(id);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 多条件查询客户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findCustomers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
 		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		CustomerService cs = new CustomerService();
		try {
			List<Customer> list = cs.findCustomers(name,gender,phone,email);
			request.setAttribute("cstmlist", list);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 修改客户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modifyCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerService cs = new CustomerService();
		Customer customer = new Customer();
		try {
			BeanUtils.populate(customer, request.getParameterMap());
			cs.modifyCustomer(customer);
			request.setAttribute("msg", "修改成功！");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
