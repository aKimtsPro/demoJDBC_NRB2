package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.example.demo.entities.Section;
import com.example.demo.exceptions.ElementNotFoundException;

public class SectionDAO {
	
	
	public List<Section> getAll(){
		
		String query = "SELECT * FROM section";
		List<Section> list = new ArrayList<>();

		try ( 
				Connection co = ConnectionFactory.getConnection();
				Statement stmt = co.createStatement();
				ResultSet rs = stmt.executeQuery(query); 
		) {			
//			while( rs.next() ) {
//				 
//				long sectionId =  rs.getLong( "section_id" );
//				String sectionName = rs.getString( "section_name" );
//				long delegateId = rs.getLong(3);
//				
//				list.add(new Section(sectionId, sectionName, delegateId));
//			}
			
			Section s = null;
			while( (s = mapNext(rs)) != null ) {
				list.add(s);
			}
			
			return list;
		}
		catch(SQLException ignored) {}
		
		return null;
		
		
	}
	
	public Section getOne(long id) throws ElementNotFoundException {
		
		String query = "SELECT * FROM section WHERE section_id = "+ id;

		try ( 
				Connection co = ConnectionFactory.getConnection();
				Statement stmt = co.createStatement();
				ResultSet rs = stmt.executeQuery(query); 
		) {			
//			if( rs.next() ) {
//				 
//				long sectionId =  rs.getLong( "section_id" );
//				String sectionName = rs.getString( "section_name" );
//				long delegateId = rs.getLong(3);
//				
//				return new Section(sectionId, sectionName, delegateId);
//			}
//			
//			throw new ElementNotFoundException(id);
			
			Section s = null;
			if( (s = mapNext(rs)) != null )
				return s;
			
			throw new ElementNotFoundException(s);
		}
		catch(SQLException ignored) {}
		
		return null;
	}
	
	
	public boolean insert(Section toInsert) {
		
		if(toInsert == null)
			return false;
		
		String query = "INSERT INTO"
				+ " section VALUES "
				+ " (?,?,?)";
		
		try (
			Connection co = ConnectionFactory.getConnection();
			PreparedStatement stmt = co.prepareStatement(query);
		){
			
			stmt.setLong(1, toInsert.getId());
			stmt.setString(2, toInsert.getName());
			stmt.setLong(3, toInsert.getDelegate());
			
			int affected = stmt.executeUpdate();
			return affected == 1;
		}
		catch(SQLException ex) {}
		
		return false;
		
	}
	
	public boolean update(long id, Section values) {
		
		String query = "UPDATE section SET "
				+ " section_id = ?,"
				+ " section_name = ?, "
				+ " delegate_id = ? "
				+ " WHERE section_id = ?";
		
		try (
			Connection co = ConnectionFactory.getConnection();
			PreparedStatement stmt = co.prepareStatement(query);
		){
			
			stmt.setLong(1, values.getId());
			stmt.setString(2, values.getName());
			stmt.setLong(3, values.getDelegate());
			
			stmt.setLong(4, id);
			
			int affected = stmt.executeUpdate();
			return affected == 1;
		}
		catch(SQLException ex) {}
		
		return false;
	
	}
	
	
	public Section delete(long id) {
		
		
		
		return null;
	}
	
	
	
	private Section mapNext(ResultSet rs) throws SQLException {
		if(rs!=null && rs.next()) {
			long sectionId =  rs.getLong( "section_id" );
			String sectionName = rs.getString( "section_name" );
			long delegateId = rs.getLong( "delegate_id" );
			
			return new Section(sectionId, sectionName, delegateId);
		}
		
		return null;
	}
	
}
