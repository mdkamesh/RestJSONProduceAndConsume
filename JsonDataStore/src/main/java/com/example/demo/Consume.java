package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class Consume {
	
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Consume.class);
	
	public static void main(String[] ar) throws ClassNotFoundException, SQLException {
		
		RestTemplate rt = new RestTemplate();
		Professor professorJsonData = rt.getForObject("http://localhost:9999/getProfById/1",Professor.class);
		log.info("Finally We are Consuming the Professor Data : "+professorJsonData.getpId()+" "+professorJsonData.getpName());
		Long professorId = professorJsonData.getpId();
		String professorAddress = professorJsonData.getpAddress();
		String professorName = professorJsonData.getpName();
		String professorSubjectName = professorJsonData.getpSubjectName();
		
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/kamesh","root","root");  
		 String query = " insert into Temp (pId, pName, pAddress, PSubjectName)"
			        + " values (?, ?, ?, ?)";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      preparedStmt.setLong(1, professorId);
			      preparedStmt.setString (2, professorAddress);
			      preparedStmt.setString (3, professorName);
			      preparedStmt.setString (4, professorSubjectName);
			      

			      // execute the preparedstatement
			      preparedStmt.execute();
			      
			      con.close();
		
		
	}

}
