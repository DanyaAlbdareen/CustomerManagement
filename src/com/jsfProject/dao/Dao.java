package com.jsfProject.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import com.jsfProject.util.LoadConfig;
import com.jsfProject.handler.ConnectionHandler;
import com.jsfProject.type.About;
import com.jsfProject.type.Consumer;
import com.jsfProject.type.Country;
import com.jsfProject.type.Customer;

public class Dao {

	private static Dao user;

	private Dao() {
	}

	// من خلال هاد الميثود رح يعمل new obj
	// singleton design pattern in java
	public static Dao getInstance() {
		if (user == null) {
			user = new Dao();
		}
		return user;

	}

	
//	///////////// Get All Customer Data ////////////////////
//	public List<Customer> GetAllData() throws Exception {
//		List<Customer> custom = null;
//		Customer cont = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet rs = null;
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			ConnectionHandler handler = new ConnectionHandler();
//			try {
//
//				Connection con = handler.getConnection();
//				String query = "select * from customer inner join country on customer.country_id=country.country_id\r\n"
//						+ "inner join city on country.country_id = city.city_id;";
//
//				preparedStatement = con.prepareStatement(query);
//				rs = preparedStatement.executeQuery();
//
//				System.out.println(preparedStatement.toString());
//
//				while (rs.next()) {
//					cont = new Customer();
//					cont.setCustomer_id(rs.getString("customer_id"));
//					cont.setCustomer_name(rs.getString("customer_name"));
//					cont.setAddress(rs.getString("address"));
//					cont.setTax_number(rs.getString("tax_number"));
//					cont.setActive(rs.getString("active"));
//					cont.setLogo(rs.getString("logo"));
//					cont.setCountry_name(rs.getString("country_name"));
//					cont.setCity_name(rs.getString("city_name"));
//					custom = new ArrayList<>();
//					custom.add(cont);
//				}
//
//				handler.closeConnection(con);
//			} // end try
//
//			catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				System.out.println("PreparedStatement : ");
//				e.printStackTrace();
//			}
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("Class.forName : ");
//			e.printStackTrace();
//		}
//
//		return custom;
//	}

	////////////////////// Add Customer Data///////////////////////////////
	public int insert(Customer cons) throws Exception {

		int row = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ConnectionHandler handler = new ConnectionHandler();
			try {

				con = handler.getConnection();
				PreparedStatement preparedStatement = null;

				String query = "INSERT INTO customer\r\n"
						+ "(customer_name,address,tax_number,active,logo,country_id)VALUES(?,?,?,?,?,?);";

				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, cons.getCustomer_name());
				preparedStatement.setString(2, cons.getAddress());
				preparedStatement.setString(3, cons.getTax_number());
				preparedStatement.setString(4, cons.getLogo());
				preparedStatement.setString(5, cons.getCountry_id());
				row = preparedStatement.executeUpdate();
				System.out.println(preparedStatement.toString());

				handler.closeConnection(con);

			} catch (SQLException e) {
				System.out.println("PreparedStatement");
				e.printStackTrace();
			}

		} catch (

		ClassNotFoundException e) {
			System.out.println("Class.forName");
			e.printStackTrace();
		}
		return row;

	}

	/////////////////// Update Customer Data///////////////////////////////////
	public int update(Customer cons) throws Exception {

		int row = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ConnectionHandler handler = new ConnectionHandler();
			try {

				con = handler.getConnection();
				PreparedStatement preparedStatement = null;

				String query = "UPDATE customer\r\n" + "SET\r\n" + "customer_name =?,\r\n" + "address =?,\r\n"
						+ "tax_number =?,\r\n" + "active =?,\r\n" + "logo =?,\r\n" + "country_id =?\r\n"
						+ "WHERE customer_id =?;\r\n" + "";

				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, cons.getCustomer_name());
				preparedStatement.setString(2, cons.getAddress());
				preparedStatement.setString(3, cons.getTax_number());
				preparedStatement.setString(4, cons.getActive());
				preparedStatement.setString(5, cons.getLogo());
				preparedStatement.setString(6, cons.getCountry_id());
				preparedStatement.setString(7, cons.getCustomer_id());

				row = preparedStatement.executeUpdate();

				System.out.println(preparedStatement.toString());

				handler.closeConnection(con);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("PreparedStatement");
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName");
			e.printStackTrace();
		}
		return row;
	}

	public int delete(Customer cons) {
		int check = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ConnectionHandler handler = new ConnectionHandler();
			try {

				con = handler.getConnection();
				PreparedStatement preparedStatement = null;

				String query = "DELETE FROM customer WHERE customer_id = ?;\r\n" + "";

				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, cons.getCustomer_id());
				check = preparedStatement.executeUpdate();
				System.out.println(preparedStatement.toString());

				handler.closeConnection(con);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("PreparedStatement");
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName");
			e.printStackTrace();
		}
		return check;
	}
	/////////////////// get All Country //////////////////

	public List<Country> get_All_Country() throws Exception {

		List<Country> country = null;
		Country cont = null;

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		String query = "SELECT * FROM country";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			ConnectionHandler handler = new ConnectionHandler();
			try {

				Connection con = handler.getConnection();
				preparedStatement = con.prepareStatement(query);
				rs = preparedStatement.executeQuery();
				System.out.println(preparedStatement.toString());

				while (rs.next()) {
					cont = new Country();
					country = new ArrayList<>();
					cont.setCountry_id(rs.getString("country_id"));
					cont.setCountry_name(rs.getString("country_name_en"));
					country.add(cont);
				}

				handler.closeConnection(con);
			} // end try

			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("PreparedStatement");
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName");
			e.printStackTrace();
		}

		return country;
	}
//	/////////////////// get Customer Details //////////////////
//
//	public Customer getCustomerById(String customer_id) throws Exception {
//
//		Customer cont = null;
//
//		PreparedStatement preparedStatement = null;
//		ResultSet rs = null;
//
//		String query = "select * from customer inner join country on customer.country_id=country.country_id\r\n"
//				+ "inner join city on country.country_id = city.city_id where customer_id =?";
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			ConnectionHandler handler = new ConnectionHandler();
//			try {
//
//				Connection con = handler.getConnection();
//				preparedStatement = con.prepareStatement(query);
//				preparedStatement.setString(1, customer_id);
//				rs = preparedStatement.executeQuery();
//
//				System.out.println(preparedStatement.toString());
//
//				while (rs.next()) {
//					cont = new Customer();
//					cont.setCustomer_id(rs.getString("customer_id"));
//					cont.setCustomer_name(rs.getString("customer_name"));
//					cont.setAddress(rs.getString("address"));
//					cont.setTax_number(rs.getString("tax_number"));
//					cont.setActive(rs.getString("active"));
//					cont.setLogo(rs.getString("logo"));
//					cont.setCountry_name(rs.getString("country_name"));
//					cont.setCity_name(rs.getString("city_name"));
//
//				}
//				handler.closeConnection(con);
//			} // end try
//			catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				System.out.println("PreparedStatement");
//				e.printStackTrace();
//			}
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("Class.forName");
//			e.printStackTrace();
//		}
//		return cont;
//	}

}
