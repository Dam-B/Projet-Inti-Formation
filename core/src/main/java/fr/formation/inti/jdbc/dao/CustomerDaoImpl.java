package fr.formation.inti.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.inti.entities.Customer;
import fr.formation.inti.utils.ConnectionUtils;
import fr.formation.inti.utils.SqlRequest;

/**
 * CustomerDaoImpl
 * @author pc
 * 07/12/2019
 */
public class CustomerDaoImpl implements CustomerDao{

	@Override
	public Integer create(Customer c) {
		
		Integer idCustomer = null;
		try(Connection con = ConnectionUtils.getConnection()){
		
		PreparedStatement pstm = con.prepareStatement(SqlRequest.INSERT_CUSTOMER,
				Statement.RETURN_GENERATED_KEYS);
		pstm.setString(1, c.getAdress());
		pstm.setString(2, c.getCity());
		pstm.setString(3, c.getCustTypeCd());
		pstm.setString(4, c.getFedId());
		pstm.setString(5, c.getPostalCode());
		pstm.setString(6, c.getState());
		Integer rowAffected = pstm.executeUpdate();
		if(rowAffected == 0)
			throw new SQLException("Insert failed");
		
		try(ResultSet rs = pstm.getGeneratedKeys()){
			if(rs.next())
				idCustomer = rs.getInt(1);
		}
		}catch(SQLException e) {
			System.out.println("Erreur SQl ");
			e.printStackTrace();
		}
		
		return idCustomer;
	}

	@Override
	public void update(Customer c) {
		
	}

	@Override
	public void delete(Customer c) {
		
	}

	@Override
	public void delete(Integer id) {
		
	}

	@Override
	public Customer getById(Integer id) {
		Customer c = null ;
		try(Connection con = ConnectionUtils.getConnection()){
			PreparedStatement stm = con.prepareStatement(SqlRequest.SELECT_CUSTOMER_BY_ID);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				c = new Customer();
				c.setCustId(rs.getInt(1));
				c.setAdress(rs.getString(2));
				c.setCity(rs.getString(3));
				c.setCustTypeCd(rs.getString(4));
				c.setFedId(rs.getString(5));
				c.setPostalCode(rs.getString(6));
				c.setState(rs.getString(7));				
			}
		}catch(SQLException e) {
			System.out.println("Erreur SQl ");
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public List<Customer> getAll() {
		List<Customer> customers = new ArrayList<Customer>();
		Customer c;
		try(Connection con = ConnectionUtils.getConnection()){
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(SqlRequest.SELECT_CUSTOMER);
			while(rs.next()) {
				c = new Customer();
				c.setCustId(rs.getInt(1));
				c.setAdress(rs.getString(2));
				c.setCity(rs.getString(3));
				c.setCustTypeCd(rs.getString(4));
				c.setFedId(rs.getString(5));
				c.setPostalCode(rs.getString(6));
				c.setState(rs.getString(7));
				customers.add(c);
			}
		}catch(SQLException e) {
			System.out.println("Erreur SQl ");
			e.printStackTrace();
		}
		return customers;
	}

	

	@Override
	public boolean isManaged(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

}
