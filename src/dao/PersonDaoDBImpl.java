package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



import model.Person;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PersonDaoDBImpl implements PersonDao {
	private DataSource ds;
	private String getByIdSQL = "SELECT * from person where id=?",
				getAllSQL = "SELECT * from person",
				deleteSQL = "DELETE from person where id=?" ,
				insertSQL = "INSERT into person(id,firstName,lastName,email,age) values (UUID(),?,?,?,?)" ,
				updateSQL = "UPDATE person set firstName=?,lastName=?,email=?,age=? where id=?";
	Log log = LogFactory.getLog(PersonDaoDBImpl.class);
	
	public PersonDaoDBImpl() throws Exception{
		try{
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/SimpleSpring");			
		}catch (NamingException e){
			throw new Exception("cannot find database");
		}catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Person> getAllPerson() {
		Connection conn=null;PreparedStatement ps=null;ResultSet rs=null;
		List<Person> products = new ArrayList<Person>();
		try{
			conn =ds.getConnection();
			ps = conn.prepareStatement(getAllSQL);
			rs = ps.executeQuery();
			while(rs.next()){
				products.add(new Person(rs.getString("firstName"),
									rs.getString("lastName"),
									rs.getString("email"),
									rs.getInt("age"),
									rs.getString("id")));
			}
			return products;
		}catch (Exception e){
			e.printStackTrace();
			log.error("does not get person!");
			return null;
		}finally{
			try {
				if (rs!=null){rs.close();}
				if (ps!=null){ps.close();}
				if (conn!=null){conn.close();}
			} catch (SQLException e) {
				log.error("can not close resource "+e.getMessage());
			}
		}
	}

	@Override
	public void addPerson(Person p) {
		Connection conn=null;PreparedStatement ps=null;
		try{
			conn = ds.getConnection();
			ps = conn.prepareStatement(insertSQL);
			ps.setString(1, p.getFirstName());
			ps.setString(2, p.getLastName());
			ps.setString(3, p.getEmail());
			ps.setInt(4, p.getAge());
			ps.executeUpdate();
		}
		catch(SQLException e){
			log.error("can not insert person " + p);
		}finally{
			try {
				if (ps!=null){ps.close();}
				if (conn!=null){conn.close();}
			} catch (SQLException e) {
				log.error("can not close resource "+e.getMessage());
			}
		}
	}

	@Override
	public Person getPersonById(String personId) {
		Connection conn=null;PreparedStatement ps=null;ResultSet rs=null;
		try{
			conn = ds.getConnection();
			ps = conn.prepareStatement(getByIdSQL);
			ps.setString(1, personId);
			rs = ps.executeQuery();
			Person p = null;
			if (rs.next()){
				p = new Person(rs.getString("firstName"),
										rs.getString("lastName"),
										rs.getString("email"),
										rs.getInt("age"),
										personId);
			}
			return p;
		}catch (SQLException e){
			return null;
		}finally{
			try {
				if (rs!=null){rs.close();}
				if (ps!=null){ps.close();}
				if (conn!=null){conn.close();}
			} catch (SQLException e) {
				log.error("can not close resource "+e.getMessage());
			}
		}
	}

	@Override
	public void updatePerson(Person p) {
		Connection conn=null;PreparedStatement ps=null;
		try{
			conn = ds.getConnection();
			ps = conn.prepareStatement(updateSQL);
			ps.setString(1, p.getFirstName());
			ps.setString(2, p.getLastName());
			ps.setString(3, p.getEmail());
			ps.setInt(4, p.getAge());
			ps.setString(5, p.getId());
			ps.executeUpdate();
		}
		catch(SQLException e){
			log.error("can not update person " + p);
		}finally{
			try {
				if (ps!=null){ps.close();}
				if (conn!=null){conn.close();}
			} catch (SQLException e) {
				log.error("can not close resource "+e.getMessage());
			}
		}
		
	}

	@Override
	public void deletePerson(String personId) {
		Connection conn=null;PreparedStatement ps=null;
		try{
			conn = ds.getConnection();
			ps = conn.prepareStatement(deleteSQL);
			ps.setString(1, personId);
			ps.executeUpdate();
		}
		catch(SQLException e){
			log.error("can not delete person " +personId);
		}finally{
			try {
				if (ps!=null){ps.close();}
				if (conn!=null){conn.close();}
			} catch (SQLException e) {
				log.error("can not close resource "+e.getMessage());
			}
		}
		
	}


}
