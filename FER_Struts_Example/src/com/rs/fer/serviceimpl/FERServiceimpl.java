package com.rs.fer.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.util.DBUtil;

/** testing  thr git hub  for practice **/ 
// SECOND TESTING 

//THIRED TESTING SHIVA KRISHNA

public class FERServiceimpl implements FERService {
//shiva 
	@Override
	public boolean registration(User user) {

		boolean isRegister = false;

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"INSERT INTO USER(firstname,middlename,lastname,username,password,email,mobile) values(?,?,?,?,?,?,?)");

			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getMiddlename());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getUsername());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getEmail());
			statement.setString(7, user.getMobile());

			int numberofRecAffected = statement.executeUpdate();
			System.out.println("numberofRecAffecterd=" + numberofRecAffected);
			isRegister = numberofRecAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return isRegister;
	}

	@Override
	public int login(String username, String password) {
		int id=0;
		Connection connection = null;
		PreparedStatement statement = null;
		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("SELECT * FROM USER where username=? and password=?");
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				id= resultSet.getInt("id");
			
				System.out.println("no match is found ");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}
		return id;
	}

	@Override
	public boolean addExpense(Expense expense) {

		boolean isAdded = false;

		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"INSERT INTO expense(type,date,price,numberofiteams,total,bywhom,userid) values(?,?,?,?,?,?,?)");

			
			statement.setString(1, expense.getType());
			statement.setString(2, expense.getDate());
			statement.setFloat(3, expense.getPrice());
			statement.setInt(4, expense.getNumberOfIteams());
			statement.setFloat(5, expense.getTotal());
			statement.setString(6, expense.getBywhom());
			statement.setInt(7, expense.getUserid());

			int numberofRecAffected = statement.executeUpdate();
			System.out.println("numberofRecAffecterd=" + numberofRecAffected);
			isAdded = numberofRecAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}
		return isAdded;
	}

	@Override
	public boolean editExpense(Expense expense) {

		boolean isEdited = false;

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"UPDATE expense SET type=?,date=?,price=?,numberofiteams=?,total=?,bywhom=?  where  Id=?");
			statement.setString(1, expense.getType());
			statement.setString(2, expense.getDate());
			statement.setFloat(3, expense.getPrice());
			statement.setInt(4, expense.getNumberOfIteams());
			statement.setFloat(5, expense.getTotal());
			statement.setString(6, expense.getBywhom());
			statement.setInt(7, expense.getId());

			int numberofRecAffected = statement.executeUpdate();
			System.out.println("numberofRecAffecterd=" + numberofRecAffected);
			isEdited = numberofRecAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}
		return isEdited;

	}

	@Override
	public boolean deleteExpense(int expenseId) {

		boolean isDeleted = false;

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("DELETE FROM expense    Where id=?");

			statement.setInt(1, expenseId);

			int numberofRecAffected = statement.executeUpdate();
			System.out.println("numberofRecAffecterd=" + numberofRecAffected);
			isDeleted = numberofRecAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}
		return isDeleted;

	}

	@Override
	public boolean resetPassword(int id, String currentPassword, String newPassword) {

		boolean isResetPassword = false;

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("UPDATE USER SET  password=? where   password=? and id=?");

			statement.setString(1, newPassword);
			statement.setString(2, currentPassword);
			statement.setInt(3, id);

			int numberofRecAffected = statement.executeUpdate();

			isResetPassword = numberofRecAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}
		return isResetPassword;
	}

	@Override
	public Expense getExpense(int expenseId) {

		Connection connection = null;
		PreparedStatement statement = null;
		Expense expense = new Expense();
		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("SELECT*FROM expense where id=?");
			statement.setInt(1, expenseId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				expense = new Expense();
				expense.setId(resultSet.getInt("id"));
				expense.setType(resultSet.getString("type"));
				expense.setDate(resultSet.getString("date"));
				expense.setPrice(resultSet.getFloat("price"));
				expense.setNumberOfIteams(resultSet.getInt("numberofiteams"));
				expense.setTotal(resultSet.getFloat("total"));
				expense.setBywhom(resultSet.getString("bywhom"));

				System.out.println(
						resultSet.getInt("id") + "," + resultSet.getString("type") + "," + resultSet.getString("date")
								+ "," + resultSet.getFloat("price") + "," + resultSet.getInt("numberofiteams") + ","
								+ resultSet.getFloat("total") + "," + resultSet.getString("bywhom"));

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}
		return expense;

	}

	@Override
	public List<Expense> getExpenses(int userid) {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Expense> expenses = new ArrayList<Expense>();

		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("SELECT * FROM expense where userId=?");
			statement.setInt(1, userid);
			ResultSet resultSet = statement.executeQuery();
			Expense expense = null;

			while (resultSet.next()) {

				expense = new Expense();
				
				expense.setId(resultSet.getInt("id"));
				expense.setType(resultSet.getString("type"));
				expense.setDate(resultSet.getString("date"));
				expense.setPrice(resultSet.getFloat("price"));
				expense.setNumberOfIteams(resultSet.getInt("numberofiteams"));
				expense.setTotal(resultSet.getFloat("total"));
				expense.setBywhom(resultSet.getString("bywhom"));
				expenses.add(expense);
				System.out.println(
						resultSet.getInt("id") + "," + resultSet.getString("type") + "," + resultSet.getString("date")
								+ "," + resultSet.getFloat("price") + "," + resultSet.getInt("numberofiteams") + ","
								+ resultSet.getFloat("total") + "," + resultSet.getString("bywhom"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}
		return expenses;

	}

	@Override
	public List<Expense> getexpensesReport(int userid, String Type, String fromDate, String toDate) {

		Connection connection = null;
		PreparedStatement statement = null;
		List<Expense> expensesReport = new ArrayList<Expense>();

		try {
			connection = DBUtil.getConnection();

			statement = connection
					.prepareStatement("SELECT * FROM expense where userid=? and type=? and Date Between ? and ?");
			statement.setInt(1, userid);
			statement.setString(2, Type);
			statement.setString(3, fromDate);
			statement.setString(4, toDate);

			ResultSet resultSet = statement.executeQuery();
			Expense expense = new Expense();
			while (resultSet.next()) {

				expense.setId(resultSet.getInt("id"));
				expense.setType(resultSet.getString("type"));
				expense.setDate(resultSet.getString("date"));
				expense.setPrice(resultSet.getFloat("price"));
				expense.setNumberOfIteams(resultSet.getInt("numberofiteams"));
				expense.setTotal(resultSet.getFloat("total"));
				expense.setBywhom(resultSet.getString("bywhom"));

				System.out.println(
						resultSet.getInt("id") + "," + resultSet.getString("type") + "," + resultSet.getString("date")
								+ "," + resultSet.getFloat("price") + "," + resultSet.getInt("numberofiteams") + ","
								+ resultSet.getFloat("total") + "," + resultSet.getString("bywhom"));
				expensesReport.add(expense);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}
		return expensesReport;
	}

	@Override
	public User getPersonalInfo(int id) {

		Connection connection = null;
		PreparedStatement statement = null;
		User user = null;
		Address address=null;
		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("SELECT u.*,a.* from user u left join address a on u.id=a.userid  where u.id=?");
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				user=new User();
				user.setId(resultSet.getInt("id"));
				user.setFirstname(resultSet.getString("firstname"));
				user.setMiddlename(resultSet.getString("middlename"));
				user.setLastname(resultSet.getString("lastname"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setMobile(resultSet.getString("mobile"));

				address = new Address();

				address.setUserid(resultSet.getInt("userid"));
				address.setLineOne(resultSet.getString("lineone"));
				address.setLineTwo(resultSet.getString("linetwo"));
				address.setStreet(resultSet.getString("street"));
				address.setCity(resultSet.getString("city"));
				address.setState(resultSet.getString("state"));
				address.setZip(resultSet.getString("zip"));

				user.setAddress(address);
				System.out.println(resultSet.getInt("id") + "," + resultSet.getString("firstname") + ","
						+ resultSet.getString("middlename") + "," + resultSet.getString("lastname") + ","
						+ resultSet.getString("username") + "," + resultSet.getString("password") + ","
						+ resultSet.getString("email") + "," + resultSet.getString("mobile") + ","
						+ resultSet.getString("lineone") + "," + resultSet.getString("linetwo") + ","
						+ resultSet.getString("street") + "," + resultSet.getString("city") + ","
						+ resultSet.getString("state") + "," + resultSet.getString("zip"));
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return user;
	}

	@Override
	public boolean updatePersonalInfo(User user) {
		Connection connection = null;
		PreparedStatement statement = null;
		int updatePersonal = 0;
		boolean isupdatePersonal = true;
		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"UPDATE user SET firstname=?,middlename=?,lastname=?,email=?,mobile=? where id=?");

			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getMiddlename());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getMobile());
			statement.setInt(6, user.getId());

			updatePersonal = statement.executeUpdate();
			System.out.println(updatePersonal + "user record updated");
			Address address = user.getAddress();
			String inputAddress = " ";
			if (updatePersonal > 0) {
           if(address.getId()==0)
				inputAddress = "insert into address (lineone,linetwo,street,city,state,zip,userid) values (?,?,?,?,?,?,?)";
			} else {
				inputAddress = "update address set lineone=?,linetwo=?,street=?,city=?,state=?,zip=? where userid=?";

			}
            statement=connection.prepareStatement(inputAddress);
			statement.setString(1, address.getLineOne());
			statement.setString(2, address.getLineTwo());
			statement.setString(3, address.getStreet());
			statement.setString(4, address.getCity());
			statement.setString(5, address.getState());
			statement.setString(6, address.getZip());
			statement.setInt(7, address.getUserid());
			/*
			 * if(inputAddress.contains("update")) { statement.setInt(7, address.getId());
			 * }else { statement.setInt(7, address.getUserid()); }
			 */
			int addressRegistered = statement.executeUpdate();
			System.out.println(addressRegistered + "address records update");
			isupdatePersonal = addressRegistered > 0;
			System.out.println(user.getFirstname() + "," + user.getMiddlename() + "," + user.getLastname() + ","
					+ user.getEmail() + "," + user.getMobile() + "," + user.getId() + "," + address.getLineOne() + ","
					+ address.getLineTwo() + "," + address.getStreet() + "," + address.getCity() + ","
					+ address.getState() + "," + address.getZip());
			

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return isupdatePersonal;
	}

}
