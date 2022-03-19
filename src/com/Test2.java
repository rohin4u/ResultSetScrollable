package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test2 {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@XE","system","password");
		
		System.out.println(con);
		Statement st =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select emp,eid,eaddr from employee");
		System.out.println("Records Before Updation");
		System.out.println("EMP\tEID\tEADDR");
		System.out.println("---------------------------");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
					}
					System.out.println("Application is in pausing state,please update database..");
					System.in.read();
					rs.beforeFirst();
					System.out.println("Records After Updation");
					while(rs.next())
					{
					rs.refreshRow();
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
					}
					 
			con.close();
		}


}
