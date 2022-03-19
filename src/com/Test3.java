package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test3 {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@XE","system","password");
		Statement st =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select emp,eid,eaddr from employee");
		rs.first();
		if(rs.first()) {
			System.out.println("data deleted");
		}
		rs.deleteRow();
		
		con.close();
	}

}
