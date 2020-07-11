package com.jsfProject.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.jsfProject.dao.Dao;
import com.jsfProject.type.About;
import com.jsfProject.type.Consumer;
import com.jsfProject.type.Country;
import com.jsfProject.type.Customer;
import com.sun.org.apache.regexp.internal.recompile;

@ManagedBean(name ="user")
@SessionScoped
public class MangedBean {
	private Customer cons;
	private List<Customer> customerList;
	private List<Customer> customers;
	private Customer cons2;

	private Country country;
	private List<Country> CountryList;

	public MangedBean() {
		loadSampleData();

	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public Customer getCons2() {
		return cons2;
	}

	public void setCons2(Customer cons2) {
		this.cons2 = cons2;
	}

	public Customer getCons() {
		return cons;
	}

	public void setCons(Customer cons) {
		this.cons = cons;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Country> getCountryList() {
		return CountryList;
	}

	public void setCountryList(List<Country> countryList) {
		CountryList = countryList;
	}

	//////////////// Insert Customer//////////////////////

	public void add() throws Exception {
		Dao.getInstance().insert(cons);

	}

	//////////////// Update Customer//////////////////////

	public void update() throws Exception {
		Dao.getInstance().update(cons);
	}

	//////////////// Delete Customer//////////////////////

	public void delete() throws Exception {
		Dao.getInstance().delete(cons);

	}

//	//////////////// Get All Customer//////////////////////
//
//	public void loadAllData() throws Exception {
//		customerList = Dao.getInstance().GetAllData();
//
//	}
//	//////////////// Get Customer//////////////////////
//
//	public void loadDataById() throws Exception {
//		cons2 = Dao.getInstance().getCustomerById(cons.getCustomer_id());
//
//	}

	///////////////// Get All Country /////////////////////
	public List<Customer> getAllCountry() throws Exception {

		CountryList = Dao.getInstance().get_All_Country();
		return customerList;

	}
	public void loadSampleData() {
		customers = new ArrayList<>();
		
		customers.add(new Customer("Mary", "StreetA", "1236","Jordan","Amman"));
		customers.add(new Customer("John", "StreetB", "1478","Jordan","AlKarak"));
		customers.add(new Customer("Ajay", "StreetC", "2559","Jordan","Irbid"));
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

}